package com.tyyd.crps.scf.contract.service.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;

import com.tyyd.common.po.ContractIn;
import com.tyyd.framework.core.util.PropertyUtils;

public class ContractInDto extends ContractIn implements Serializable {
	
	private String filePath = null;
	private String fileName = null;
	private String costpStr = null;// 千字稿酬

	/**
	 * 
	 */
	private static final long serialVersionUID = -9207074693706777642L;
	// 获权合同基本信息字段映射
	private static StringBuilder MAPPING_CONTRACTININFO = new StringBuilder();
	static {
		MAPPING_CONTRACTININFO.append("{");
		MAPPING_CONTRACTININFO.append("CONTRACT_ID:{toName:\"contractId\"},");
		MAPPING_CONTRACTININFO.append("CONTRACT_CD:{toName:\"contractCd\"},");
		MAPPING_CONTRACTININFO.append("PARTNER_ID:{toName:\"partnerId\"},");
		MAPPING_CONTRACTININFO.append("PARTNER_NAME:{toName:\"partnerName\"},");
		MAPPING_CONTRACTININFO.append("COST_P_1000:{toName:\"costP\"},");
		MAPPING_CONTRACTININFO.append("IS_DELETED:{toName:\"isDeleted\"},");
		MAPPING_CONTRACTININFO.append("ATTACHMENT_ID:{toName:\"attachmentId\"},");
		MAPPING_CONTRACTININFO.append("CREATE_DATE:{toName:\"createDate\"},");
		MAPPING_CONTRACTININFO.append("UPDATE_DATE:{toName:\"updateDate\"},");
		MAPPING_CONTRACTININFO.append("CREATE_USERID:{toName:\"createUserId\"},");
		MAPPING_CONTRACTININFO.append("UPDATE_USERID:{toName:\"updateUserId\"},");
		MAPPING_CONTRACTININFO.append("PATH:{toName:\"filePath\"},");
		MAPPING_CONTRACTININFO.append("FILE_NAME:{toName:\"fileName\"}");
		MAPPING_CONTRACTININFO.append("}");
	}

	/**
	 * 类型转换ContractInDto
	 * 
	 * @param asset
	 * @return
	 */
	public static ContractInDto copyMapToContractInDto(Map<String, Object> contractIn) {
		if (contractIn == null || !(contractIn.size() > 0)) {
			return null;
		}
		ContractInDto contractInDto = new ContractInDto();
		PropertyUtils.copy(contractInDto, contractIn, "{fieldOnly:false}", MAPPING_CONTRACTININFO.toString());
		return contractInDto;
	}
	
	/**
	 * dto转map
	 * @param in
	 * @return
	 */
	public static Map<String, Object> copyContractInDtoToMap(ContractInDto in) {
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
		if (in.getCostP() != null) {
			MapUtils.safeAddToMap(params, "COST_P_1000", in.getCostP());
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

	public String getCostpStr() {
		return costpStr;
	}

	public void setCostpStr(String costpStr) {
		this.costpStr = costpStr;
	}
}
