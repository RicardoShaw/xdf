/**
 *
 * file_name   : ClinkcBaseAction.java
 * @date       : 2016年12月18日
 * @author     : Ricardo Shaw
 * @email      : ricardoshaw@qq.com
 * @changedate : 下午7:21:33
 * 
 **/
package com.ricardo.baseaction;

import com.opensymphony.xwork2.ActionSupport;
import com.ricardo.service.ClassService;
import com.ricardo.service.ClinkcService;
import com.ricardo.service.CourseService;
import com.ricardo.service.TeacherService;

/**
 * @author : Ricardo Shaw
 * @date   : 2016年12月18日 下午7:21:33
 */
public class ClinkcBaseAction extends ActionSupport {
	protected ClinkcService clinkcService;
	protected ClassService classService;
	protected CourseService courseService;
	protected TeacherService teacherService;
	public ClinkcService getClinkcService() {
		return clinkcService;
	}
	public void setClinkcService(ClinkcService clinkcService) {
		this.clinkcService = clinkcService;
	}
	public ClassService getClassService() {
		return classService;
	}
	public void setClassService(ClassService classService) {
		this.classService = classService;
	}
	public CourseService getCourseService() {
		return courseService;
	}
	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}
	public TeacherService getTeacherService() {
		return teacherService;
	}
	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}
	
	
	
}
