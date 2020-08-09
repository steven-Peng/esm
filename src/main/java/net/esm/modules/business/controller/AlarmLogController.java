package net.esm.modules.business.controller;

import java.util.Map;

import net.esm.modules.sys.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.esm.common.annotation.SysLog;
import net.esm.common.entity.Page;
import net.esm.common.entity.Result;
import net.esm.modules.business.entity.AlarmLogEntity;
import net.esm.modules.business.service.AlarmLogService;

/**
 * 预警日志表
 * @author pyl<>
 */
@RestController
@RequestMapping("/business/alarmLog")
public class AlarmLogController extends AbstractController {
	
	@Autowired
	private AlarmLogService alarmLogService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<AlarmLogEntity> list(@RequestBody Map<String, Object> params) {
		return alarmLogService.listAlarmLog(params);
	}
		
	/**
	 * 新增
	 * @param alarmLog
	 * @return
	 */
	@SysLog("新增预警日志表")
	@RequestMapping("/save")
	public Result save(@RequestBody AlarmLogEntity alarmLog) {
		return alarmLogService.saveAlarmLog(alarmLog);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @returnResult
	 */
	@RequestMapping("/info")
	public Result getById(@RequestBody Long id) {
		return alarmLogService.getAlarmLogById(id);
	}
	
	/**
	 * 修改
	 * @param alarmLog
	 * @return
	 */
	@SysLog("修改预警日志表")
	@RequestMapping("/update")
	public Result update(@RequestBody AlarmLogEntity alarmLog) {
		return alarmLogService.updateAlarmLog(alarmLog);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除预警日志表")
	@RequestMapping("/remove")
	public Result batchRemove(@RequestBody Long[] id) {
		return alarmLogService.batchRemove(id);
	}
	
}
