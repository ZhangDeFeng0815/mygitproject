package com.tyyd.crps.scf.partner.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.tyyd.crps.scf.partner.dto.PartnerDto;
import com.tyyd.crps.scf.partner.service.ScfPartnerEditService;
import com.tyyd.framework.core.BusinessException;
import com.tyyd.framework.core.util.ExceptionUtils;
import com.tyyd.framework.core.util.MapUtils;
import com.tyyd.framework.log.Logger;
import com.tyyd.framework.log.LoggerFactory;
import com.tyyd.partner.service.PartnerEditService;

@Service("scfPartnerEditService")
public class ScfPartnerEditServiceImpl implements ScfPartnerEditService {

	public static Logger logger = LoggerFactory.getLogger(ScfPartnerEditServiceImpl.class);

	@Resource
	private PartnerEditService partnerEditService;

	/**
	 * 新增、修改保存合作商
	 */
	@Override
	public Integer savePartner(PartnerDto partner) throws BusinessException {
		Map<String, Object> params = new HashMap<String, Object>();
		MapUtils.safeAddToMap(params, "UPDATE_DATE", partner.getUpdateDate());
		MapUtils.safeAddToMap(params, "UPDATE_USERID", partner.getUpdateUserId());
		if (partner.getPartnerId() != null) {
			MapUtils.safeAddToMap(params, "PARTNER_ID", partner.getPartnerId());
		} else {
			MapUtils.safeAddToMap(params, "CREATE_DATE", partner.getCreateDate());
			MapUtils.safeAddToMap(params, "CREATE_USERID", partner.getCreateUserId());
		}
		if (StringUtils.isNotBlank(partner.getPartnerName())) {
			MapUtils.safeAddToMap(params, "PARTNER_NAME", partner.getPartnerName());
		} else {
			ExceptionUtils.throwAcwsException("合作商名称不能为空");
		}
		if (partner.getPartnerType() != null) {
			MapUtils.safeAddToMap(params, "PARTNER_TYPE", partner.getPartnerType());
		} else {
			ExceptionUtils.throwAcwsException("合作商类型不能为空");
		}
		if (partner.getMemo() != null) {
			if (StringUtils.isNotBlank(partner.getPartnerName())) {
				MapUtils.safeAddToMap(params, "MEMO", partner.getMemo());
			} else {
				MapUtils.safeAddToMap(params, "MEMO", " ");
			}
		}
		return partnerEditService.savePartner(params);
	}

	/**
	 * 删除指定合作商
	 */
	@Override
	public Integer deletedPartner(Long partnerId) throws BusinessException {
		return partnerEditService.deletePartner(partnerId);
	}

}