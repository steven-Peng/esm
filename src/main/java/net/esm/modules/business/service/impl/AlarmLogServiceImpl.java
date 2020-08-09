package net.esm.modules.business.service.impl;

import java.util.Map;

import com.sun.org.apache.regexp.internal.RE;
import net.esm.common.entity.Page;
import net.esm.common.entity.Query;
import net.esm.common.entity.Result;
import net.esm.common.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import net.esm.modules.business.entity.AlarmLogEntity;
import net.esm.modules.business.dao.AlarmLogMapper;
import net.esm.modules.business.service.AlarmLogService;

/**
 * 预警日志表
 * @author pyl<>
 */
@Service("alarmLogService")
public class AlarmLogServiceImpl implements AlarmLogService {

	@Autowired
    private AlarmLogMapper alarmLogMapper;

    /**
     * 分页查询
     * @param params
     * @return
     */
	@Override
	public Page<AlarmLogEntity> listAlarmLog(Map<String, Object> params) {
		Query query = new Query(params);
		Page<AlarmLogEntity> page = new Page<>(query);
		alarmLogMapper.listForPage(page, query);
		return page;
	}

    /**
     * 新增
     * @param alarmLog
     * @return
     */
	@Override
	public Result saveAlarmLog(AlarmLogEntity alarmLog) {
		int count = alarmLogMapper.save(alarmLog);
		return CommonUtils.msg(count);
	}

    /**
     * 根据id查询
     * @param id
     * @return
     */
	@Override
	public Result getAlarmLogById(Long id) {
		AlarmLogEntity alarmLog = alarmLogMapper.getObjectById(id);
		return CommonUtils.msg(alarmLog);
	}

    /**
     * 修改
     * @param alarmLog
     * @return
     */
	@Override
	public Result updateAlarmLog(AlarmLogEntity alarmLog) {
		int count = alarmLogMapper.update(alarmLog);
		return CommonUtils.msg(count);
	}

    /**
     * 删除
     * @param id
     * @return
     */
	@Override
	public Result batchRemove(Long[] id) {
		int count = alarmLogMapper.batchRemove(id);
		return CommonUtils.msg(id, count);
	}

}
