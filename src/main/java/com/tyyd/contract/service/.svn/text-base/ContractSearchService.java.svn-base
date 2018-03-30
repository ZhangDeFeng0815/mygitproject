/**
 * 版权所有：天翼文化
 * 项目名称: 编审平台
 * 创建者: qintao
 * 创建日期: 2018-3-5
 * 文件说明: 版权资产子系统  资产查询 Service
 */
package com.tyyd.contract.service;

import java.util.List;
import java.util.Map;

import com.tyyd.framework.core.BusinessException;

public interface ContractSearchService {

	/**
	 * 根据合同编号查询获权合同信息
	 * 
	 * @param contractCd
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> getContractInInfoByContractCd(String contractCd) throws BusinessException;
	
	/**
	 * 根据合同编号查询获权合同信息
	 * 
	 * @param contractCd
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> selectContractInByCdWithFile(String contractCd) throws BusinessException;
	
	/**
	 * 根据指定合同编号，是否存在授权合同
	 * @param contractCd
	 * @return
	 * @throws BusinessException
	 */
	public Integer existsContractInfoByContractCd(String contractCd, String type) throws BusinessException;
	
	/**
	 * 获权合同查询列表
	 * @param params
	 * @return
	 */
	public List<Map<String, Object>> selectContractInList(Map<String, Object> params, String startRow, String endRow) throws BusinessException;
	
	/**
	 * 获权合同查询列表计数
	 * @param params
	 * @return
	 */
	public Integer selectContractInListCount(Map<String, Object> params) throws BusinessException;
	
	/**
	 * 根据合同编号查询授权合同信息
	 * @param contractCd
	 * @return
	 * @throws BusinessException
	 */
	public Map<String, Object> selectContractOutByCdWithFile(String contractCd) throws BusinessException;
	
	/**
	 * 授权合同查询列表
	 * @param params
	 * @return
	 */
	public List<Map<String, Object>> selectContractOutList(Map<String, Object> params, String startRow, String endRow) throws BusinessException;
	
	/**
	 * 授权合同查询列表记录条数
	 * @param params
	 * @return
	 */
	public Integer selectContractOutListCount(Map<String, Object> params) throws BusinessException;
}
