package com.tyyd.common.dao;

import java.util.List;
import java.util.Map;

import com.tyyd.framework.core.dao.BaseDao;

public interface ContractOutDao extends BaseDao {
	
	/**
	 * 根据合同编号，查询合同信息
	 * @param contractCd
	 * @return
	 */
	Map<String, Object> selectOutInfoByContractCd(String contractCd);
	
	/**
	 * 根据合同编号获取授权合同信息（包含附件信息）
	 * 
	 * @param contractCd
	 * @return
	 */
	public Map<String, Object> selectContractOutByCdWithFile(String contractCd);
	
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
