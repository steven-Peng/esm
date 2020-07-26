package net.esm.modules.business.controller;

import net.esm.common.annotation.SysLog;
import net.esm.common.entity.Page;
import net.esm.common.entity.Result;
import net.esm.modules.business.entity.BusiDeviceSensorDataEntity;
import net.esm.modules.business.service.BusiDeviceSensorDataService;
import net.esm.modules.sys.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 设备传感器上传的数据
 * @author pyl<>
 */
@RestController
@RequestMapping("/business/device-sensor-data")
public class BusiDeviceSensorDataController extends AbstractController {
	
	@Autowired
	private BusiDeviceSensorDataService busiDeviceSensorDataService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<BusiDeviceSensorDataEntity> list(@RequestBody Map<String, Object> params) {
		return busiDeviceSensorDataService.listBusiDeviceSensorData(params);
	}
		
	/**
	 * 新增
	 * @param busiDeviceSensorData
	 * @return
	 */
	@SysLog("新增设备传感器上传的数据")
	@RequestMapping("/save")
	public Result save(@RequestBody BusiDeviceSensorDataEntity busiDeviceSensorData) {
		return busiDeviceSensorDataService.saveBusiDeviceSensorData(busiDeviceSensorData);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public Result getById(@RequestBody Long id) {
		return busiDeviceSensorDataService.getBusiDeviceSensorDataById(id);
	}
	
	/**
	 * 修改
	 * @param busiDeviceSensorData
	 * @return
	 */
	@SysLog("修改设备传感器上传的数据")
	@RequestMapping("/update")
	public Result update(@RequestBody BusiDeviceSensorDataEntity busiDeviceSensorData) {
		return busiDeviceSensorDataService.updateBusiDeviceSensorData(busiDeviceSensorData);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除设备传感器上传的数据")
	@RequestMapping("/remove")
	public Result batchRemove(@RequestBody Long[] id) {
		return busiDeviceSensorDataService.batchRemove(id);
	}
	
}
