package net.esm.modules.business.service;

import java.util.Map;


import net.esm.common.entity.Page;
import net.esm.common.entity.Result;
import net.esm.modules.business.entity.SensorAlarmEntity;

/**
 * 预警表
 * @author pyl<>
 */
public interface SensorAlarmService {

    /**
     * 分页查询
     * @param params
     * @return
     */
	Page<SensorAlarmEntity> listSensorAlarm(Map<String, Object> params);

    /**
     * 新增
     * @param sensorAlarm
     * @return
     */
	Result saveSensorAlarm(SensorAlarmEntity sensorAlarm);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    Result getSensorAlarmById(Long id);

    /**
     * 修改
     * @param sensorAlarm
     * @return
     */
    Result updateSensorAlarm(SensorAlarmEntity sensorAlarm);

    /**
     * 删除
     * @param id
     * @return
     */
    Result batchRemove(Long[] id);
	
}
