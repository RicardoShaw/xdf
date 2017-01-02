/**
 *
 * file_name   : CourseModifyService.java
 * @date       : 2016��11��28��
 * @author     : Ricardo Shaw
 * @email      : ricardoshaw@qq.com
 * @changedate : ����3:52:06
 * 
 **/
package com.ricardo.mservice;

import com.ricardo.entity.Course;


/**
 * @author : Ricardo Shaw
 * @date   : 2016��11��28�� ����3:52:06
 */
public interface CourseModifyService {
	public String addCourse(Course course);
	
	public String modifyCourse(Course course);
	
	public String deleteCourse(Course course);
}
