package com.tyyd.common.dao.impl;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.tyyd.common.dao.ContractOutDao;
import com.tyyd.framework.core.dao.impl.BaseDaoImpl;
import com.tyyd.framework.core.util.DBUtils;

@Repository
public class ContractOutDaoImpl extends BaseDaoImpl implements ContractOutDao {

	@Override
	public String getTableName() {
		return "BO_CONTRACT_OUT";
	}

	/**
	 * 根据合同编号，查询合同信息
	 */
	@Override
	public Map<String, Object> selectOutInfoByContractCd(String contractCd) {
		if (contractCd == null || "".equals(contractCd)) {
			return null;
		}
		DBUtils dbUtil = new DBUtils(this);
		dbUtil.addParamter("CONTRACT_CD", contractCd);
		return dbUtil.selectOne("selectOutInfoByContractCd");
	}

}
