package net.esm.modules.business.dao;

import net.esm.modules.sys.dao.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import net.esm.modules.business.entity.AlarmLogEntity;

/**
 * 预警日志表
 * @author pyl<>
 */
@Mapper
public interface AlarmLogMapper extends BaseMapper<AlarmLogEntity> {
	
}
