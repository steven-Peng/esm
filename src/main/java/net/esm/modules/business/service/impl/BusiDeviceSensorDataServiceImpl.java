package net.esm.modules.business.service.impl;

import net.esm.common.entity.Page;
import net.esm.common.entity.Query;
import net.esm.common.entity.Result;
import net.esm.common.utils.CommonUtils;
import net.esm.modules.api.controller.Sensor;
import net.esm.modules.business.dao.BusiDeviceSensorDataMapper;
import net.esm.modules.business.entity.BusiDeviceSensorDataEntity;
import net.esm.modules.business.service.BusiDeviceSensorDataService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 设备传感器上传的数据
 * @author pyl<>
 */
@Service
public class BusiDeviceSensorDataServiceImpl implements BusiDeviceSensorDataService {

	@Autowired
    private BusiDeviceSensorDataMapper busiDeviceSensorDataMapper;

    /**
     * 分页查询
     * @param params
     * @return
     */
	@Override
	public Page<BusiDeviceSensorDataEntity> listBusiDeviceSensorData(Map<String, Object> params) {
		Query query = new Query(params);
		Page<BusiDeviceSensorDataEntity> page = new Page<>(query);
		busiDeviceSensorDataMapper.listForPage(page, query);
		return page;
	}

    /**
     * 新增
     * @param busiDeviceSensorData
     * @return
     */
	@Override
	public Result saveBusiDeviceSensorData(BusiDeviceSensorDataEntity busiDeviceSensorData) {
		int count = busiDeviceSensorDataMapper.save(busiDeviceSensorData);
		return CommonUtils.msg(count);
	}

    /**
     * 根据id查询
     * @param id
     * @return
     */
	@Override
	public Result getBusiDeviceSensorDataById(Long id) {
		BusiDeviceSensorDataEntity busiDeviceSensorData = busiDeviceSensorDataMapper.getObjectById(id);
		return CommonUtils.msg(busiDeviceSensorData);
	}

    /**
     * 修改
     * @param busiDeviceSensorData
     * @return
     */
	@Override
	public Result updateBusiDeviceSensorData(BusiDeviceSensorDataEntity busiDeviceSensorData) {
		int count = busiDeviceSensorDataMapper.update(busiDeviceSensorData);
		return CommonUtils.msg(count);
	}

    /**
     * 删除
     * @param id
     * @return
     */
	@Override
	public Result batchRemove(Long[] id) {
		int count = busiDeviceSensorDataMapper.batchRemove(id);
		return CommonUtils.msg(id, count);
	}

	@Override
	public Result selectHistoryData(String deviceNumber, String start, String end) {
		if(StringUtils.isEmpty(deviceNumber)){
			deviceNumber ="0476-AH-5A02";
		}
		SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if (StringUtils.isEmpty(start)){
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new Date());
			calendar.set(Calendar.HOUR_OF_DAY, 0);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
			Date zero = calendar.getTime();
			start= sdf1.format(zero);
		}
		if (StringUtils.isEmpty(end)){
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new Date());
			Date now = calendar.getTime();
			end= sdf1.format(now);
		}
		List<BusiDeviceSensorDataEntity> busiDeviceSensorDataEntityList = busiDeviceSensorDataMapper.listbyTime(deviceNumber,start,end);
		Map<String,List<Double>> dataList = new HashMap<>();
		Map<String,List<Date>> times = new HashMap<>();
		busiDeviceSensorDataEntityList.forEach(i->{
			String data = i.getSensorData();
			String[] sensorDatas = data.split("\\|");

			for (String sensorData:sensorDatas){
				String[] datas = sensorData.split(" ");
				Sensor sensor1 = new Sensor();
				sensor1.setSensorNum(datas[0]);
				if(dataList.get(datas[0])==null){
					List<Double> doubles = new ArrayList<>();
					doubles.add(Double.parseDouble(datas[2]));
					dataList.put(datas[0],doubles);
				}else {
					dataList.get(datas[0]).add(Double.parseDouble(datas[2]));
				}
				if (times.get(datas[0])==null){
					List<Date> dates = new ArrayList<>();
					dates.add(i.getGmtUpload());
					times.put(datas[0],dates);
				}else {
					times.get(datas[0]).add(i.getGmtUpload());
				}
			}
		});
		List<Sensor> sensorList =new ArrayList<>();
		dataList.forEach((k,v)->{
			Sensor sensor = new Sensor();
			sensor.setSensorNum(k);
			sensor.setData(v);
			sensorList.add(sensor);
		});
		sensorList.forEach(i->{
			String sensorNumber = i.getSensorNum();
			i.setCollectTime(times.get(sensorNumber));
		});
		return CommonUtils.msg(sensorList);
	}

}
