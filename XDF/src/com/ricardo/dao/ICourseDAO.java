/**
 *
 * file_name   : ICourseDAO.java
 * @date       : 2016��11��27��
 * @author     : Ricardo Shaw
 * @email      : ricardoshaw@qq.com
 * @changedate : ����4:12:10
 * 
 **/
package com.ricardo.dao;

import java.util.List;

import com.ricardo.entity.Course;

/**
 * @author : Ricardo Shaw
 * @date   : 2016��11��27�� ����4:12:10
 */
public interface ICourseDAO  extends IBaseDAO{
	
	public Course findById(java.lang.String id) ;

	public List<Course> findByCoIdCoName(String courseId,String courseName,int offset) ;

	public int calculatePageSize(String courseId,String courseName);
	
	public Course merge(Course detachedInstance) ;


}
