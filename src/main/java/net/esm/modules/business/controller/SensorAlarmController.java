package net.esm.modules.business.controller;

import java.util.Map;

import net.esm.common.annotation.SysLog;
import net.esm.common.entity.Page;
import net.esm.common.entity.Result;
import net.esm.modules.sys.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import net.esm.modules.business.entity.SensorAlarmEntity;
import net.esm.modules.business.service.SensorAlarmService;

/**
 * 预警表
 * @author pyl<>
 */
@RestController
@RequestMapping("/business/sensorAlarm")
public class SensorAlarmController extends AbstractController {
	
	@Autowired
	private SensorAlarmService sensorAlarmService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<SensorAlarmEntity> list(@RequestBody Map<String, Object> params) {
		return sensorAlarmService.listSensorAlarm(params);
	}
		
	/**
	 * 新增
	 * @param sensorAlarm
	 * @return
	 */
	@SysLog("新增预警表")
	@RequestMapping("/save")
	public Result save(@RequestBody SensorAlarmEntity sensorAlarm) {
		return sensorAlarmService.saveSensorAlarm(sensorAlarm);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public Result getById(@RequestBody Long id) {
		return sensorAlarmService.getSensorAlarmById(id);
	}
	
	/**
	 * 修改
	 * @param sensorAlarm
	 * @return
	 */
	@SysLog("修改预警表")
	@RequestMapping("/update")
	public Result update(@RequestBody SensorAlarmEntity sensorAlarm) {
		return sensorAlarmService.updateSensorAlarm(sensorAlarm);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除预警表")
	@RequestMapping("/remove")
	public Result batchRemove(@RequestBody Long[] id) {
		return sensorAlarmService.batchRemove(id);
	}
	
}
