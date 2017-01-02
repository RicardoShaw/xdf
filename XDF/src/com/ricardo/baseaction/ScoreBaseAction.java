/**
 *
 * file_name   : ScoreBaseAction.java
 * @date       : 2016年12月13日
 * @author     : Ricardo Shaw
 * @email      : ricardoshaw@qq.com
 * @changedate : 下午4:05:02
 * 
 **/
package com.ricardo.baseaction;

import com.opensymphony.xwork2.ActionSupport;
import com.ricardo.service.ClassService;
import com.ricardo.service.ScoreService;
import com.ricardo.service.StudentService;

/**
 * @author : Ricardo Shaw
 * @date   : 2016年12月13日 下午4:05:02
 */
public class ScoreBaseAction extends ActionSupport {
	protected ScoreService scoreService;
	protected ClassService classService;
	protected StudentService studentService;

	public ScoreService getScoreService() {
		return scoreService;
	}

	public void setScoreService(ScoreService scoreService) {
		this.scoreService = scoreService;
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
	
	
}
