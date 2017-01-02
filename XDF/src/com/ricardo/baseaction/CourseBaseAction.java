/**
 *
 * file_name   : CourseBaseAction.java
 * @date       : 2016年12月15日
 * @author     : Ricardo Shaw
 * @email      : ricardoshaw@qq.com
 * @changedate : 下午6:43:22
 * 
 **/
package com.ricardo.baseaction;

import com.opensymphony.xwork2.ActionSupport;
import com.ricardo.service.CourseService;

/**
 * @author : Ricardo Shaw
 * @date   : 2016年12月15日 下午6:43:22
 */
public class CourseBaseAction extends ActionSupport {
	protected CourseService courseService;

	public CourseService getCourseService() {
		return courseService;
	}

	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}
	
	


}
