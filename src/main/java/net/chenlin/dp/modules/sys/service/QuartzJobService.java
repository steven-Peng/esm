package net.chenlin.dp.modules.sys.service;

import net.chenlin.dp.common.entity.Page;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.modules.sys.entity.QuartzJobEntity;

import java.util.Map;

/**
 * 定时任务
 * @author zcl<yczclcn@163.com>
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
	R saveQuartzJob(QuartzJobEntity job);

	/**
	 * 根据id查询任务
	 * @param jobId
	 * @return
	 */
	R getQuartzJobById(Long jobId);

	/**
	 * 修改任务
	 * @param job
	 * @return
	 */
	R updateQuartzJob(QuartzJobEntity job);

	/**
	 * 批量删除任务
	 * @param id
	 * @return
	 */
	R batchRemoveQuartzJob(Long[] id);

	/**
	 * 立即运行任务
	 * @param id
	 * @return
	 */
	R run(Long[] id);

	/**
	 * 暂停任务
	 * @param id
	 * @return
	 */
	R pause(Long[] id);

	/**
	 * 恢复任务
	 * @param id
	 * @return
	 */
	R resume(Long[] id);
	
}
