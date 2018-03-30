package com.tyyd.common.dao;

import java.util.List;
import java.util.Map;

import com.tyyd.framework.core.dao.BaseDao;

public interface PartnerDao extends BaseDao {
	/**
	 * 根据指定条件查询合作商列表
	 * @param partnerIdList
	 * @param partnerNameList   
	 * @param params
	 * @param startRow
	 * @param endRow
	 * @return
	 */

	public List<Map<String, Object>> selectPartnersByParams(List<Long> partnerIdList, List<String> partnerNameList, Map<String, Object> params, String startRow, String endRow);
	
	/**
	 * 根据指定条件查询合作商列表总记录数
	 * @param partnerIdList
	 * @param partnerNameList
	 * @param params
	 * @return
	 */
	public Integer selectPartnersCountByParams(List<Long> partnerIdList, List<String> partnerNameList, Map<String, Object> params);
	
	/**
	 * 合作商列表导出
	 * @param partnerIdList
	 * @param partnerNameList
	 * @param params
	 * @param lastPartnerId
	 * @return
	 */
	public List<Map<String, Object>> selectPartnersExport(List<Long> partnerIdList, List<String> partnerNameList, Map<String, Object> params, Long lastPartnerId);
}
