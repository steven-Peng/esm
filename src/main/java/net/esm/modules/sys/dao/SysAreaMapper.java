package net.esm.modules.sys.dao;

import net.esm.common.entity.Query;
import net.esm.modules.sys.entity.SysAreaEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 行政区域
 *
 */
@Mapper
public interface SysAreaMapper extends BaseMapper<SysAreaEntity> {

	/**
	 * 根据父计编码查询
	 * @param query
	 * @return
	 */
	List<SysAreaEntity> listAreaByParentCode(Query query);

	/**
	 * 子节点总数
	 * @param areaId
	 * @return
	 */
	int countAreaChildren(Long areaId);
	
}
