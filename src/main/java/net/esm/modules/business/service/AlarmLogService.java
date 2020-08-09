package net.esm.modules.business.service;

import java.util.Map;


import net.esm.common.entity.Page;
import net.esm.common.entity.Result;
import net.esm.modules.business.entity.AlarmLogEntity;

/**
 * 预警日志表
 * @author pyl<>
 */
public interface AlarmLogService {

    /**
     * 分页查询
     * @param params
     * @return
     */
	Page<AlarmLogEntity> listAlarmLog(Map<String, Object> params);

    /**
     * 新增
     * @param alarmLog
     * @return
     */
    Result saveAlarmLog(AlarmLogEntity alarmLog);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    Result getAlarmLogById(Long id);

    /**
     * 修改
     * @param alarmLog
     * @return
     */
    Result updateAlarmLog(AlarmLogEntity alarmLog);

    /**
     * 删除
     * @param id
     * @return
     */
    Result batchRemove(Long[] id);
	
}
