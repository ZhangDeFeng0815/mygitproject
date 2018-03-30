package com.tyyd.common.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.tyyd.common.dao.ContractInDao;
import com.tyyd.framework.core.dao.impl.BaseDaoImpl;
import com.tyyd.framework.core.util.DBUtils;

@Repository
public class ContractInDaoImpl extends BaseDaoImpl implements ContractInDao {

	/**
	 * 指定表名 一张表对应一个Dao
	 */
	@Override
	public String getTableName() {
		return "BO_CONTRACT_IN";
	}

	@Override
	public Map<String, Object> selectContractInInfoByContractCd(String contractCd) {
		if (StringUtils.isBlank(contractCd)) {
			return null;
		}
		DBUtils dbUtil = new DBUtils(this);
		dbUtil.addParamter("CONTRACT_CD", contractCd);
		return dbUtil.selectOne("searchContractInByContractCd");
	}

	/**
	 * 授权合同查询列表
	 */
	@Override
	public List<Map<String, Object>> selectContractList(Map<String, Object> params, String startRow, String endRow) {
		DBUtils dbUtil = new DBUtils(this);
		String contractCd = MapUtils.getString(params, "CONTRACT_CD", null);
		if (StringUtils.isNotBlank(contractCd)) {
			dbUtil.addParamter("CONTRACT_CD", contractCd);
		}
		String partnerName = MapUtils.getString(params, "PARTNER_NAME", null);
		if (StringUtils.isNotBlank(partnerName)) {
			dbUtil.addParamter("PARTNER_NAME", partnerName);
		}
		return dbUtil.selectPage("selectContractList", startRow, endRow);
	}

	/**
	 * 授权合同查询列表计数
	 */
	@Override
	public Integer selectContractListCount(Map<String, Object> params) {
		DBUtils dbUtil = new DBUtils(this);
		String contractCd = MapUtils.getString(params, "CONTRACT_CD", null);
		if (StringUtils.isNotBlank(contractCd)) {
			dbUtil.addParamter("CONTRACT_CD", contractCd);
		}
		String partnerName = MapUtils.getString(params, "PARTNER_NAME", null);
		if (StringUtils.isNotBlank(partnerName)) {
			dbUtil.addParamter("PARTNER_NAME", partnerName);
		}
		return dbUtil.selectOne("selectContractListCount");
	}

	/**
	 * 根据合同编号获取获权合同信息（包含附件信息）
	 */
	@Override
	public Map<String, Object> selectContractInByCdWithFile(String contractCd) {
		if (StringUtils.isBlank(contractCd)) {
			return null;
		}
		DBUtils dbUtil = new DBUtils(this);
		dbUtil.addParamter("CONTRACT_CD", contractCd);
		return dbUtil.selectOne("selectContractInByCdWithFile");
	}
	
}
