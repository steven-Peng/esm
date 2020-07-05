package net.esm.modules.sys.dao;

import java.util.List;

import net.esm.common.entity.Page;
import net.esm.common.entity.Query;
import net.esm.modules.sys.entity.ColumnEntity;
import net.esm.modules.sys.entity.TableEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 代码生成器
 *
 */
@Mapper
public interface SysGeneratorMapper {

	/**
	 * 查询所有表格
	 * @param page
	 * @param query
	 * @return
	 */
	List<TableEntity> listTable(Page<TableEntity> page, Query query);

	/**
	 * 根据名称查询
	 * @param tableName
	 * @return
	 */
	TableEntity getTableByName(String tableName);

	/**
	 * 查询所有列
	 * @param tableName
	 * @return
	 */
	List<ColumnEntity> listColumn(String tableName);
	
}
