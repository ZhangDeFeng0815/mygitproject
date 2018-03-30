package com.tyyd.crps.scf.partner.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.tyyd.common.po.PartnerInfo;
import com.tyyd.framework.core.util.PropertyUtils;

public class PartnerDto extends PartnerInfo implements Serializable {
	private static final long serialVersionUID = 273210894244343840L;
	private List<Long> partnerIdList = null;
	private List<String> partnerNameList = null;
	private String startRow;
	private String endRow;
	private Long lastPartnerId;

	public List<Long> getPartnerIdList() {
		return partnerIdList;
	}

	public void setPartnerIdList(List<Long> partnerIdList) {
		this.partnerIdList = partnerIdList;
	}

	public List<String> getPartnerNameList() {
		return partnerNameList;
	}

	public void setPartnerNameList(List<String> partnerNameList) {
		this.partnerNameList = partnerNameList;
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

	public Long getLastPartnerId() {
		return lastPartnerId;
	}

	public void setLastPartnerId(Long lastPartnerId) {
		this.lastPartnerId = lastPartnerId;
	}
	
	//合作商基本信息字段映射
	private static StringBuilder MAPPING_PARTNERINFO = new StringBuilder();
	static{
		MAPPING_PARTNERINFO.append("{");
		MAPPING_PARTNERINFO.append("PARTNER_ID:{toName:\"partnerId\"},");
		MAPPING_PARTNERINFO.append("PARTNER_NAME:{toName:\"partnerName\"},");
		MAPPING_PARTNERINFO.append("PARTNER_TYPE:{toName:\"partnerType\"},");
		MAPPING_PARTNERINFO.append("IS_DELETED:{toName:\"isDeleted\"},");
		MAPPING_PARTNERINFO.append("MEMO:{toName:\"memo\"},");
		MAPPING_PARTNERINFO.append("CREATE_DATE:{toName:\"createDate\"},");
		MAPPING_PARTNERINFO.append("UPDATE_DATE:{toName:\"updateDate\"},");
		MAPPING_PARTNERINFO.append("CREATE_USERID:{toName:\"createUserId\"},");
		MAPPING_PARTNERINFO.append("UPDATE_USERID:{toName:\"updateUserId\"}");
		MAPPING_PARTNERINFO.append("}");
	}
	
	/**
	 * 类型转换PartnerInfo
	 * @param partner
	 * @return
	 */
	public static PartnerDto copyMapToPartnerInfo(Map<String, Object> partner) {
		if (partner == null || !(partner.size() > 0)) {
			return null;
		}
		PartnerDto partnerDto = new PartnerDto();
		PropertyUtils.copy(partnerDto, partner, "{fieldOnly:false}", MAPPING_PARTNERINFO.toString());
		return partnerDto;
	}
}
