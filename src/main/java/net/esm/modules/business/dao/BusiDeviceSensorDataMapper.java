package net.esm.modules.business.dao;

import net.esm.modules.business.entity.BusiDeviceSensorDataEntity;
import net.esm.modules.sys.dao.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 设备传感器上传的数据
 * @author pyl<>
 */
@Mapper
public interface BusiDeviceSensorDataMapper extends BaseMapper<BusiDeviceSensorDataEntity> {

    List<BusiDeviceSensorDataEntity> listLatestSensorData(Integer minutes);
    List<BusiDeviceSensorDataEntity> listbyTime(@Param("deviceNumber")String deviceNumber,
                                                @Param("start")String start,
                                                @Param("end") String end);
}
