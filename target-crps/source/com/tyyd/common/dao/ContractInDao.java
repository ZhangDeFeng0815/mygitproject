package com.tyyd.common.dao;

import java.util.List;
import java.util.Map;

import com.tyyd.framework.core.dao.BaseDao;

public interface ContractInDao extends BaseDao {

	/**
	 * 根据合同编号获取获权合同信息
	 * 
	 * @param contractCd
	 * @return
	 */
	public Map<String, Object> selectContractInInfoByContractCd(String contractCd);
	
	/**
	 * 根据合同编号获取获权合同信息（包含附件信息）
	 * 
	 * @param contractCd
	 * @return
	 */
	public Map<String, Object> selectContractInByCdWithFile(String contractCd);
	
	/**
	 * 授权合同查询列表
	 * @param params
	 * @return
	 */
	public List<Map<String, Object>> selectContractList(Map<String, Object> params, String startRow, String endRow);
	
	/**
	 * 授权合同查询列表计数
	 * @param params
	 * @return
	 */
	public Integer selectContractListCount(Map<String, Object> params);
}
