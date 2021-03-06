package net.esm.modules.business.dao;

import net.esm.modules.business.entity.BusiDeviceEntity;
import net.esm.modules.sys.dao.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 设备表
 * @author pyl<>
 */
@Mapper
public interface BusiDeviceMapper extends BaseMapper<BusiDeviceEntity> {

    BusiDeviceEntity getDeviceByNumber(String number);

    List<BusiDeviceEntity> getDeviceByAddress(String address);
}
