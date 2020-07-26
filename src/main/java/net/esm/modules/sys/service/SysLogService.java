package net.esm.modules.sys.service;

import net.esm.common.entity.Page;
import net.esm.common.entity.Result;
import net.esm.modules.sys.entity.SysLogEntity;

import java.util.Map;

/**
 * 系统日志
 *
 */
public interface SysLogService {

    /**
     * 分页查询
     * @param params
     * @return
     */
    Page<SysLogEntity> listLog(Map<String, Object> params);

    /**
     * 批量删除
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
