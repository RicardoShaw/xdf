/**
 *
 * file_name   : ColinkchBaseAction.java
 * @date       : 2016年12月15日
 * @author     : Ricardo Shaw
 * @email      : ricardoshaw@qq.com
 * @changedate : 下午5:29:27
 * 
 **/
package com.ricardo.baseaction;

import com.opensymphony.xwork2.ActionSupport;
import com.ricardo.service.ChapterService;
import com.ricardo.service.ColinkchService;
import com.ricardo.service.CourseService;
import com.ricardo.service.TeacherService;

/**
 * @author : Ricardo Shaw
 * @date   : 2016年12月15日 下午5:29:27
 */
public class ColinkchBaseAction extends ActionSupport {
	protected ColinkchService colinkchService;
	protected ChapterService chapterService;
	protected CourseService courseService;
	protected TeacherService teacherService;
	

	public ChapterService getChapterService() {
		return chapterService;
	}

	public void setChapterService(ChapterService chapterService) {
		this.chapterService = chapterService;
	}

	public CourseService getCourseService() {
		return courseService;
	}

	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}

	public ColinkchService getColinkchService() {
		return colinkchService;
	}

	public void setColinkchService(ColinkchService colinkchService) {
		this.colinkchService = colinkchService;
	}

	public TeacherService getTeacherService() {
		return teacherService;
	}

	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}
	
	
	
}
