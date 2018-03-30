package com.tyyd.common.dao;

import java.util.Map;

import com.tyyd.framework.core.dao.BaseDao;

public interface ContractOutDao extends BaseDao {
	
	/**
	 * 根据合同编号，查询合同信息
	 * @param contractCd
	 * @return
	 */
	Map<String, Object> selectOutInfoByContractCd(String contractCd);
}
