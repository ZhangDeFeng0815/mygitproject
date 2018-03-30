package com.tyyd.common.dao;

import java.util.List;
import java.util.Map;

import com.tyyd.common.po.ConfigInfo;
import com.tyyd.framework.core.dao.BaseDao;

public interface ConfigDao extends BaseDao {

	/**
	 * 按条件查询配置 分页
	 * 
	 * @param wkNameList
	 * @param rightBlist
	 * @param params
	 * @param startRow
	 * @param endRow
	 * @return
	 */
	public List<Map<String, Object>> selectConfigsByParamsPage(Integer type, String name, String startRow,
			String endRow);

	/**
	 * 查询配置总记录数
	 * 
	 * @param wkNameList
	 * @param rightBlist
	 * @param params
	 * @return
	 */
	public Integer selectConfigsCountByParams(Integer type, String name);

	/**
	 * 按条件查询配置 无分页
	 * 
	 * @param wkNameList
	 * @param rightBlist
	 * @param params
	 * @param startRow
	 * @param endRow
	 * @return
	 */
	public List<Map<String, Object>> selectConfigsByParams(Integer type, String name);
	
	/**
	 * 转换配置
	 * @param configList
	 * @param type
	 * @return
	 */
	public Long changConfigsToLong(List<ConfigInfo> configList, Integer type);
}
