package com.tyyd.crps.scf.asset.dto;

import java.io.Serializable;
import java.util.Map;

import com.tyyd.common.po.AssetRightTInfo;
import com.tyyd.framework.core.util.PropertyUtils;

public class AssetRightTDto extends AssetRightTInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7260573673008238365L;
	private String regionName;
	private String canResaleName;

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public String getCanResaleName() {
		return canResaleName;
	}

	public void setCanResaleName(String canResaleName) {
		this.canResaleName = canResaleName;
	}

	// 合作商基本信息字段映射
	private static StringBuilder MAPPING_ASSETRIGHTTINFO = new StringBuilder();
	static {
		MAPPING_ASSETRIGHTTINFO.append("{");
		MAPPING_ASSETRIGHTTINFO.append("ASSET_RIGHT_T_ID:{toName:\"assetRightTId\"},");
		MAPPING_ASSETRIGHTTINFO.append("ASSET_ID:{toName:\"assetId\"},");
		MAPPING_ASSETRIGHTTINFO.append("RIGHT_CD:{toName:\"rightCd\"},");
		MAPPING_ASSETRIGHTTINFO.append("NAME:{toName:\"rightName\"},");
		MAPPING_ASSETRIGHTTINFO.append("AT_TYPE:{toName:\"atType\"},");
		MAPPING_ASSETRIGHTTINFO.append("DATE_FROM:{toName:\"dateFrom\"},");
		MAPPING_ASSETRIGHTTINFO.append("DATE_TO:{toName:\"dateTo\"},");
		MAPPING_ASSETRIGHTTINFO.append("CAN_RESALE:{toName:\"canResale\"},");
		MAPPING_ASSETRIGHTTINFO.append("REGION:{toName:\"region\"},");
		MAPPING_ASSETRIGHTTINFO.append("CONTRACT_CD:{toName:\"contractCd\"}");
		MAPPING_ASSETRIGHTTINFO.append("}");
	}

	/**
	 * 类型转换AssetRightTInfo
	 * 
	 * @param asset
	 * @return
	 */
	public static AssetRightTDto copyMapToAssetRightTInfo(Map<String, Object> assetRightT) {
		if (assetRightT == null || !(assetRightT.size() > 0)) {
			return null;
		}
		AssetRightTDto assetRightTDto = new AssetRightTDto();
		PropertyUtils.copy(assetRightTDto, assetRightT, "{fieldOnly:false}", MAPPING_ASSETRIGHTTINFO.toString());
		return assetRightTDto;
	}
}
