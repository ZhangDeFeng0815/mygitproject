package com.tyyd.crps.scf.value.dto;

import java.io.Serializable;
import java.util.Map;

import com.tyyd.common.po.AssetIncomeDetail;
import com.tyyd.framework.core.util.PropertyUtils;

public class AssetIncomeDetailDto extends AssetIncomeDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5807866681144626231L;
	// 合作商基本信息字段映射
	private static StringBuilder MAPPING_ASSET_INCOME_D_INFO = new StringBuilder();
	static {
		MAPPING_ASSET_INCOME_D_INFO.append("{");
		MAPPING_ASSET_INCOME_D_INFO.append("ASSET_INCOME_D_ID:{toName:\"id\"},");
		MAPPING_ASSET_INCOME_D_INFO.append("ASSET_ID:{toName:\"assetId\"},");
		MAPPING_ASSET_INCOME_D_INFO.append("INCOME_ITEM_CD:{toName:\"incomeItemCd\"},");
		MAPPING_ASSET_INCOME_D_INFO.append("MONEY:{toName:\"money\"},");
		MAPPING_ASSET_INCOME_D_INFO.append("CONTRACT_CD:{toName:\"contractCd\"},");
		MAPPING_ASSET_INCOME_D_INFO.append("CREATE_DATE:{toName:\"createDate\"},");
		MAPPING_ASSET_INCOME_D_INFO.append("UPDATE_DATE:{toName:\"updateDate\"},");
		MAPPING_ASSET_INCOME_D_INFO.append("CREATE_USERID:{toName:\"createUserId\"},");
		MAPPING_ASSET_INCOME_D_INFO.append("UPDATE_USERID:{toName:\"updateUserId\"}");
		MAPPING_ASSET_INCOME_D_INFO.append("}");
	}

	/**
	 * 类型转换AssetInfo
	 * 
	 * @param asset
	 * @return
	 */
	public static AssetIncomeDetailDto copyMapToAssetIncomeDInfo(Map<String, Object> assetIncome) {
		if (assetIncome == null || !(assetIncome.size() > 0)) {
			return null;
		}
		AssetIncomeDetailDto assetIncomeDto = new AssetIncomeDetailDto();
		PropertyUtils.copy(assetIncomeDto, assetIncome, "{fieldOnly:false}", MAPPING_ASSET_INCOME_D_INFO.toString());
		return assetIncomeDto;
	}
}
