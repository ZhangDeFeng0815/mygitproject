/**
 * 版权所有：天翼阅读
 * 项目名称:系统框架
 * 创建者: Wangdf
 * 创建日期: 2014-07-22
 * 文件说明: 用户权限类
 */
package com.tyyd.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tyyd.framework.core.util.SecurityBase;

/**
 * 用户权限类. 该spring bean的scope必须是request的（含有成员变量）
 * 
 * @author wangdf
 */
public class MySecurity extends SecurityBase {
	// 由于含有私有成员变量、所以该bean的scope必须是request
	HttpServletRequest request = null;

	/**
	 * 设置Request
	 * 
	 * @param request
	 */
	@Override
	public HttpServletRequest getRequest() {
		return request;
	}

	/**
	 * 设置Request
	 * 
	 * @param request
	 */
	public void setRequest(HttpServletRequest request) {
	}

	/**
	 * 取得用户信息
	 * 
	 * @return
	 * @author wangdf
	 */
	@Override
	public Object getUserObject() {
		return new Object();
	}

	/**
	 * 取得当前登陆名
	 * 
	 * @author wangdf
	 */
	@Override
	public String getUserLoginName() {
		return "system";
	}

	/**
	 * 获取当前登陆人的用户ID
	 * 
	 * @return
	 * @author wangdf
	 */
	@Override
	public Long getCurrentUserID() {
		return 1l;
	}

	/**
	 * 获取当前登陆人的用户名
	 * 
	 * @return
	 * @author wangdf
	 */
	@Override
	public String getCurrentUserName() {
		return "(系统)";
	}

	/**
	 * 获取当前登陆人的用户名
	 * 
	 * @return
	 * @author wangdf
	 */
	public String getCurrentUserNickname() {
		return "(系统)";
	}

	public void setResponse(HttpServletResponse request) {
	}

	@Override
	public HttpServletResponse getResponse() {
		return null;
	}
}
