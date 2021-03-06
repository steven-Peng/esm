package net.esm.modules.sys.controller;

import java.util.Map;

import net.esm.common.entity.Result;
import net.esm.common.utils.CommonUtils;
import net.esm.common.entity.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.esm.common.annotation.SysLog;
import net.esm.common.constant.SystemConstant;
import net.esm.modules.sys.entity.SysUserEntity;
import net.esm.modules.sys.service.SysUserService;

/**
 * 系统用户
 *
 */
@RestController
@RequestMapping("/sys/user")
public class SysUserController extends AbstractController {
	
	@Autowired
	private SysUserService sysUserService;
	
	/**
	 * 用户列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<SysUserEntity> list(@RequestBody Map<String, Object> params) {
		if(getUserId() != SystemConstant.SUPER_ADMIN) {
			params.put("userIdCreate", getUserId());
		}
		return sysUserService.listUser(params);
	}
	
	/**
	 * 获取登录的用户信息
	 */
	@RequestMapping("/info")
	public Result info(){
		return Result.ok().put("user", getUser());
	}
	
	/**
	 * 用户权限
	 * @return
	 */
	@RequestMapping("/perms")
	public Result listUserPerms() {
		return CommonUtils.msgNotCheckNull(sysUserService.listUserPerms(getUserId()));
	}
	
	/**
	 * 新增用户
	 * @param user
	 * @return
	 */
	@SysLog("新增用户")
	@RequestMapping("/save")
	public Result save(@RequestBody SysUserEntity user) {
		user.setUserIdCreate(getUserId());
		return sysUserService.saveUser(user);
	}
	
	/**
	 * 根据id查询详情
	 * @param userId
	 * @return
	 */
	@RequestMapping("/infoUser")
	public Result getById(@RequestBody Long userId) {
		return sysUserService.getUserById(userId);
	}
	
	/**
	 * 修改用户
	 * @param user
	 * @return
	 */
	@SysLog("修改用户")
	@RequestMapping("/update")
	public Result update(@RequestBody SysUserEntity user) {
		return sysUserService.updateUser(user);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除用户")
	@RequestMapping("/remove")
	public Result batchRemove(@RequestBody Long[] id) {
		return sysUserService.batchRemove(id);
	}
	
	/**
	 * 用户修改密码
	 * @param pswd
	 * @param newPswd
	 * @return
	 */
	@SysLog("修改密码")
	@RequestMapping("/updatePswd")
	public Result updatePswdByUser(String pswd, String newPswd) {
		SysUserEntity user = getUser();
		user.setPassword(pswd);//原密码
		user.setEmail(newPswd);//邮箱临时存储新密码
		return sysUserService.updatePswdByUser(user);
	}
	
	/**
	 * 启用账户
	 * @param id
	 * @return
	 */
	@SysLog("启用账户")
	@RequestMapping("/enable")
	public Result updateUserEnable(@RequestBody Long[] id) {
		return sysUserService.updateUserEnable(id);
	}
	
	/**
	 * 禁用账户
	 * @param id
	 * @return
	 */
	@SysLog("禁用账户")
	@RequestMapping("/disable")
	public Result updateUserDisable(@RequestBody Long[] id) {
		return sysUserService.updateUserDisable(id);
	}
	
	/**
	 * 重置密码
	 * @param user
	 * @return
	 */
	@SysLog("重置密码")
	@RequestMapping("/reset")
	public Result updatePswd(@RequestBody SysUserEntity user) {
		return sysUserService.updatePswd(user);
	}
}
