/**
 *
 * file_name   : CourseServiceImpl.java
 * @date       : 2016年12月15日
 * @author     : Ricardo Shaw
 * @email      : ricardoshaw@qq.com
 * @changedate : 下午5:47:40
 * 
 **/
package com.ricardo.service.impl;

import java.util.List;

import com.ricardo.dao.ICourseDAO;
import com.ricardo.entity.Course;
import com.ricardo.service.CourseService;

/**
 * @author : Ricardo Shaw
 * @date   : 2016年12月15日 下午5:47:40
 */
public class CourseServiceImpl implements CourseService {
	private ICourseDAO icourseDao;

	public ICourseDAO getIcourseDao() {
		return icourseDao;
	}

	public void setIcourseDao(ICourseDAO icourseDao) {
		this.icourseDao = icourseDao;
	}


	public Course findByCourseId(String courseId) {
		return icourseDao.findById(courseId);
	}


	public List<Course> findAll() {
		return icourseDao.findAll();
	}


	public List<Course> findByCourseIdCourseName(String courseId,
			String courseName, int offset) {
		return icourseDao.findByCoIdCoName(courseId, courseName, offset);
	}


	public int getMaxPage(String courseId, String courseName) {
		return icourseDao.calculatePageSize(courseId, courseName);
	}


	public String addCourse(Course course) {
		try{
			icourseDao.save(course);
			return "message|课程存储成功";
		}catch(Exception e){
			return "error|课程存储失败";
		}
	}


	public String modifyCourse(Course course) {
		try{
			icourseDao.attachDirty(course);
			return "message|课程更新成功";
		}catch(Exception e){
			return "error|课程更新失败";
		}
	}


	public String deleteCourse(Course course) {
		try{
			icourseDao.delete(course);
			return "message|课程删除成功";
		}catch(Exception e){
			return "error|课程删除失败";
		}
	}
		
}
