/**
 * 版权所有：天翼文化
 * 项目名称: 编审平台
 * 创建者: qintao
 * 创建日期: 2018-3-5
 * 文件说明: 合作商子系统  合作商查询 Service
 */
package com.tyyd.partner.service;

import java.util.List;
import java.util.Map;

import com.tyyd.framework.core.BusinessException;

public interface PartnerSearchService {
	/**
	 * 根据指定条件查询合作商列表
	 * 
	 * @param partnerIdList
	 * @param partnerNameList
	 * @param params
	 * @param startRow
	 * @param endRow
	 * @return
	 * @throws BusinessException
	 */
	public List<Map<String, Object>> searchPartnerList(List<Long> partnerIdList, List<String> partnerNameList,
			Map<String, Object> params, String startRow, String endRow) throws BusinessException;

	/**
	 * 根据指定条件查询合作商列表总记录数
	 * 
	 * @param partnerIdList
	 * @param partnerNameList
	 * @param params
	 * @return
	 * @throws BusinessException
	 */
	public int searchPartnerListCount(List<Long> partnerIdList, List<String> partnerNameList,
			Map<String, Object> params) throws BusinessException;

	/**
	 * 合作商列表导出
	 * 
	 * @param partnerIdList
	 * @param partnerNameList
	 * @param params
	 * @param lastPartnerId
	 * @return
	 * @throws BusinessException
	 */
	public List<Map<String, Object>> searchPartnersExport(List<Long> partnerIdList, List<String> partnerNameList,
			Map<String, Object> params, Long lastPartnerId) throws BusinessException;

	/**
	 * 根据合作商ID查询合作商的基本信息
	 * 
	 * @param partnerId
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> getPartnerInfoById(Long partnerId) throws BusinessException;
}
