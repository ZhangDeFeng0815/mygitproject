package com.tyyd.common.dao.impl;

import org.springframework.stereotype.Repository;

import com.tyyd.common.dao.ContractOutAssetDao;
import com.tyyd.framework.core.dao.impl.BaseDaoImpl;
import com.tyyd.framework.core.util.DBUtils;

@Repository
public class ContractOutAssetDaoImpl extends BaseDaoImpl implements ContractOutAssetDao {

	@Override
	public String getTableName() {
		return "BO_CONTRACT_OUT_ASSET";
	}

	@Override
	public Integer countContractOutByAId(Long assetId) {
		if (assetId == null) {
			return 0;
		}
		DBUtils dbUtil = new DBUtils(this);
		dbUtil.addParamter("ASSET_ID", assetId);
		return dbUtil.selectOne("countContractOutByAId");
	}

	/**
	 * 根据指定资产ID，删除对应的资产和收入合同关联
	 */
	@Override
	public Integer deleteByAssetId(Long assetId) {
		if (assetId == null) {
			return 0;
		}
		DBUtils dbUtil = new DBUtils(this);
		dbUtil.addParamter("ASSET_ID", assetId);
		return dbUtil.selectOne("deleteByAssetId");
	}

}
