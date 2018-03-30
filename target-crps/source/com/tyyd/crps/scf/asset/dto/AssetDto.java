package com.tyyd.crps.scf.asset.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.tyyd.common.po.AssetInfo;
import com.tyyd.common.po.ConfigInfo;
import com.tyyd.framework.core.util.MapUtils;
import com.tyyd.framework.core.util.PropertyUtils;

public class AssetDto extends AssetInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3535119737075328313L;
	private List<String> assetCdList = null;
	private List<String> wkNameList = null;
	private List<ConfigInfo> rightBlist = null;
	private String startRow;
	private String endRow;
	private Long lastAssetId;
	private String startCreateDate;// 资产入库时间查询条件-开始时间2
	private String endCreateDate;// 资产入库时间查询条件-结束时间
	private String mediaTypeName;
	private String wkClassName;
	private String totalPayStr;
	private String totalIncomeStr;

	public List<String> getAssetCdList() {
		return assetCdList;
	}

	public void setAssetCdList(List<String> assetCdList) {
		this.assetCdList = assetCdList;
	}

	public List<String> getWkNameList() {
		return wkNameList;
	}

	public void setWkNameList(List<String> wkNameList) {
		this.wkNameList = wkNameList;
	}

	public List<ConfigInfo> getRightBlist() {
		return rightBlist;
	}

	public void setRightBlist(List<ConfigInfo> rightBlist) {
		this.rightBlist = rightBlist;
	}

	public String getStartRow() {
		return startRow;
	}

	public void setStartRow(String startRow) {
		this.startRow = startRow;
	}

	public String getEndRow() {
		return endRow;
	}

	public void setEndRow(String endRow) {
		this.endRow = endRow;
	}

	public Long getLastAssetId() {
		return lastAssetId;
	}

	public void setLastAssetId(Long lastAssetId) {
		this.lastAssetId = lastAssetId;
	}

	public String getStartCreateDate() {
		return startCreateDate;
	}

	public void setStartCreateDate(String startCreateDate) {
		this.startCreateDate = startCreateDate;
	}

	public String getEndCreateDate() {
		return endCreateDate;
	}

	public void setEndCreateDate(String endCreateDate) {
		this.endCreateDate = endCreateDate;
	}

	public String getMediaTypeName() {
		return mediaTypeName;
	}

	public void setMediaTypeName(String mediaTypeName) {
		this.mediaTypeName = mediaTypeName;
	}

	public String getWkClassName() {
		return wkClassName;
	}

	public void setWkClassName(String wkClassName) {
		this.wkClassName = wkClassName;
	}

	public String getTotalPayStr() {
		return totalPayStr;
	}

	public void setTotalPayStr(String totalPayStr) {
		this.totalPayStr = totalPayStr;
	}

	public String getTotalIncomeStr() {
		return totalIncomeStr;
	}

	public void setTotalIncomeStr(String totalIncomeStr) {
		this.totalIncomeStr = totalIncomeStr;
	}

	// 合作商基本信息字段映射
	private static StringBuilder MAPPING_ASSETINFO = new StringBuilder();
	static {
		MAPPING_ASSETINFO.append("{");
		MAPPING_ASSETINFO.append("ASSET_ID:{toName:\"assetId\"},");
		MAPPING_ASSETINFO.append("ASSET_CD:{toName:\"assetCd\"},");
		MAPPING_ASSETINFO.append("WK_NAME:{toName:\"wkName\"},");
		MAPPING_ASSETINFO.append("AU_NAME_S:{toName:\"auNameS\"},");
		MAPPING_ASSETINFO.append("AU_NAME_B:{toName:\"auNameB\"},");
		MAPPING_ASSETINFO.append("MEDIA_TYPE_ID:{toName:\"mediaTypeId\"},");
		MAPPING_ASSETINFO.append("WK_CLASS:{toName:\"wkClass\"},");
		MAPPING_ASSETINFO.append("WORD_COUNT:{toName:\"wordCount\"},");
		MAPPING_ASSETINFO.append("ISBN_NUM:{toName:\"isbnNum\"},");
		MAPPING_ASSETINFO.append("RIGHT_B:{toName:\"rightB\"},");
		MAPPING_ASSETINFO.append("TOTAL_PAY:{toName:\"totalPay\"},");
		MAPPING_ASSETINFO.append("TOTAL_INCOME:{toName:\"totalIncome\"},");
		MAPPING_ASSETINFO.append("CREATE_DATE:{toName:\"createDate\"},");
		MAPPING_ASSETINFO.append("UPDATE_DATE:{toName:\"updateDate\"},");
		MAPPING_ASSETINFO.append("CREATE_USERID:{toName:\"createUserId\"},");
		MAPPING_ASSETINFO.append("UPDATE_USERID:{toName:\"updateUserId\"}");
		MAPPING_ASSETINFO.append("}");
	}

	/**
	 * 类型转换AssetInfo
	 * 
	 * @param asset
	 * @return
	 */
	public static AssetDto copyMapToAssetInfo(Map<String, Object> asset) {
		if (asset == null || !(asset.size() > 0)) {
			return null;
		}
		AssetDto assetDto = new AssetDto();
		PropertyUtils.copy(assetDto, asset, "{fieldOnly:false}", MAPPING_ASSETINFO.toString());
		return assetDto;
	}

	/**
	 * 类型转换Map
	 * 
	 * @param assetInfo
	 * @return
	 */
	public static Map<String, Object> copyAssetInfoToMap(AssetInfo asset) {
		Map<String, Object> params = new HashMap<String, Object>();

		if (asset.getAssetId() != null) {
			MapUtils.safeAddToMap(params, "ASSET_ID", asset.getAssetId());
		}

		if (StringUtils.isNotBlank(asset.getAssetCd())) {
			MapUtils.safeAddToMap(params, "ASSET_CD", asset.getAssetCd());
		}

		if (StringUtils.isNotBlank(asset.getWkName())) {
			MapUtils.safeAddToMap(params, "WK_NAME", asset.getWkName());
		}

		if (StringUtils.isNotBlank(asset.getAuNameS())) {
			MapUtils.safeAddToMap(params, "AU_NAME_S", asset.getAuNameS());
		}

		if (StringUtils.isNotBlank(asset.getAuNameB())) {
			MapUtils.safeAddToMap(params, "AU_NAME_B", asset.getAuNameB());
		}

		if (asset.getMediaTypeId() != null) {
			MapUtils.safeAddToMap(params, "MEDIA_TYPE_ID", asset.getMediaTypeId());
		}

		if (asset.getWkClass() != null) {
			MapUtils.safeAddToMap(params, "WK_CLASS", asset.getWkClass());
		}

		if (asset.getWordCount() != null) {
			MapUtils.safeAddToMap(params, "WORD_COUNT", asset.getWordCount());
		}

		if (StringUtils.isNotBlank(asset.getIsbnNum())) {
			MapUtils.safeAddToMap(params, "ISBN_NUM", asset.getIsbnNum());
		}

		if (asset.getRightB() != null) {
			MapUtils.safeAddToMap(params, "RIGHT_B", asset.getRightB());
		}

		if (asset.getTotalPay() != null) {
			MapUtils.safeAddToMap(params, "TOTAL_PAY", asset.getTotalPay());
		}
		if (asset.getTotalIncome() != null) {
			MapUtils.safeAddToMap(params, "TOTAL_INCOME", asset.getTotalIncome());
		}

		if (asset.getUpdateDate() != null) {
			MapUtils.safeAddToMap(params, "UPDATE_DATE", asset.getUpdateDate());
		}

		if (asset.getUpdateUserId() != null) {
			MapUtils.safeAddToMap(params, "UPDATE_USERID", asset.getUpdateUserId());
		}

		if (asset.getCreateDate() != null) {
			MapUtils.safeAddToMap(params, "CREATE_DATE", asset.getCreateDate());
		}

		if (asset.getCreateUserId() != null) {
			MapUtils.safeAddToMap(params, "CREATE_USERID", asset.getCreateUserId());
		}
		return params;
	}
}
