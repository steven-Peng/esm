package net.esm.modules.business.dao;

import net.esm.modules.sys.dao.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import net.esm.modules.business.entity.SensorAlarmEntity;


/**
 * 预警表
 * @author pyl<>
 */
@Mapper
public interface SensorAlarmMapper extends BaseMapper<SensorAlarmEntity> {
	
}
