/**
 *
 * file_name   : CourseFindService.java
 * @date       : 2016年12月12日
 * @author     : Ricardo Shaw
 * @email      : ricardoshaw@qq.com
 * @changedate : 下午7:13:04
 * 
 **/
package com.ricardo.fservice;

import java.util.List;

import com.ricardo.entity.Course;

/**
 * @author : Ricardo Shaw
 * @date   : 2016年12月12日 下午7:13:04
 */
public interface CourseFindService  extends IBaseFindService{
	public Course findByCourseId(String courseId);
	
	public List<Course> findAll();
	
	public List<Course> findByCourseIdCourseName(String courseId,String courseName,int offset);
	
	public int getMaxPage(String courseId,String courseName);
}
