/**
 * 版权所有：天翼文化
 * 项目名称: 文字版权管理
 * 创建者: wangdf
 * 创建日期: 2018-2-11
 * 文件说明: SCF demo
 */
package com.tyyd.crps.scf.demo.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.tyyd.crps.scf.demo.service.ScfDemoService;
import com.tyyd.framework.core.util.ExceptionUtils;
import com.tyyd.framework.log.Logger;
import com.tyyd.framework.log.LoggerFactory;

@Service("scfDemoService")
public class ScfDemoServiceImpl implements ScfDemoService {

	public static Logger logger = LoggerFactory.getLogger(ScfDemoServiceImpl.class);
	
	/**
	 * 欢迎 小明
	 */
	@Override
	public Map<String, Object> wellcome(String userName) {
		if(StringUtils.isBlank(userName)){
			ExceptionUtils.throwAcwsException("用户名不能为空!");
		}
		
		Map<String, Object> outputData = new HashMap<String, Object>();
		outputData.put("RET_STRING", "欢迎， " + userName);
		
		return outputData;
	}
}
