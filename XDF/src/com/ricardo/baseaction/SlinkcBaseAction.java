/**
 *
 * file_name   : SlinkcBaseAction.java
 * @date       : 2016年12月18日
 * @author     : Ricardo Shaw
 * @email      : ricardoshaw@qq.com
 * @changedate : 下午4:29:57
 * 
 **/
package com.ricardo.baseaction;

import com.opensymphony.xwork2.ActionSupport;
import com.ricardo.service.ClassService;
import com.ricardo.service.SlinkcService;
import com.ricardo.service.StudentService;
import com.ricardo.service.TeacherService;

/**
 * @author : Ricardo Shaw
 * @date   : 2016年12月18日 下午4:29:57
 */
public class SlinkcBaseAction extends ActionSupport {
	protected SlinkcService slinkcService;
	protected ClassService classService;
	protected StudentService studentService;
	protected TeacherService teacherService;
	

	public SlinkcService getSlinkcService() {
		return slinkcService;
	}

	public void setSlinkcService(SlinkcService slinkcService) {
		this.slinkcService = slinkcService;
	}

	public ClassService getClassService() {
		return classService;
	}

	public void setClassService(ClassService classService) {
		this.classService = classService;
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public TeacherService getTeacherService() {
		return teacherService;
	}

	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}


	
	
}
