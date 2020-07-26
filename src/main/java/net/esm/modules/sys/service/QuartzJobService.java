package net.esm.modules.sys.service;

import net.esm.common.entity.Page;
import net.esm.common.entity.Result;
import net.esm.modules.sys.entity.QuartzJobEntity;

import java.util.Map;

/**
 * 定时任务
 *
 */
public interface QuartzJobService {

	/**
	 * 分页查询任务
	 * @param params
	 * @return
	 */
	Page<QuartzJobEntity> list(Map<String, Object> params);

	/**
	 * 新增任务
	 * @param job
	 * @return
	 */
	Result saveQuartzJob(QuartzJobEntity job);

	/**
	 * 根据id查询任务
	 * @param jobId
	 * @return
	 */
	Result getQuartzJobById(Long jobId);

	/**
	 * 修改任务
	 * @param job
	 * @return
	 */
	Result updateQuartzJob(QuartzJobEntity job);

	/**
	 * 批量删除任务
	 * @param id
	 * @return
	 */
	Result batchRemoveQuartzJob(Long[] id);

	/**
	 * 立即运行任务
	 * @param id
	 * @return
	 */
	Result run(Long[] id);

	/**
	 * 暂停任务
	 * @param id
	 * @return
	 */
	Result pause(Long[] id);

	/**
	 * 恢复任务
	 * @param id
	 * @return
	 */
	Result resume(Long[] id);
	
}
