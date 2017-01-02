/**
 *
 * file_name   : StudentBaseAction.java
 * @date       : 2016年12月9日
 * @author     : Ricardo Shaw
 * @email      : ricardoshaw@qq.com
 * @changedate : 下午6:04:27
 * 
 **/
package com.ricardo.baseaction;

import com.opensymphony.xwork2.ActionSupport;
import com.ricardo.service.StudentService;

/**
 * @author : Ricardo Shaw
 * @date   : 2016年12月9日 下午6:04:27
 */
public class StudentBaseAction extends ActionSupport {
	protected StudentService studentService;

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	
}
