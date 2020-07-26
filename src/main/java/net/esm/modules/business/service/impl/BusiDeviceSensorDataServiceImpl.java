package net.esm.modules.business.service.impl;

import net.esm.common.entity.Page;
import net.esm.common.entity.Query;
import net.esm.common.entity.Result;
import net.esm.common.utils.CommonUtils;
import net.esm.modules.business.dao.BusiDeviceSensorDataMapper;
import net.esm.modules.business.entity.BusiDeviceSensorDataEntity;
import net.esm.modules.business.service.BusiDeviceSensorDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

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

}
