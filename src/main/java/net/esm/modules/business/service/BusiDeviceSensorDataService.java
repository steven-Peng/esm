package net.esm.modules.business.service;

import net.esm.common.entity.Page;
import net.esm.common.entity.Result;
import net.esm.modules.business.entity.BusiDeviceSensorDataEntity;

import java.util.Map;

/**
 * 设备传感器上传的数据
 * @author pyl<>
 */
public interface BusiDeviceSensorDataService {

    /**
     * 分页查询
     * @param params
     * @return
     */
	Page<BusiDeviceSensorDataEntity> listBusiDeviceSensorData(Map<String, Object> params);

    /**
     * 新增
     * @param busiDeviceSensorData
     * @return
     */
	Result saveBusiDeviceSensorData(BusiDeviceSensorDataEntity busiDeviceSensorData);

    /**
     * 根据id查询
     * @param id
     * @return
     */
	Result getBusiDeviceSensorDataById(Long id);

    /**
     * 修改
     * @param busiDeviceSensorData
     * @return
     */
	Result updateBusiDeviceSensorData(BusiDeviceSensorDataEntity busiDeviceSensorData);

    /**
     * 删除
     * @param id
     * @return
     */
	Result batchRemove(Long[] id);
	
}
