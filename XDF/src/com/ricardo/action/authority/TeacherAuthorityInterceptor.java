/**
 *
 * file_name   : TeacherAuthorityInterceptor.java
 * @date       : 2016��11��28��
 * @author     : Ricardo Shaw
 * @email      : ricardoshaw@qq.com
 * @changedate : ����12:10:55
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
 * @date   : 2016��11��28�� ����12:10:55
 */
public class TeacherAuthorityInterceptor extends AbstractInterceptor {

	/* (non-Javadoc)
	 * @see com.opensymphony.xwork2.interceptor.AbstractInterceptor#intercept(com.opensymphony.xwork2.ActionInvocation)
	 */
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		ActionContext ctx = ActionContext.getContext();
		//��ȡHttpSession��Level����
		String level = (String) ctx.getSession().get(WebConstant.LEVEL);
		//���level��Ϊnull����levelΪadmin
		if(level != null && level.equals(WebConstant.TEACHER_LEVEL)){
			return invocation.invoke();
		}else{
			return Action.LOGIN;
		}
	}

}
