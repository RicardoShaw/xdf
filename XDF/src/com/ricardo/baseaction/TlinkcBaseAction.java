/**
 *
 * file_name   : TlinkcBaseAction.java
 * @date       : 2016年12月17日
 * @author     : Ricardo Shaw
 * @email      : ricardoshaw@qq.com
 * @changedate : 下午7:34:32
 * 
 **/
package com.ricardo.baseaction;

import com.opensymphony.xwork2.ActionSupport;
import com.ricardo.service.ClassService;
import com.ricardo.service.TeacherService;
import com.ricardo.service.TlinkcService;

/**
 * @author : Ricardo Shaw
 * @date   : 2016年12月17日 下午7:34:32
 */
public class TlinkcBaseAction extends ActionSupport {
	protected TlinkcService tlinkcService;
	protected TeacherService teacherService;
	protected ClassService classService;
	public TlinkcService getTlinkcService() {
		return tlinkcService;
	}
	public void setTlinkcService(TlinkcService tlinkcService) {
		this.tlinkcService = tlinkcService;
	}
	public TeacherService getTeacherService() {
		return teacherService;
	}
	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}
	public ClassService getClassService() {
		return classService;
	}
	public void setClassService(ClassService classService) {
		this.classService = classService;
	}
	
}
