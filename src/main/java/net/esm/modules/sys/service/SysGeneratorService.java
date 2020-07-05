package net.esm.modules.sys.service;

import net.esm.common.entity.Page;
import net.esm.modules.sys.entity.GeneratorParamEntity;
import net.esm.modules.sys.entity.TableEntity;

import java.util.Map;

/**
 * 代码生成器
 *
 */
public interface SysGeneratorService {

	/**
	 * 分页查询表格
	 * @param params
	 * @return
	 */
	Page<TableEntity> listTable(Map<String, Object> params);

	/**
	 * 生成代码
	 * @param params
	 * @return
	 */
	byte[] generator(GeneratorParamEntity params);
	
}
