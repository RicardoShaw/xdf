/**
 *
 * file_name   : LoginBaseAction.java
 * @date       : 2016年12月9日
 * @author     : Ricardo Shaw
 * @email      : ricardoshaw@qq.com
 * @changedate : 下午1:48:13
 * 
 **/
package com.ricardo.baseaction;

import com.opensymphony.xwork2.ActionSupport;
import com.ricardo.service.LoginService;

/**
 * @author : Ricardo Shaw
 * @date   : 2016年12月9日 下午1:48:13
 */
public class LoginBaseAction extends ActionSupport {
	protected LoginService loginService;

	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
	
	
}
