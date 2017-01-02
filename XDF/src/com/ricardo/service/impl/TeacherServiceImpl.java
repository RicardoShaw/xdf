/**
 *
 * file_name   : TeacherServiceImpl.java
 * @date       : 2016年12月9日
 * @author     : Ricardo Shaw
 * @email      : ricardoshaw@qq.com
 * @changedate : 下午6:08:23
 * 
 **/
package com.ricardo.service.impl;

import java.util.List;

import com.ricardo.dao.ITeacherDAO;
import com.ricardo.entity.Teacher;
import com.ricardo.service.TeacherService;

/**
 * @author : Ricardo Shaw
 * @date   : 2016年12月9日 下午6:08:23
 */
public class TeacherServiceImpl implements TeacherService {
	private ITeacherDAO iteacherDao;
	
	public ITeacherDAO getIteacherDao() {
		return iteacherDao;
	}

	public void setIteacherDao(ITeacherDAO iteacherDao) {
		this.iteacherDao = iteacherDao;
	}


	public List<Teacher> findByTnTt(String teacherName, String teacherPhone,
			int offset) {
		return iteacherDao.findByTnTt(teacherName, teacherPhone, offset);
	}


	public Teacher findByTi(String username) {
		return iteacherDao.findById(username);
	}

	public int getPageSize(String teacherName, String teacherPhone) {
		return iteacherDao.calculatePageSize(teacherName, teacherPhone);
	}

	public int validate(String username, String password) {
		return iteacherDao.findByTiTp(username, password);
	}


	public String addTeacher(Teacher teacher) {
		try{
			iteacherDao.save(teacher);
			return "message|教师存储成功";
		}catch(Exception e){
			return "error|教师存储失败";
		}
	}


	public String modifyTeacher(Teacher teacher) {
		try{
			iteacherDao.attachDirty(teacher);
			return "message|教师修改成功";
		}catch(Exception e){
			return "error|教师修改失败";
		}
	}

	public String deleteTeacher(Teacher teacher) {
		try{
			iteacherDao.delete(teacher);
			return "message|教师删除成功";
		}catch(Exception e){
			return "error|教师删除失败";
		}
	}

	public int findByTuTp(String username, String password) {
		return iteacherDao.findByTiTp(username, password);
	}

}
