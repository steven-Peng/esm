package net.esm.modules.sys.service;

import net.esm.common.entity.Page;
import net.esm.common.entity.Result;
import net.esm.modules.sys.entity.SysUserEntity;
import net.esm.modules.sys.entity.SysUserTokenEntity;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 系统用户
 *
 */
public interface SysUserService {

	/**
	 * 分页查询用户列表
	 * @param params
	 * @return
	 */
	Page<SysUserEntity> listUser(Map<String, Object> params);

	/**
	 * 新增用户
	 * @param user
	 * @return
	 */
	Result saveUser(SysUserEntity user);

	/**
	 * 根据id查询用户
	 * @param userId
	 * @return
	 */
	Result getUserById(Long userId);

	/**
	 * 修改用户
	 * @param user
	 * @return
	 */
	Result updateUser(SysUserEntity user);

	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
	Result batchRemove(Long[] id);

	/**
	 * 查询用户权限集合
	 * @param userId
	 * @return
	 */
	Set<String> listUserPerms(Long userId);

	/**
	 * 查询用户角色集合
	 * @param userId
	 * @return
	 */
	Set<String> listUserRoles(Long userId);

	/**
	 * 用户修改密码
	 * @param user
	 * @return
	 */
	Result updatePswdByUser(SysUserEntity user);

	/**
	 * 启用用户
	 * @param id
	 * @return
	 */
	Result updateUserEnable(Long[] id);

	/**
	 * 禁用用户
	 * @param id
	 * @return
	 */
	Result updateUserDisable(Long[] id);

	/**
	 * 重置用户密码
	 * @param user
	 * @return
	 */
	Result updatePswd(SysUserEntity user);

	/**
	 * 根据用户名查询用户信息
	 * @param username
	 * @return
	 */
	SysUserEntity getByUserName(String username);

	/**
	 * 用户所有机构id
	 * @param userId
	 * @return
	 */
	List<Long> listAllOrgId(Long userId);

	/**
	 * 保存用户token
	 * @param userId
	 * @return
	 */
	int saveOrUpdateToken(Long userId, String token);

	/**
	 * 根据token查询
	 * @param token
	 * @return
	 */
	SysUserTokenEntity getUserTokenByToken(String token);

	/**
	 * 根据userId查询
	 * @param userId
	 * @return
	 */
	SysUserTokenEntity getUserTokenByUserId(Long userId);

	/**
	 * 根据userId查询：用于token校验
	 * @param userId
	 * @return
	 */
	SysUserEntity getUserByIdForToken(Long userId);
	
}
