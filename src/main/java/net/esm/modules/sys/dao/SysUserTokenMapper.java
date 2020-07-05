package net.esm.modules.sys.dao;

import net.esm.modules.sys.entity.SysUserTokenEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户token
 *
 */
@Mapper
public interface SysUserTokenMapper extends BaseMapper<SysUserTokenEntity> {

	/**
	 * 根据token查询
	 * @param token
	 * @return
	 */
	SysUserTokenEntity getByToken(String token);

	/**
	 * 根据用户id查询
	 * @param userId
	 * @return
	 */
	SysUserTokenEntity getByUserId(Long userId);
	
}
