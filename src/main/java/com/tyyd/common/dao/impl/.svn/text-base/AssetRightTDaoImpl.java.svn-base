package com.tyyd.common.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.tyyd.common.dao.AssetRightTDao;
import com.tyyd.framework.core.dao.impl.BaseDaoImpl;
import com.tyyd.framework.core.util.DBUtils;
import com.tyyd.framework.core.util.ExceptionUtils;

@Repository
public class AssetRightTDaoImpl extends BaseDaoImpl implements AssetRightTDao {

	@Override
	public String getTableName() {
		return "BO_ASSET_RIGHT_T_";
	}

	public AssetRightTDaoImpl() {
		super.setTableCount(20);
	}

	@Override
	public List<Map<String, Object>> selectAssetRightTs(Long assetId, String rightCd) {
		if (assetId == null) {
			return null;
		}
		DBUtils dbUtil = new DBUtils(this);
		dbUtil.addParamter("TBLNAME", this.getMultiTableName(assetId));
		dbUtil.addParamter("ASSET_ID", assetId);
		if (StringUtils.isNotBlank(rightCd)) {
			dbUtil.addParamter("RIGHT_CD", rightCd);
		}
		return dbUtil.select("searchAssetRightTs");
	}

	/**
	 * 根据资产ID，查找对应的权利信息
	 */
	@Override
	public List<Map<String, Object>> selectAllRightsOfAssetByAssetId(Long assetId) {
		DBUtils dbUtil = new DBUtils(this);
		dbUtil.addParamter("TBLNAME", this.getMultiTableName(assetId));
		dbUtil.addParamter("ASSET_ID", assetId);
		return dbUtil.select("selectAllRightsOfAssetByAssetId");
	}

	/**
	 * 根据资产ID，删除归集表的所有权利项
	 */
	@Override
	public Integer deleteRightTByAssetId(Long assetId) {
		if (assetId == null) {
			ExceptionUtils.throwAcwsException(new IllegalArgumentException("资产ID不能为空"));
		}
		DBUtils dbUtil = new DBUtils(this);
		dbUtil.addParamter("TBLNAME", this.getMultiTableName(assetId));
		dbUtil.addParamter("ASSET_ID", assetId);
		return dbUtil.delete("deleteRightTByAssetId");
	}

	@Override
	public Integer deleteAssetRightTByContractCd(String contractCd) {
		if (StringUtils.isBlank(contractCd)) {
			ExceptionUtils.throwAcwsException(new IllegalArgumentException("合同编号不能为空"));
		}
		int sucNum = 0;
		DBUtils dbUtil = new DBUtils(this);
		// 每张表都执行一次sql
		for (int i = 0; i < this.getTableCount(); i++) {
			dbUtil.addParamter("CONTRACT_CD", contractCd);
			dbUtil.addParamter("TBLNAME", this.getTableName() + (long) (i));
			dbUtil.delete("deleteAssetRightTByContractCd");
			sucNum++;
		}
		return sucNum;
	}
}
