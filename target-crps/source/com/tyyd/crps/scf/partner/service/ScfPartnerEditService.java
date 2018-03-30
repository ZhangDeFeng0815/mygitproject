/**
 * 版权所有：天翼文化
 * 项目名称: 编审平台
 * 创建者: QinTao
 * 创建日期: 2017-5-17
 * 文件说明: 原创平台、内容抓取用Scf Service
 */
package com.tyyd.crps.scf.partner.service;

import com.tyyd.crps.scf.partner.dto.PartnerDto;
import com.tyyd.framework.core.BusinessException;

public interface ScfPartnerEditService {
	/**
	 * 新增、修改保存合作商
	 * @param params
	 * @return
	 * @throws BusinessException
	 */
	public Integer savePartner(PartnerDto partner) throws BusinessException;
	
	/**
	 * 删除指定合作商
	 * @param partnerId
	 * @return
	 * @throws BusinessException
	 */
	public Integer deletedPartner(Long partnerId) throws BusinessException;
}
