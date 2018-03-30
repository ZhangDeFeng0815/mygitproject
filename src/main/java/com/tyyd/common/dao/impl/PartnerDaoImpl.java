package com.tyyd.common.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.tyyd.common.dao.PartnerDao;
import com.tyyd.framework.core.dao.impl.BaseDaoImpl;
import com.tyyd.framework.core.util.DBUtils;
import com.tyyd.framework.core.util.MapUtils;

@Repository
public class PartnerDaoImpl extends BaseDaoImpl implements PartnerDao {

	/**
	 * 指定表名 一张表对应一个Dao
	 */
	@Override
	public String getTableName() {
		return "BO_PARTNER";
	}

	/**
	 * 根据指定条件查询合作商列表
	 */
	@Override
	public List<Map<String, Object>> selectPartnersByParams(List<Long> partnerIdList, List<String> partnerNameList,Map<String, Object> params, String startRow, String endRow) {
		DBUtils dbUtil = new DBUtils(this);
		if (partnerIdList != null && partnerIdList.size() > 0) {
			if (partnerIdList.size() > 1) {
				dbUtil.addParamter("partnerIdList", partnerIdList);
			} else {
				dbUtil.addParamter("PARTNER_ID", partnerIdList.get(0));
			}
		}
		
		if (partnerNameList != null && partnerNameList.size() > 0) {
			if (partnerNameList.size() > 1) {
				dbUtil.addParamter("partnerNameList", partnerNameList);
			} else {
				dbUtil.addParamter("PARTNER_NAME", partnerNameList.get(0));
			}
		}
		
		if (StringUtils.isNotBlank(MapUtils.getString(params, "PARTNER_TYPE", ""))) {
			dbUtil.addParamter("PARTNER_TYPE", MapUtils.getIntValue(params, "PARTNER_TYPE"));
		}
		return dbUtil.selectPage("searchPartners", startRow, endRow);
	}

	/**
	 * 根据指定条件查询合作商列表总记录数
	 */
	@Override
	public Integer selectPartnersCountByParams(List<Long> partnerIdList, List<String> partnerNameList, Map<String, Object> params) {
		DBUtils dbUtil = new DBUtils(this);
		if (partnerIdList != null && partnerIdList.size() > 0) {
			if (partnerIdList.size() > 1) {
				dbUtil.addParamter("partnerIdList", partnerIdList);
			} else {
				dbUtil.addParamter("PARTNER_ID", partnerIdList.get(0));
			}
		}
		
		if (partnerNameList != null && partnerNameList.size() > 0) {
			if (partnerNameList.size() > 1) {
				dbUtil.addParamter("partnerNameList", partnerNameList);
			} else {
				dbUtil.addParamter("PARTNER_NAME", partnerNameList.get(0));
			}
		}
		
		if (StringUtils.isNotBlank(MapUtils.getString(params, "PARTNER_TYPE", ""))) {
			dbUtil.addParamter("PARTNER_TYPE", MapUtils.getIntValue(params, "PARTNER_TYPE"));
		}
		return dbUtil.selectOne("searchPartnersCount");
	}

	/**
	 * 合作商列表导出
	 */
	@Override
	public List<Map<String, Object>> selectPartnersExport(List<Long> partnerIdList, List<String> partnerNameList, Map<String, Object> params, Long lastPartnerId) {
		DBUtils dbUtil = new DBUtils(this);
		if (partnerIdList != null && partnerIdList.size() > 0) {
			if (partnerIdList.size() > 1) {
				dbUtil.addParamter("partnerIdList", partnerIdList);
			} else {
				dbUtil.addParamter("PARTNER_ID", partnerIdList.get(0));
			}
		}
		
		if (partnerNameList != null && partnerNameList.size() > 0) {
			if (partnerNameList.size() > 1) {
				dbUtil.addParamter("partnerNameList", partnerNameList);
			} else {
				dbUtil.addParamter("PARTNER_NAME", partnerNameList.get(0));
			}
		}
		
		if (StringUtils.isNotBlank(MapUtils.getString(params, "PARTNER_TYPE", ""))) {
			dbUtil.addParamter("PARTNER_TYPE", MapUtils.getIntValue(params, "PARTNER_TYPE"));
		}
		
		if (lastPartnerId != null) {
			MapUtils.safeAddToMap(params, "LASTPARTNERID", lastPartnerId);
		}
		return dbUtil.select("selectPartnersExport");
	}
	
}
