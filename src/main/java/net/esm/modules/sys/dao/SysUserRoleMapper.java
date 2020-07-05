package net.esm.modules.sys.dao;

import java.util.List;

import net.esm.modules.sys.entity.SysUserRoleEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户与角色关系
 *
 */
@Mapper
public interface SysUserRoleMapper extends BaseMapper<SysUserRoleEntity> {

	/**
	 * 查询用户所有角色id
	 * @param userId
	 * @return
	 */
	List<Long> listUserRoleId(Long userId);

	/**
	 * 根据用户id删除
	 * @param id
	 * @return
	 */
	int batchRemoveByUserId(Long[] id);

	/**
	 * 根据角色id删除
	 * @param id
	 * @return
	 */
	int batchRemoveByRoleId(Long[] id);
	
}
