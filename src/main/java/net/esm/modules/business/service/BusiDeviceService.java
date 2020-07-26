package net.esm.modules.business.service;

import net.esm.common.entity.Page;
import net.esm.common.entity.Result;
import net.esm.modules.business.entity.BusiDeviceEntity;
import net.esm.modules.business.pojo.DeviceDataOutput;

import java.util.Map;


/**
 * 设备表
 * @author pyl<>
 */
public interface BusiDeviceService {

    /**
     * 分页查询
     * @param params
     * @return
     */
	Page<BusiDeviceEntity> listBusiDevice(Map<String, Object> params);

    /**
     * 分页查询
     * @param params
     * @return
     */
    Page<DeviceDataOutput> listDeviceData(Map<String, Object> params);

    /**
     * 新增
     * @param busiDevice
     * @return
     */
	Result saveBusiDevice(BusiDeviceEntity busiDevice);

    /**
     * 新增/更新
     * @param busiDevice
     * @return
     */
    Result saveDeviceInfo(String[] busiDevice);

    /**
     * 根据id查询
     * @param id
     * @return
     */
	Result getBusiDeviceById(Long id);

    /**
     * 修改
     * @param busiDevice
     * @return
     */
	Result updateBusiDevice(BusiDeviceEntity busiDevice);

    /**
     * 删除
     * @param id
     * @return
     */
	Result batchRemove(Long[] id);
	
}
