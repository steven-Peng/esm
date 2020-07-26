package net.esm.modules.sys.service.impl;

import net.esm.common.entity.Page;
import net.esm.common.entity.Query;
import net.esm.common.entity.Result;
import net.esm.common.utils.CommonUtils;
import net.esm.modules.sys.dao.QuartzJobLogMapper;
import net.esm.modules.sys.entity.QuartzJobLogEntity;
import net.esm.modules.sys.service.QuartzJobLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 定时任务日志
 *
 */
@Service("quartzJobLogService")
public class QuartzJobLogServiceImpl implements QuartzJobLogService {

	@Autowired
	private QuartzJobLogMapper quartzJobLogMapper;

	/**
	 * 分页查询任务日志
	 * @param params
	 * @return
	 */
	@Override
	public Page<QuartzJobLogEntity> listForPage(Map<String, Object> params) {
		Query query = new Query(params);
		Page<QuartzJobLogEntity> page = new Page<>(query);
		quartzJobLogMapper.listForPage(page, query);
		return page;
	}

	/**
	 * 批量删除日志
	 * @param id
	 * @return
	 */
	@Override
	public Result batchRemove(Long[] id) {
		int count = quartzJobLogMapper.batchRemove(id);
		return CommonUtils.msg(id, count);
	}

	/**
	 * 清空日志
	 * @return
	 */
	@Override
	public Result batchRemoveAll() {
		int count = quartzJobLogMapper.batchRemoveAll();
		return CommonUtils.msg(count);
	}


}
