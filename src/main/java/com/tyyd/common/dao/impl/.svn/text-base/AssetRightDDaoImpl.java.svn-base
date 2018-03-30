package com.tyyd.common.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.tyyd.common.dao.AssetRightDDao;
import com.tyyd.framework.core.dao.impl.BaseDaoImpl;
import com.tyyd.framework.core.util.DBUtils;
import com.tyyd.framework.core.util.ExceptionUtils;

@Repository
public class AssetRightDDaoImpl extends BaseDaoImpl implements AssetRightDDao {

	@Override
	public String getTableName() {
		return "BO_ASSET_RIGHT_D_";
	}

	public AssetRightDDaoImpl() {
		super.setTableCount(100);
	}

	@Override
	public List<Map<String, Object>> selectAssetRightDs(Long assetId, String rightCd, String rightName, String contractCd) {
		if (assetId == null) {
			return null;
		}
		DBUtils dbUtil = new DBUtils(this);
		dbUtil.addParamter("TBLNAME", this.getMultiTableName(assetId));
		dbUtil.addParamter("ASSET_ID", assetId);
		if (StringUtils.isNotBlank(rightCd)) {
			dbUtil.addParamter("RIGHT_CD", rightCd);
		}
		if (StringUtils.isNotBlank(rightName)) {
			dbUtil.addParamter("RIGHT_NAME", rightName);
		}
		if (StringUtils.isNotBlank(contractCd)) {
			dbUtil.addParamter("CONTRACT_CD", contractCd);
		}
		return dbUtil.select("searchAssetRightDs");
	}

	@Override
	public List<Map<String, Object>> selectAssetRightDsByAssetIdAndContractCd(Long assetId, String contractCd) {
		if (assetId == null || StringUtils.isBlank(contractCd)) {
			return null;
		}
		DBUtils dbUtil = new DBUtils(this);
		dbUtil.addParamter("TBLNAME", this.getMultiTableName(assetId));
		dbUtil.addParamter("ASSET_ID", assetId);
		dbUtil.addParamter("CONTRACT_CD", contractCd);
		return dbUtil.select("selectAssetRightDsByAssetAndContract");
	}

	/**
	 * 根据资产ID，查找对应的权利明细信息
	 */
	@Override
	public List<Map<String, Object>> selectRightDOfRtByRtId(Long assetId) {
		DBUtils dbUtil = new DBUtils(this);
		dbUtil.addParamter("TBLNAME", this.getMultiTableName(assetId));
		dbUtil.addParamter("ASSET_ID", assetId);
		return dbUtil.select("selectRightDOfRtByRtId");
	}

	@Override
	public Integer deleteAssetRightDByContractCd(String contractCd) {
		if (StringUtils.isBlank(contractCd)) {
			ExceptionUtils.throwAcwsException(new IllegalArgumentException("合同编号不能为空"));
		}
		int sucNum = 0;
		DBUtils dbUtil = new DBUtils(this);
		// 每张表都执行一次sql
		for (int i = 0; i < this.getTableCount(); i++) {
			dbUtil.addParamter("CONTRACT_CD", contractCd);
			dbUtil.addParamter("TBLNAME", this.getTableName() + (long) (i));
			dbUtil.delete("deleteAssetRightDByContractCd");
			sucNum++;
		}
		return sucNum;
	}

	/**
	 * 根据资产ID，删除所有权利项
	 */
	@Override
	public Integer deleteRightDByAssetId(Long assetId) {
		DBUtils dbUtil = new DBUtils(this);
		dbUtil.addParamter("TBLNAME", this.getMultiTableName(assetId));
		dbUtil.addParamter("ASSET_ID", assetId);
		return dbUtil.delete("deleteRightDByAssetId");
	}

	@Override
	public List<Map<String, Object>> selectAssetRightDsOrderByUpdateDate(Long assetId, String rightCd,
			String contractCd) {
		if (assetId == null) {
			return null;
		}
		DBUtils dbUtil = new DBUtils(this);
		dbUtil.addParamter("TBLNAME", this.getMultiTableName(assetId));
		dbUtil.addParamter("ASSET_ID", assetId);
		if (StringUtils.isNotBlank(rightCd)) {
			dbUtil.addParamter("RIGHT_CD", rightCd);
		}
		if (StringUtils.isNotBlank(contractCd)) {
			dbUtil.addParamter("CONTRACT_CD", contractCd);
		}
		return dbUtil.select("searchAssetRightDsOrderByUpdateDate");
	}
}
