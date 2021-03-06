package net.esm.modules.sys.service;

import net.esm.common.entity.Result;
import net.esm.modules.sys.entity.SysMenuEntity;

import java.util.List;
import java.util.Map;

/**
 * 系统菜单
 *
 */
public interface SysMenuService {

	/**
	 * 查询用户菜单
	 * @param userId
	 * @return
	 */
	Result listUserMenu(Long userId);

	/**
	 * 查询菜单列表
	 * @param params
	 * @return
	 */
	List<SysMenuEntity> listMenu(Map<String, Object> params);

	/**
	 * 查询目录和菜单
	 * @return
	 */
	Result listNotButton();

	/**
	 * 新增菜单
	 * @param menu
	 * @return
	 */
	Result saveMenu(SysMenuEntity menu);

	/**
	 * 根据id查询菜单
	 * @param id
	 * @return
	 */
	Result getMenuById(Long id);

	/**
	 * 修改菜单
	 * @param menu
	 * @return
	 */
	Result updateMenu(SysMenuEntity menu);

	/**
	 * 删除菜单
	 * @param id
	 * @return
	 */
	Result batchRemove(Long[] id);

}
