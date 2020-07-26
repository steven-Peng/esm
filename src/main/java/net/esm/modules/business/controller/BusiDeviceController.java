package net.esm.modules.business.controller;

import net.esm.common.annotation.SysLog;
import net.esm.common.entity.Page;
import net.esm.common.entity.Result;
import net.esm.modules.business.entity.BusiDeviceEntity;
import net.esm.modules.business.pojo.DeviceDataOutput;
import net.esm.modules.business.service.BusiDeviceService;
import net.esm.modules.sys.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


/**
 * 设备表
 * @author pyl<>
 */
@RestController
@RequestMapping("/business/device")
public class BusiDeviceController extends AbstractController {
	
	@Autowired
	private BusiDeviceService busiDeviceService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<BusiDeviceEntity> list(@RequestBody Map<String, Object> params) {
		return busiDeviceService.listBusiDevice(params);
	}

	/**
	 * 最新数据列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/data/list")
	public Page<DeviceDataOutput> dataList(@RequestBody Map<String, Object> params) {
		return busiDeviceService.listDeviceData(params);
	}
		
	/**
	 * 新增
	 * @param busiDevice
	 * @return
	 */
	@SysLog("新增设备表")
	@RequestMapping("/save")
	public Result save(@RequestBody BusiDeviceEntity busiDevice) {
		return busiDeviceService.saveBusiDevice(busiDevice);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public Result getById(@RequestBody Long id) {
		return busiDeviceService.getBusiDeviceById(id);
	}
	
	/**
	 * 修改
	 * @param busiDevice
	 * @return
	 */
	@SysLog("修改设备表")
	@RequestMapping("/update")
	public Result update(@RequestBody BusiDeviceEntity busiDevice) {
		return busiDeviceService.updateBusiDevice(busiDevice);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除设备表")
	@RequestMapping("/remove")
	public Result batchRemove(@RequestBody Long[] id) {
		return busiDeviceService.batchRemove(id);
	}
	
}
