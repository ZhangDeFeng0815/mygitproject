/**
 * 版权所有：天翼文化
 * 项目名称: 编审平台
 * 创建者: zhangdf
 * 创建日期: 2018-3-21
 * 文件说明: 合同管理子系统  合同编辑 Service
 */
package com.tyyd.contract.service;

import java.util.Map;

import com.tyyd.framework.core.BusinessException;

public interface ContractEditService {
	
	/**
	 * 统计指定资产是否存在收入合同与之关联
	 * @param assetId
	 * @return
	 * @throws BusinessException
	 */
	public Integer countContractInByAId(Long assetId) throws BusinessException;
	
	/**
	 * 统计指定资产是否存在成本合同与之关联
	 * @param assetId
	 * @return
	 * @throws BusinessException
	 */
	public Integer countContractOutByAId(Long assetId) throws BusinessException;
	
	/**
	 * 新增获权合同
	 * @param contractMap
	 * @return
	 * @throws BusinessException
	 */
	public Integer addContractIn(Map<String, Object> contractMap) throws BusinessException;
	
	/**
	 * 修改获权合同
	 * @param contractMap
	 * @return
	 * @throws BusinessException
	 */
	public Integer editContractIn(Map<String, Object> contractMap) throws BusinessException;
	
	/**
	 * 新增授权合同
	 * @param contractMap
	 * @return
	 * @throws BusinessException
	 */
	public Integer addContractOut(Map<String, Object> contractMap) throws BusinessException;
	
	/**
	 * 修改授权合同
	 * @param contractMap
	 * @return
	 * @throws BusinessException
	 */
	public Integer editContractOut(Map<String, Object> contractMap) throws BusinessException;

}
