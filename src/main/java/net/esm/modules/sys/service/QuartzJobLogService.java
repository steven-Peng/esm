package net.esm.modules.sys.service;

import net.esm.common.entity.Page;
import net.esm.common.entity.Result;
import net.esm.modules.sys.entity.QuartzJobLogEntity;

import java.util.Map;

/**
 * 定时任务日志
 *
 */
public interface QuartzJobLogService {

	/**
	 * 分页查询任务日志
	 * @param params
	 * @return
	 */
	Page<QuartzJobLogEntity> listForPage(Map<String, Object> params);

	/**
	 * 批量删除日志
	 * @param id
	 * @return
	 */
	Result batchRemove(Long[] id);

	/**
	 * 清空日志
	 * @return
	 */
	Result batchRemoveAll();
	
}
