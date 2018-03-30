package com.tyyd.crps.scf.value.dto;

import java.io.Serializable;
import java.util.Map;

import com.tyyd.common.po.AssetPayDetail;
import com.tyyd.framework.core.util.PropertyUtils;

public class AssetPayDetailDto extends AssetPayDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5807866681144626231L;
	// 合作商基本信息字段映射
	private static StringBuilder MAPPING_ASSET_PAY_D_INFO = new StringBuilder();
	static {
		MAPPING_ASSET_PAY_D_INFO.append("{");
		MAPPING_ASSET_PAY_D_INFO.append("ASSET_PAY_D_ID:{toName:\"id\"},");
		MAPPING_ASSET_PAY_D_INFO.append("ASSET_ID:{toName:\"assetId\"},");
		MAPPING_ASSET_PAY_D_INFO.append("PAY_ITEM_CD:{toName:\"payItemCd\"},");
		MAPPING_ASSET_PAY_D_INFO.append("MONEY:{toName:\"money\"},");
		MAPPING_ASSET_PAY_D_INFO.append("CONTRACT_CD:{toName:\"contractCd\"},");
		MAPPING_ASSET_PAY_D_INFO.append("CREATE_DATE:{toName:\"createDate\"},");
		MAPPING_ASSET_PAY_D_INFO.append("UPDATE_DATE:{toName:\"updateDate\"},");
		MAPPING_ASSET_PAY_D_INFO.append("CREATE_USERID:{toName:\"createUserId\"},");
		MAPPING_ASSET_PAY_D_INFO.append("UPDATE_USERID:{toName:\"updateUserId\"}");
		MAPPING_ASSET_PAY_D_INFO.append("}");
	}

	/**
	 * 类型转换AssetInfo
	 * 
	 * @param asset
	 * @return
	 */
	public static AssetPayDetailDto copyMapToAssetPayDInfo(Map<String, Object> assetPay) {
		if (assetPay == null || !(assetPay.size() > 0)) {
			return null;
		}
		AssetPayDetailDto assetPayDto = new AssetPayDetailDto();
		PropertyUtils.copy(assetPayDto, assetPay, "{fieldOnly:false}", MAPPING_ASSET_PAY_D_INFO.toString());
		return assetPayDto;
	}
}
