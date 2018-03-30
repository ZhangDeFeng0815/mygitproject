package com.tyyd.crps.scf.value.dto;

import java.io.Serializable;
import java.util.Map;

import com.tyyd.common.po.AssetIncomeTotal;
import com.tyyd.framework.core.util.PropertyUtils;

public class AssetIncomeTotalDto extends AssetIncomeTotal implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2354582029629698891L;
	private static StringBuilder MAPPING_ASSET_INCOME_T_INFO = new StringBuilder();
	static {
		MAPPING_ASSET_INCOME_T_INFO.append("{");
		MAPPING_ASSET_INCOME_T_INFO.append("ASSET_INCOME_T_ID:{toName:\"id\"},");
		MAPPING_ASSET_INCOME_T_INFO.append("ASSET_ID:{toName:\"assetId\"},");
		MAPPING_ASSET_INCOME_T_INFO.append("INCOME_ITEM_CD:{toName:\"incomeItemCd\"},");
		MAPPING_ASSET_INCOME_T_INFO.append("MONEY:{toName:\"money\"},");
		MAPPING_ASSET_INCOME_T_INFO.append("CONTRACT_CD:{toName:\"contractCd\"},");
		MAPPING_ASSET_INCOME_T_INFO.append("CREATE_DATE:{toName:\"createDate\"},");
		MAPPING_ASSET_INCOME_T_INFO.append("UPDATE_DATE:{toName:\"updateDate\"},");
		MAPPING_ASSET_INCOME_T_INFO.append("CREATE_USERID:{toName:\"createUserId\"},");
		MAPPING_ASSET_INCOME_T_INFO.append("UPDATE_USERID:{toName:\"updateUserId\"}");
		MAPPING_ASSET_INCOME_T_INFO.append("}");
	}

	/**
	 * 类型转换AssetIncomeTotalDto
	 * 
	 * @param assetIncome
	 * @return
	 */
	public static AssetIncomeTotalDto copyMapToAssetIncomeTInfo(Map<String, Object> assetIncome) {
		if (assetIncome == null || !(assetIncome.size() > 0)) {
			return null;
		}
		AssetIncomeTotalDto assetIncomeDto = new AssetIncomeTotalDto();
		PropertyUtils.copy(assetIncomeDto, assetIncome, "{fieldOnly:false}", MAPPING_ASSET_INCOME_T_INFO.toString());
		return assetIncomeDto;
	}
}
