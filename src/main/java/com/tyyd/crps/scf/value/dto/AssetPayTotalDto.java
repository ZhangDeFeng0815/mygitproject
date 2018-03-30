package com.tyyd.crps.scf.value.dto;

import java.io.Serializable;
import java.util.Map;

import com.tyyd.common.po.AssetPayTotal;
import com.tyyd.framework.core.util.PropertyUtils;

public class AssetPayTotalDto extends AssetPayTotal implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2354582029629698891L;
	// 合作商基本信息字段映射
	private static StringBuilder MAPPING_ASSET_PAY_T_INFO = new StringBuilder();
	static {
		MAPPING_ASSET_PAY_T_INFO.append("{");
		MAPPING_ASSET_PAY_T_INFO.append("ASSET_PAY_T_ID:{toName:\"id\"},");
		MAPPING_ASSET_PAY_T_INFO.append("ASSET_ID:{toName:\"assetId\"},");
		MAPPING_ASSET_PAY_T_INFO.append("PAY_ITEM_CD:{toName:\"payItemCd\"},");
		MAPPING_ASSET_PAY_T_INFO.append("MONEY:{toName:\"money\"},");
		MAPPING_ASSET_PAY_T_INFO.append("CONTRACT_CD:{toName:\"contractCd\"},");
		MAPPING_ASSET_PAY_T_INFO.append("CREATE_DATE:{toName:\"createDate\"},");
		MAPPING_ASSET_PAY_T_INFO.append("UPDATE_DATE:{toName:\"updateDate\"},");
		MAPPING_ASSET_PAY_T_INFO.append("CREATE_USERID:{toName:\"createUserId\"},");
		MAPPING_ASSET_PAY_T_INFO.append("UPDATE_USERID:{toName:\"updateUserId\"}");
		MAPPING_ASSET_PAY_T_INFO.append("}");
	}

	/**
	 * 类型转换AssetInfo
	 * 
	 * @param asset
	 * @return
	 */
	public static AssetPayTotalDto copyMapToAssetPayTInfo(Map<String, Object> assetPay) {
		if (assetPay == null || !(assetPay.size() > 0)) {
			return null;
		}
		AssetPayTotalDto assetPayDto = new AssetPayTotalDto();
		PropertyUtils.copy(assetPayDto, assetPay, "{fieldOnly:false}", MAPPING_ASSET_PAY_T_INFO.toString());
		return assetPayDto;
	}
}
