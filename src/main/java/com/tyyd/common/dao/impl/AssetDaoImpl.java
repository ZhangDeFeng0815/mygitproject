package com.tyyd.common.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import com.tyyd.common.dao.AssetDao;
import com.tyyd.framework.core.dao.impl.BaseDaoImpl;
import com.tyyd.framework.core.util.DBUtils;
import com.tyyd.framework.core.util.MapUtils;

@Repository
public class AssetDaoImpl extends BaseDaoImpl implements AssetDao {

	/**
	 * 指定表名 一张表对应一个Dao
	 */
	@Override
	public String getTableName() {
		return "BO_ASSET";
	}

	@Override
	public List<Map<String, Object>> selectAssetsByParams(List<String> assetCdList, List<String> wkNameList,
			Long rightB, Map<String, Object> params, String startRow, String endRow) {
		DBUtils dbUtil = new DBUtils(this);

		if (assetCdList != null && assetCdList.size() > 0) {
			if (assetCdList.size() > 1) {
				dbUtil.addParamter("assetCdList", assetCdList);
			} else {
				dbUtil.addParamter("ASSET_CD", assetCdList.get(0));
			}
		}

		if (wkNameList != null && wkNameList.size() > 0) {
			if (wkNameList.size() > 1) {
				dbUtil.addParamter("wkNameList", wkNameList);
			} else {
				dbUtil.addParamter("WK_NAME", wkNameList.get(0));
			}
		}

		if (rightB != null) {
			dbUtil.addParamter("RIGHT_B", rightB);
		}

		if (StringUtils.isNotBlank(MapUtils.getString(params, "ASSET_CD", ""))) {
			dbUtil.addParamter("ASSET_CD", MapUtils.getString(params, "ASSET_CD"));
		}

		if (StringUtils.isNotBlank(MapUtils.getString(params, "AU_NAME_S", ""))) {
			dbUtil.addParamter("AU_NAME_S", MapUtils.getString(params, "AU_NAME_S"));
		}

		if (StringUtils.isNotBlank(MapUtils.getString(params, "AU_NAME_B", ""))) {
			dbUtil.addParamter("AU_NAME_B", MapUtils.getString(params, "AU_NAME_B"));
		}

		if (StringUtils.isNotBlank(MapUtils.getString(params, "MEDIA_TYPE_ID", ""))) {
			dbUtil.addParamter("MEDIA_TYPE_ID", MapUtils.getIntValue(params, "MEDIA_TYPE_ID"));
		}

		if (StringUtils.isNotBlank(MapUtils.getString(params, "START_CREATE_DATE", ""))) {
			dbUtil.addParamter("START_CREATE_DATE", MapUtils.getString(params, "START_CREATE_DATE"));
		}

		if (StringUtils.isNotBlank(MapUtils.getString(params, "END_CREATE_DATE", ""))) {
			dbUtil.addParamter("END_CREATE_DATE", MapUtils.getString(params, "END_CREATE_DATE"));
		}
		return dbUtil.selectPage("searchAssets", startRow, endRow);
	}

	@Override
	public Integer selectAssetsCountByParams(List<String> assetCdList, List<String> wkNameList, Long rightB,
			Map<String, Object> params) {
		DBUtils dbUtil = new DBUtils(this);

		if (assetCdList != null && assetCdList.size() > 0) {
			if (assetCdList.size() > 1) {
				dbUtil.addParamter("assetCdList", assetCdList);
			} else {
				dbUtil.addParamter("ASSET_CD", assetCdList.get(0));
			}
		}

		if (wkNameList != null && wkNameList.size() > 0) {
			if (wkNameList.size() > 1) {
				dbUtil.addParamter("wkNameList", wkNameList);
			} else {
				dbUtil.addParamter("WK_NAME", wkNameList.get(0));
			}
		}

		if (rightB != null) {
			dbUtil.addParamter("RIGHT_B", rightB);
		}

		if (StringUtils.isNotBlank(MapUtils.getString(params, "ASSET_CD", ""))) {
			dbUtil.addParamter("ASSET_CD", MapUtils.getString(params, "ASSET_CD"));
		}

		if (StringUtils.isNotBlank(MapUtils.getString(params, "AU_NAME_S", ""))) {
			dbUtil.addParamter("AU_NAME_S", MapUtils.getString(params, "AU_NAME_S"));
		}

		if (StringUtils.isNotBlank(MapUtils.getString(params, "AU_NAME_B", ""))) {
			dbUtil.addParamter("AU_NAME_B", MapUtils.getString(params, "AU_NAME_B"));
		}

		if (StringUtils.isNotBlank(MapUtils.getString(params, "MEDIA_TYPE_ID", ""))) {
			dbUtil.addParamter("MEDIA_TYPE_ID", MapUtils.getIntValue(params, "MEDIA_TYPE_ID"));
		}
		return dbUtil.selectOne("searchAssetsCount");
	}

	@Override
	public List<Map<String, Object>> selectAssetsExport(List<String> assetCdList, List<String> wkNameList, Long rightB,
			Map<String, Object> params, Long lastAssetId) {
		DBUtils dbUtil = new DBUtils(this);
		
		if (assetCdList != null && assetCdList.size() > 0) {
			if (assetCdList.size() > 1) {
				dbUtil.addParamter("assetCdList", assetCdList);
			} else {
				dbUtil.addParamter("ASSET_CD", assetCdList.get(0));
			}
		}
		
		if (wkNameList != null && wkNameList.size() > 0) {
			if (wkNameList.size() > 1) {
				dbUtil.addParamter("wkNameList", wkNameList);
			} else {
				dbUtil.addParamter("WK_NAME", wkNameList.get(0));
			}
		}

		if (rightB != null) {
			dbUtil.addParamter("RIGHT_B", rightB);
		}

		if (StringUtils.isNotBlank(MapUtils.getString(params, "ASSET_CD", ""))) {
			dbUtil.addParamter("ASSET_CD", MapUtils.getString(params, "ASSET_CD"));
		}

		if (StringUtils.isNotBlank(MapUtils.getString(params, "AU_NAME_S", ""))) {
			dbUtil.addParamter("AU_NAME_S", MapUtils.getString(params, "AU_NAME_S"));
		}

		if (StringUtils.isNotBlank(MapUtils.getString(params, "AU_NAME_B", ""))) {
			dbUtil.addParamter("AU_NAME_B", MapUtils.getString(params, "AU_NAME_B"));
		}

		if (StringUtils.isNotBlank(MapUtils.getString(params, "MEDIA_TYPE_ID", ""))) {
			dbUtil.addParamter("MEDIA_TYPE_ID", MapUtils.getIntValue(params, "MEDIA_TYPE_ID"));
		}

		if (lastAssetId != null) {
			MapUtils.safeAddToMap(params, "LASTASSETID", lastAssetId);
		}
		return dbUtil.select("selectAssetsExport");
	}

	/**
	 * 计算指定条件的资产个数
	 */
	@Override
	public Integer countAssetByVaules(String wkName, String auNameS, String auNameB, Integer mediaTypeId) {
		DBUtils dbUtil = new DBUtils(this);
		dbUtil.addParamter("WK_NAME", wkName);
		dbUtil.addParamter("AU_NAME_S", auNameS);
		dbUtil.addParamter("AU_NAME_B", auNameB);
		dbUtil.addParamter("MEDIA_TYPE_ID", mediaTypeId);
		return dbUtil.selectOne("countAssetByVaules");
	}

	/**
	 * 更新收入合计项
	 */
	@Override
	public Integer updateAssetTotalInc(Long assetId, Long userId, String incTblName) {
		DBUtils dbUtil = new DBUtils(this);
		dbUtil.addParamter("ASSET_ID", assetId);
		dbUtil.addParamter("TBLNAME_INC", incTblName);
		dbUtil.addParamter("UPDATE_USERID", userId);
		return dbUtil.update("updateAssetTotalInc");
	}

	/**
	 * 更新成本合计项
	 */
	@Override
	public Integer updateAssetTotalPay(Long assetId, Long userId, String payTblName) {
		DBUtils dbUtil = new DBUtils(this);
		dbUtil.addParamter("ASSET_ID", assetId);
		dbUtil.addParamter("TBLNAME_PAY", payTblName);
		dbUtil.addParamter("UPDATE_USERID", userId);
		return dbUtil.update("updateAssetTotalPay");
	}

	@Override
	public Map<String, Object> selectAssetInfoByAssetCd(String assetCd) {
		if (StringUtils.isBlank(assetCd)) {
			return null;
		}
		DBUtils dbUtil = new DBUtils(this);
		dbUtil.addParamter("ASSET_CD", assetCd);
		return dbUtil.selectOne("searchAssetByAssetCd");
	}

	/**
	 * 更新资产信息
	 */
	@Override
	public Integer updateAssetInfo(Map<String, Object> params, Long userId) {
		DBUtils dbUtil = new DBUtils(this);
		Integer wkClass = MapUtils.getInteger(params, "WK_CLASS");
		if (wkClass == null) {
			dbUtil.addParamter("WK_CLASS", "");
		} else {
			dbUtil.addParamter("WK_CLASS", wkClass);
		}
		Integer wordCount = MapUtils.getInteger(params, "WORD_COUNT");
		if (wordCount == null) {
			dbUtil.addParamter("WORD_COUNT", "");
		} else {
			dbUtil.addParamter("WORD_COUNT", wordCount);
		}
		String isbnNum = MapUtils.getString(params, "ISBN_NUM");
		if (StringUtils.isNotBlank(isbnNum)) {
			dbUtil.addParamter("ISBN_NUM", isbnNum);
		} else {
			dbUtil.addParamter("ISBN_NUM", "");
		}
		dbUtil.addParamter("ASSET_ID", MapUtils.getLong(params, "ASSET_ID"));
		dbUtil.addParamter("UPDATE_USERID", userId);
		return dbUtil.update("updateAssetInfo");
	}
}
