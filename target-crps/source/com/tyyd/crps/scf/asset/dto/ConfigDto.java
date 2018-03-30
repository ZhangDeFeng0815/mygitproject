package com.tyyd.crps.scf.asset.dto;

import java.io.Serializable;
import java.util.Map;

import com.tyyd.common.po.ConfigInfo;
import com.tyyd.framework.core.util.PropertyUtils;

public class ConfigDto extends ConfigInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4196262997440660839L;
	// 合作商基本信息字段映射
	private static StringBuilder MAPPING_CONFIGINFO = new StringBuilder();
	static {
		MAPPING_CONFIGINFO.append("{");
		MAPPING_CONFIGINFO.append("CONFIG_ID:{toName:\"configId\"},");
		MAPPING_CONFIGINFO.append("TYPE:{toName:\"type\"},");
		MAPPING_CONFIGINFO.append("CD:{toName:\"cd\"},");
		MAPPING_CONFIGINFO.append("NAME:{toName:\"name\"},");
		MAPPING_CONFIGINFO.append("IS_DELETED:{toName:\"is_deleted\"},");
		MAPPING_CONFIGINFO.append("SEQNO:{toName:\"seqno\"},");
		MAPPING_CONFIGINFO.append("MEMO:{toName:\"memo\"},");
		MAPPING_CONFIGINFO.append("CREATE_DATE:{toName:\"createDate\"},");
		MAPPING_CONFIGINFO.append("UPDATE_DATE:{toName:\"updateDate\"},");
		MAPPING_CONFIGINFO.append("CREATE_USERID:{toName:\"createUserId\"},");
		MAPPING_CONFIGINFO.append("UPDATE_USERID:{toName:\"updateUserId\"}");
		MAPPING_CONFIGINFO.append("}");
	}

	/**
	 * 类型转换ConfigDto
	 * 
	 * @param config
	 * @return
	 */
	public static ConfigDto copyMapToConfigInfo(Map<String, Object> config) {
		if (config == null || !(config.size() > 0)) {
			return null;
		}
		ConfigDto ConfigDto = new ConfigDto();
		PropertyUtils.copy(ConfigDto, config, "{fieldOnly:false}", MAPPING_CONFIGINFO.toString());
		return ConfigDto;
	}
}
