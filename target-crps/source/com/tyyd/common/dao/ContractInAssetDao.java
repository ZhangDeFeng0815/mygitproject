package com.tyyd.common.dao;

import java.util.List;

import com.tyyd.framework.core.dao.BaseDao;

public interface ContractInAssetDao extends BaseDao {

	/**
	 * 根据资产id和合同ID删除获权合同和资产关系
	 * 
	 * @param assetId
	 * @param contractId
	 * @return
	 */
	public Integer deleteByAssetIdAndContractId(String contractCd, long assetId);

	/**
	 * 根据合同编号查询资产ID
	 * 
	 * @param contractCd
	 * @return
	 */
	public List<Long> selectAssetIdsByContractCd(String contractCd);
	
	/**
	 * 统计指定资产是否存在收入合同与之关联
	 * @param assetId
	 * @return
	 */
	public Integer countContractInByAId(Long assetId);
}
