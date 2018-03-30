package com.tyyd.crps.scf.contract.service.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;

import com.tyyd.common.po.ContractOut;
import com.tyyd.framework.core.util.PropertyUtils;

public class ContractOutDto extends ContractOut implements Serializable {
	
	private static final long serialVersionUID = 8976349530645387002L;
	
	private String filePath = null;
	private String fileName = null;

	// 获权合同基本信息字段映射
	private static StringBuilder MAPPING_CONTRACTOUT_INFO = new StringBuilder();
	static {
		MAPPING_CONTRACTOUT_INFO.append("{");
		MAPPING_CONTRACTOUT_INFO.append("CONTRACT_ID:{toName:\"contractId\"},");
		MAPPING_CONTRACTOUT_INFO.append("CONTRACT_CD:{toName:\"contractCd\"},");
		MAPPING_CONTRACTOUT_INFO.append("PARTNER_ID:{toName:\"partnerId\"},");
		MAPPING_CONTRACTOUT_INFO.append("PARTNER_NAME:{toName:\"partnerName\"},");
		MAPPING_CONTRACTOUT_INFO.append("IS_DELETED:{toName:\"isDeleted\"},");
		MAPPING_CONTRACTOUT_INFO.append("ATTACHMENT_ID:{toName:\"attachmentId\"},");
		MAPPING_CONTRACTOUT_INFO.append("CREATE_DATE:{toName:\"createDate\"},");
		MAPPING_CONTRACTOUT_INFO.append("UPDATE_DATE:{toName:\"updateDate\"},");
		MAPPING_CONTRACTOUT_INFO.append("CREATE_USERID:{toName:\"createUserId\"},");
		MAPPING_CONTRACTOUT_INFO.append("UPDATE_USERID:{toName:\"updateUserId\"},");
		MAPPING_CONTRACTOUT_INFO.append("PATH:{toName:\"filePath\"},");
		MAPPING_CONTRACTOUT_INFO.append("FILE_NAME:{toName:\"fileName\"}");
		MAPPING_CONTRACTOUT_INFO.append("}");
	}

	/**
	 * 类型转换ContractInDto
	 * 
	 * @param asset
	 * @return
	 */
	public static ContractOutDto copyMapToContractOutDto(Map<String, Object> contractOut) {
		if (contractOut == null || !(contractOut.size() > 0)) {
			return null;
		}
		ContractOutDto contractOutDto = new ContractOutDto();
		PropertyUtils.copy(contractOutDto, contractOut, "{fieldOnly:false}", MAPPING_CONTRACTOUT_INFO.toString());
		return contractOutDto;
	}
	
	/**
	 * dto转map
	 * @param in
	 * @return
	 */
	public static Map<String, Object> copyContractOutDtoToMap(ContractOutDto in) {
		Map<String, Object> params = new HashMap<String, Object>();
		if (in.getContractId() != null) {
			MapUtils.safeAddToMap(params, "CONTRACT_ID", in.getContractId());
		}
		if (StringUtils.isNotBlank(in.getContractCd())) {
			MapUtils.safeAddToMap(params, "CONTRACT_CD", in.getContractCd());
		}
		if (in.getPartnerId() != null) {
			MapUtils.safeAddToMap(params, "PARTNER_ID", in.getPartnerId());
		}
		if (StringUtils.isNotBlank(in.getPartnerName())) {
			MapUtils.safeAddToMap(params, "PARTNER_NAME", in.getPartnerName());
		}
		if (in.getIsDeleted() != null) {
			MapUtils.safeAddToMap(params, "IS_DELETED", in.getIsDeleted());
		}
		if (in.getAttachmentId() != null) {
			MapUtils.safeAddToMap(params, "ATTACHMENT_ID", in.getAttachmentId());
		}
		if (in.getCreateDate() != null) {
			MapUtils.safeAddToMap(params, "CREATE_DATE", in.getCreateDate());
		}
		if (in.getUpdateDate() != null) {
			MapUtils.safeAddToMap(params, "UPDATE_DATE", in.getUpdateDate());
		}
		if (in.getCreateUserId() != null) {
			MapUtils.safeAddToMap(params, "CREATE_USERID", in.getCreateUserId());
		}
		if (in.getUpdateUserId() != null) {
			MapUtils.safeAddToMap(params, "UPDATE_USERID", in.getUpdateUserId());
		}
		if (in.getAttachmentId() != null) {
			MapUtils.safeAddToMap(params, "ATTACHMENT_ID", in.getAttachmentId());
		}
		if (StringUtils.isNotBlank(in.getFilePath())) {
			MapUtils.safeAddToMap(params, "PATH", in.getFilePath());
		}
		if (StringUtils.isNotBlank(in.getFileName())) {
			MapUtils.safeAddToMap(params, "FILE_NAME", in.getFileName());
		}
		return params;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
}
