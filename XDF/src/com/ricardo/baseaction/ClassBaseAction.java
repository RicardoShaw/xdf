/**
 *
 * file_name   : ClassBaseAction.java
 * @date       : 2016年12月12日
 * @author     : Ricardo Shaw
 * @email      : ricardoshaw@qq.com
 * @changedate : 下午6:33:39
 * 
 **/
package com.ricardo.baseaction;

import com.opensymphony.xwork2.ActionSupport;
import com.ricardo.service.ClassService;

/**
 * @author : Ricardo Shaw
 * @date   : 2016年12月12日 下午6:33:39
 */
public class ClassBaseAction extends ActionSupport {
	protected ClassService classService;

	public ClassService getClassService() {
		return classService;
	}

	public void setClassService(ClassService classService) {
		this.classService = classService;
	}
	
}
