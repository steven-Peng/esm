package net.esm.modules.business.service.impl;

import java.util.Map;

import net.esm.common.entity.Page;
import net.esm.common.entity.Query;
import net.esm.common.entity.Result;
import net.esm.common.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import net.esm.modules.business.entity.SensorAlarmEntity;
import net.esm.modules.business.dao.SensorAlarmMapper;
import net.esm.modules.business.service.SensorAlarmService;

/**
 * 预警表
 * @author pyl<>
 */
@Service("sensorAlarmService")
public class SensorAlarmServiceImpl implements SensorAlarmService {

	@Autowired
    private SensorAlarmMapper sensorAlarmMapper;

    /**
     * 分页查询
     * @param params
     * @return
     */
	@Override
	public Page<SensorAlarmEntity> listSensorAlarm(Map<String, Object> params) {
		Query query = new Query(params);
		Page<SensorAlarmEntity> page = new Page<>(query);
		sensorAlarmMapper.listForPage(page, query);
		return page;
	}

    /**
     * 新增
     * @param sensorAlarm
     * @return
     */
	@Override
	public Result saveSensorAlarm(SensorAlarmEntity sensorAlarm) {
		int count = sensorAlarmMapper.save(sensorAlarm);
		return CommonUtils.msg(count);
	}

    /**
     * 根据id查询
     * @param id
     * @return
     */
	@Override
	public Result getSensorAlarmById(Long id) {
		SensorAlarmEntity sensorAlarm = sensorAlarmMapper.getObjectById(id);
		return CommonUtils.msg(sensorAlarm);
	}

    /**
     * 修改
     * @param sensorAlarm
     * @return
     */
	@Override
	public Result updateSensorAlarm(SensorAlarmEntity sensorAlarm) {
		int count = sensorAlarmMapper.update(sensorAlarm);
		return CommonUtils.msg(count);
	}

    /**
     * 删除
     * @param id
     * @return
     */
	@Override
	public Result batchRemove(Long[] id) {
		int count = sensorAlarmMapper.batchRemove(id);
		return CommonUtils.msg(id, count);
	}

}
