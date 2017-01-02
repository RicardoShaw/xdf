/**
 *
 * file_name   : LogoutAction.java
 * @date       : 2016��11��29��
 * @author     : Ricardo Shaw
 * @email      : ricardoshaw@qq.com
 * @changedate : ����12:10:16
 * 
 **/
package com.ricardo.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author : Ricardo Shaw
 * @date   : 2016��11��29�� ����12:10:16
 */
public class LogoutAction extends ActionSupport implements ServletRequestAware {
	
	private HttpServletRequest request;
	
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	public String excute() throws Exception{
		HttpSession session = request.getSession();
		session.invalidate();
		return SUCCESS;
	}
	
	
}
