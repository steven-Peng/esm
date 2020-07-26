package net.esm.modules.sys.controller;

import java.util.List;

import net.esm.common.entity.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.esm.common.annotation.SysLog;
import net.esm.modules.sys.entity.SysMacroEntity;
import net.esm.modules.sys.service.SysMacroService;

/**
 * 通用字典
 *
 */
@RestController
@RequestMapping("/sys/macro")
public class SysMacroController extends AbstractController {

	@Autowired
	private SysMacroService sysMacroService;
	
	/**
	 * 列表
	 * @return
	 */
	@RequestMapping("/list")
	public List<SysMacroEntity> list() {
		return sysMacroService.listMacro();
	}
	
	/**
	 * 树形列表
	 * @return
	 */
	@RequestMapping("/select")
	public List<SysMacroEntity> select() {
		return sysMacroService.listNotMacro();
	}
	
	/**
	 * 新增字典
	 * @param macro
	 * @return
	 */
	@SysLog("新增字典")
	@RequestMapping("/save")
	public Result save(@RequestBody SysMacroEntity macro) {
		return sysMacroService.saveMacro(macro);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public Result info(@RequestBody Long id) {
		return sysMacroService.getObjectById(id);
	}
	
	/**
	 * 修改字典
	 * @param macro
	 * @return
	 */
	@SysLog("修改字典")
	@RequestMapping("/update")
	public Result update(@RequestBody SysMacroEntity macro) {
		return sysMacroService.updateMacro(macro);
	}

	/**
	 * 显示字典
	 * @param id
	 * @return
	 */
	@SysLog("显示字典")
	@RequestMapping("/enable")
	public Result updateStateShow(@RequestBody Long id) {
		SysMacroEntity macro = new SysMacroEntity();
		macro.setMacroId(id);
		macro.setStatus(1);
		return sysMacroService.updateMacro(macro);
	}

	/**
	 * 隐藏字典
	 * @param id
	 * @return
	 */
	@SysLog("隐藏字典")
	@RequestMapping("/disable")
	public Result updateStateHide(@RequestBody Long id) {
		SysMacroEntity macro = new SysMacroEntity();
		macro.setMacroId(id);
		macro.setStatus(0);
		return sysMacroService.updateMacro(macro);
	}
	
	/**
	 * 删除字典
	 * @param id
	 * @return
	 */
	@SysLog("删除字典")
	@RequestMapping("/remove")
	public Result batchRemove(@RequestBody Long[] id) {
		return sysMacroService.batchRemove(id);
	}

	/**
	 * 获取某个类型所有参数值，用于前台构建下拉框
	 * @param value
	 * @return
	 */
	@RequestMapping("/value")
	public List<SysMacroEntity> listMacroValue(@RequestParam String value) {
		return sysMacroService.listMacroValue(value);
	}
	
}
