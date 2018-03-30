package com.tyyd.common.dao;

import com.tyyd.framework.core.dao.BaseDao;

public interface ContractOutAssetDao extends BaseDao {

	/**
	 * 统计指定资产是否存在收入合同与之关联
	 * @param assetId
	 * @return
	 */
	public Integer countContractOutByAId(Long assetId);
	
	/**
	 * 根据指定资产ID，删除对应的资产和收入合同关联
	 * @param assetId
	 * @return
	 */
	public Integer deleteByAssetId(Long assetId);
}
