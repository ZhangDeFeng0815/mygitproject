package com.tyyd.crps.scf.asset.dto;

import java.io.Serializable;
import java.util.Map;

import com.tyyd.common.po.AssetRightDInfo;
import com.tyyd.framework.core.util.PropertyUtils;

public class AssetRightDDto extends AssetRightDInfo implements Serializable {
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
	private static StringBuilder MAPPING_ASSETRIGHTDINFO = new StringBuilder();
	static {
		MAPPING_ASSETRIGHTDINFO.append("{");
		MAPPING_ASSETRIGHTDINFO.append("ASSET_RIGHT_D_ID:{toName:\"assetRightDId\"},");
		MAPPING_ASSETRIGHTDINFO.append("ASSET_ID:{toName:\"assetId\"},");
		MAPPING_ASSETRIGHTDINFO.append("RIGHT_CD:{toName:\"rightCd\"},");
		MAPPING_ASSETRIGHTDINFO.append("NAME:{toName:\"rightName\"},");
		MAPPING_ASSETRIGHTDINFO.append("AT_TYPE:{toName:\"atType\"},");
		MAPPING_ASSETRIGHTDINFO.append("DATE_FROM:{toName:\"dateFrom\"},");
		MAPPING_ASSETRIGHTDINFO.append("DATE_TO:{toName:\"dateTo\"},");
		MAPPING_ASSETRIGHTDINFO.append("CAN_RESALE:{toName:\"canResale\"},");
		MAPPING_ASSETRIGHTDINFO.append("REGION:{toName:\"region\"},");
		MAPPING_ASSETRIGHTDINFO.append("CREATE_DATE:{toName:\"createDate\"},");
		MAPPING_ASSETRIGHTDINFO.append("CONTRACT_CD:{toName:\"contractCd\"}");
		MAPPING_ASSETRIGHTDINFO.append("}");
	}

	/**
	 * 类型转换AssetRightTInfo
	 * 
	 * @param asset
	 * @return
	 */
	public static AssetRightDDto copyMapToAssetRightDInfo(Map<String, Object> assetRightD) {
		if (assetRightD == null || !(assetRightD.size() > 0)) {
			return null;
		}
		AssetRightDDto assetRightDDto = new AssetRightDDto();
		PropertyUtils.copy(assetRightDDto, assetRightD, "{fieldOnly:false}", MAPPING_ASSETRIGHTDINFO.toString());
		return assetRightDDto;
	}
}
