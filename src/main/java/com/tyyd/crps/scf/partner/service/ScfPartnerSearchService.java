/**
 * 版权所有：天翼文化
 * 项目名称: 编审平台
 * 创建者: QinTao
 * 创建日期: 2017-5-17
 * 文件说明: 原创平台、内容抓取用Scf Service
 */
package com.tyyd.crps.scf.partner.service;

import java.util.List;
import java.util.Map;

import com.tyyd.crps.scf.partner.dto.PartnerDto;
import com.tyyd.framework.core.BusinessException;

public interface ScfPartnerSearchService {

	/**
	 * 根据指定条件查询合作商列表
	 * 
	 * @param partnerDto
	 * @return
	 * @throws BusinessException
	 */
	public List<PartnerDto> searchPartnerList(PartnerDto partnerDto) throws BusinessException;

	/**
	 * 根据指定条件查询合作商列表总记录数
	 * 
	 * @param partnerDto
	 * @return
	 * @throws BusinessException
	 */
	public int searchPartnerListCount(PartnerDto partnerDto) throws BusinessException;

	/**
	 * 合作商列表导出
	 * 
	 * @param partnerDto
	 * @return
	 * @throws BusinessException
	 */
	public List<PartnerDto> searchPartnersExport(PartnerDto partnerDto) throws BusinessException;

	/**
	 * 根据合作商ID查询合作商的基本信息
	 * 
	 * @param partnerId
	 * @return
	 * @throws BusinessException
	 */
	public PartnerDto getPartnerInfoById(Long partnerId) throws BusinessException;
}
