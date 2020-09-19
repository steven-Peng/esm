package net.esm.modules.business.service.impl;

import net.esm.common.entity.Page;
import net.esm.common.entity.Query;
import net.esm.common.entity.Result;
import net.esm.common.utils.CommonUtils;
import net.esm.common.utils.DateUtils;
import net.esm.modules.business.dao.BusiDeviceMapper;
import net.esm.modules.business.dao.BusiDeviceSensorDataMapper;
import net.esm.modules.business.entity.BusiDeviceEntity;
import net.esm.modules.business.entity.BusiDeviceSensorDataEntity;
import net.esm.modules.business.enums.Constant;
import net.esm.modules.business.pojo.DeviceDataOutput;
import net.esm.modules.business.service.BusiDeviceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 设备表
 * @author pyl<>
 */
@Service("busiDeviceService")
public class BusiDeviceServiceImpl implements BusiDeviceService {

	@Autowired
    private BusiDeviceMapper busiDeviceMapper;

	@Autowired
	private BusiDeviceSensorDataMapper busiDeviceSensorDataMapper;

    /**
	 * 分页查询
	 * @param params
	 * @return
	 */
	@Override
	public Page<BusiDeviceEntity> listBusiDevice(Map<String, Object> params) {
		Query query = new Query(params);
		Page<BusiDeviceEntity> page = new Page<>(query);
		busiDeviceMapper.listForPage(page, query);
		return page;
	}

	/**
	 * 分页查询
	 * @param params
	 * @return
	 */
	@Override
	public Page<DeviceDataOutput> listDeviceData(Map<String, Object> params) {
		Query query = new Query(params);
		Page<BusiDeviceEntity> page = new Page<>(query);
		busiDeviceMapper.listForPage(page, query);
		List<BusiDeviceSensorDataEntity> deviceSensorDataEntityList = busiDeviceSensorDataMapper.listLatestSensorData(Constant.LATEST_MINUTES);
		Map<String, List<BusiDeviceSensorDataEntity>> sensorMap = deviceSensorDataEntityList.stream().
				collect(Collectors.groupingBy(t -> t.getDeviceNumber()));

		Page<DeviceDataOutput> deviceDataOutputPage = new Page<>(page.getPageNo(), page.getPageSize());
		List<DeviceDataOutput> deviceDataOutputList = new ArrayList<>();
		for (BusiDeviceEntity deviceEntity : page.getRows()){
			DeviceDataOutput output = new DeviceDataOutput();
			BeanUtils.copyProperties(deviceEntity, output);
			deviceDataOutputList.add(output);

			List<BusiDeviceSensorDataEntity> sensorDataEntityListOfNumber = sensorMap.get(deviceEntity.getNumber());
			if (CollectionUtils.isEmpty(sensorDataEntityListOfNumber)){
				continue;
			}

			BusiDeviceSensorDataEntity sensorDataEntity = sensorDataEntityListOfNumber.get(0);
			output.setGmtUpload(sensorDataEntity.getGmtUpload());
			output.setSensorData(sensorDataEntity.getSensorData());
		}
		deviceDataOutputPage.setRows(deviceDataOutputList);
		deviceDataOutputPage.setTotal(page.getTotal());
		deviceDataOutputPage.setTotalPages(page.getTotalPages());

		return deviceDataOutputPage;
	}

    /**
     * 新增
     * @param busiDevice
     * @return
     */
	@Override
	public Result saveBusiDevice(BusiDeviceEntity busiDevice) {
		BusiDeviceEntity device = busiDeviceMapper.getDeviceByNumber(busiDevice.getNumber());
		if (device != null){
			return CommonUtils.msg("该设备已存在");
		}
		busiDevice.setStatus(Constant.STATUS_LOST_CONNECTION);
		if (busiDevice.getEnable() == null){
			busiDevice.setEnable(Constant.ENABLE_NORMAL);
		}
		int count = busiDeviceMapper.save(busiDevice);
		return CommonUtils.msg(count);
	}

	@Override
	public Result saveDeviceInfo(String[] params, String address) {
		// 解析参数，更新数据表
		// NO:0028-XP-6B11:08:101 * +****.***|102 * +****.***|103 *	+****.***|104 * +****.***|105 * +****.***
		// |106 * +****.***|107 * +****.***|108 * +****.***:2020-06-07-08-56-30:END
		BusiDeviceEntity busiDevice = new BusiDeviceEntity();
		busiDevice.setNumber(params[1]);
		busiDevice.setStatus(Constant.STATUS_IN_CONNECTION);
		busiDevice.setEnable(Constant.ENABLE_NORMAL);
		busiDevice.setIsDelete(Constant.DELETE_NO);
		busiDevice.setRemoteAddress(address);

		// 保存设备
		BusiDeviceEntity device = busiDeviceMapper.getDeviceByNumber(busiDevice.getNumber());
		if (device == null){
			busiDevice.setName(busiDevice.getNumber());
			busiDevice.setGmtCreate(new Date());
			busiDeviceMapper.save(busiDevice);
		}else {
			device.setGmtModified(new Date());
			device.setStatus(Constant.STATUS_IN_CONNECTION);
			device.setRemoteAddress(address);
			busiDeviceMapper.update(device);
		}

		// 保存设备传感器数据
		BusiDeviceSensorDataEntity sensorDataEntity = new BusiDeviceSensorDataEntity();
		sensorDataEntity.setDeviceNumber(busiDevice.getNumber());
		sensorDataEntity.setGmtCreate(new Date());
		sensorDataEntity.setGmtUpload(DateUtils.parse(params[4], "yyyy-MM-dd HH-mm-ss"));
		sensorDataEntity.setSensorData(params[3]);
		sensorDataEntity.setIsDelete(Constant.DELETE_NO);
		busiDeviceSensorDataMapper.save(sensorDataEntity);

		return Result.ok();
	}

	/**
     * 根据id查询
     * @param id
     * @return
     */
	@Override
	public Result getBusiDeviceById(Long id) {
		BusiDeviceEntity busiDevice = busiDeviceMapper.getObjectById(id);
		return CommonUtils.msg(busiDevice);
	}

    /**
     * 修改
     * @param busiDevice
     * @return
     */
	@Override
	public Result updateBusiDevice(BusiDeviceEntity busiDevice) {
		int count = busiDeviceMapper.update(busiDevice);
		return CommonUtils.msg(count);
	}

    /**
     * 删除
     * @param id
     * @return
     */
	@Override
	public Result batchRemove(Long[] id) {
		int count = busiDeviceMapper.batchRemove(id);
		return CommonUtils.msg(id, count);
	}

	/**
	 * 更新设备状态 ，记录告警
	 */
	@Override
	public void updateStatusAndSetLog(Integer status, String address) {
		List<BusiDeviceEntity> deviceList = busiDeviceMapper.getDeviceByAddress(address);
		if (deviceList.size() == 0){
			return;
		} else if (deviceList.size() > 1){// 同IP端口存在多个设备，属于异常，只保存告警

		}else {
			deviceList.get(0).setStatus(status);
			busiDeviceMapper.update(deviceList.get(0));
			// TODO 保存告警日志
		}
	}

}
