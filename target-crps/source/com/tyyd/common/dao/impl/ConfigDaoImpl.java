package com.tyyd.common.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.tyyd.common.dao.ConfigDao;
import com.tyyd.common.po.ConfigInfo;
import com.tyyd.framework.core.dao.impl.BaseDaoImpl;
import com.tyyd.framework.core.util.DBUtils;
import com.tyyd.framework.core.util.MapUtils;

@Repository
public class ConfigDaoImpl extends BaseDaoImpl implements ConfigDao {

	/**
	 * 指定表名 一张表对应一个Dao
	 */
	@Override
	public String getTableName() {
		return "BO_CONFIG";
	}

	@Override
	public List<Map<String, Object>> selectConfigsByParamsPage(Integer type, String name, String startRow,
			String endRow) {
		DBUtils dbUtil = new DBUtils(this);

		if (type != null) {
			dbUtil.addParamter("ASSET_CD", type);
		}

		if (StringUtils.isNotBlank(name)) {
			dbUtil.addParamter("AU_NAME_S", name);
		}

		return dbUtil.selectPage("searchConfigs", startRow, endRow);
	}

	@Override
	public Integer selectConfigsCountByParams(Integer type, String name) {
		DBUtils dbUtil = new DBUtils(this);

		if (type != null) {
			dbUtil.addParamter("ASSET_CD", type);
		}

		if (StringUtils.isNotBlank(name)) {
			dbUtil.addParamter("AU_NAME_S", name);
		}

		return dbUtil.selectOne("searchConfigsCount");
	}

	@Override
	public List<Map<String, Object>> selectConfigsByParams(Integer type, String name) {
		DBUtils dbUtil = new DBUtils(this);

		if (type != null) {
			dbUtil.addParamter("TYPE", type);
		}

		if (StringUtils.isNotBlank(name)) {
			dbUtil.addParamter("NAME", name);
		}

		return dbUtil.select("searchConfigs");
	}

	@Override
	public Long changConfigsToLong(List<ConfigInfo> configList, Integer type) {
		if (type == null) {
			return null;
		}
		List<Map<String, Object>> dataList = selectConfigsByParams(type, null);
		if (dataList == null || dataList.size() < 1) {
			return null;
		}
		Map<String, Object> configMap = new HashMap<String, Object>();
		if (configList != null && configList.size() > 0) {
			for (ConfigInfo configInfo : configList) {
				if (configInfo != null && StringUtils.isNotBlank(configInfo.getCd())) {
					MapUtils.safeAddToMap(configMap, configInfo.getCd(), configInfo.getCd());
				}
			}
		}
		String binaryString = "";
		for (Map<String, Object> config : dataList) {
			if (configMap.containsKey(MapUtils.getString(config, "CD"))) {
				binaryString += "1";
			} else {
				binaryString += "0";
			}
		}
		return Long.valueOf(binaryString, 2);
	}

}
