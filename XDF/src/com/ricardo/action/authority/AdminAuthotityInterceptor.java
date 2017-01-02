/**
 *
 * file_name   : AdminAuthotityInterceptor.java
 * @date       : 2016年11月28日
 * @author     : Ricardo Shaw
 * @email      : ricardoshaw@qq.com
 * @changedate : 上午12:11:25
 * 
 **/
package com.ricardo.action.authority;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.ricardo.action.WebConstant;

/**
 * @author : Ricardo Shaw
 * @date   : 2016年11月28日 上午12:11:25
 */
public class AdminAuthotityInterceptor extends AbstractInterceptor {

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.interceptor.AbstractInterceptor#intercept(com.opensymphony.xwork2.ActionInvocation)
	 */

	public String intercept(ActionInvocation invocation) throws Exception {
		//创建ActionContext实例
		ActionContext ctx = ActionContext.getContext();
		//获取HttpSession的Level属性
		String level = (String) ctx.getSession().get(WebConstant.LEVEL);
		//如果level不为null，且level为admin
		if(level != null && level.equals(WebConstant.ADMIN_LEVEL)){
			return invocation.invoke();
		}else{
			return Action.LOGIN;
		}
	}

}
