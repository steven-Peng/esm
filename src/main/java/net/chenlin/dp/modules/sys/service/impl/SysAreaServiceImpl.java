package net.chenlin.dp.modules.sys.service.impl;

import net.chenlin.dp.common.constant.MsgConstant;
import net.chenlin.dp.common.entity.Query;
import net.chenlin.dp.common.entity.R;
import net.chenlin.dp.common.utils.CommonUtils;
import net.chenlin.dp.modules.sys.dao.SysAreaMapper;
import net.chenlin.dp.modules.sys.entity.SysAreaEntity;
import net.chenlin.dp.modules.sys.service.SysAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 行政区域
 * @author zcl<yczclcn@163.com>
 */
@Service("sysAreaService")
public class SysAreaServiceImpl implements SysAreaService {

	@Autowired
	private SysAreaMapper sysAreaMapper;

	/**
	 * 根据父级id查询区域：ztree异步数据源
	 * @param areaCode
	 * @return
	 */
	@Override
	public List<SysAreaEntity> listAreaByParentCode(String areaCode) {
		Query query = new Query();
		query.put("parentCode", areaCode);
		List<SysAreaEntity> areas = sysAreaMapper.listAreaByParentCode(query);
		for(SysAreaEntity area : areas) {
			area.checkParent();
		}
		return areas;
	}

	/**
	 * 新增区域
	 * @param area
	 * @return
	 */
	@Override
	public R saveArea(SysAreaEntity area) {
		int count = sysAreaMapper.save(area);
		return CommonUtils.msg(count);
	}

	/**
	 * 根据id查询区域
	 * @param areaId
	 * @return
	 */
	@Override
	public R getAreaById(Long areaId) {
		SysAreaEntity area = sysAreaMapper.getObjectById(areaId);
		area.checkParentName();
		return CommonUtils.msg(area);
	}

	/**
	 * 修改区域
	 * @param area
	 * @return
	 */
	@Override
	public R updateArea(SysAreaEntity area) {
		int count = sysAreaMapper.update(area);
		return CommonUtils.msg(count);
	}

	/**
	 * 批量删除区域
	 * @param id
	 * @return
	 */
	@Override
	public R batchRemoveArea(Long[] id) {
		boolean children = false;
		for(Long typeId : id) {
			int count = sysAreaMapper.countAreaChildren(typeId);
			if(CommonUtils.isIntThanZero(count)) {
				children = true;
			}
		}
		if(children) {
			return R.error(MsgConstant.MSG_HAS_CHILD);
		}
		int count = sysAreaMapper.batchRemove(id);
		return CommonUtils.msg(id, count);
	}

	/**
	 * 根据父级id查询区域：表格数据源
	 * @param params
	 * @return
	 */
	@Override
	public R listAreaByParentCode(Map<String, Object> params) {
		Query query = new Query(params);
		List<SysAreaEntity> areas = sysAreaMapper.listAreaByParentCode(query);
		return CommonUtils.msg(areas);
	}

}
