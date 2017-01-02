/**
 *
 * file_name   : StudentServiceImpl.java
 * @date       : 2016年12月9日
 * @author     : Ricardo Shaw
 * @email      : ricardoshaw@qq.com
 * @changedate : 下午6:26:25
 * 
 **/
package com.ricardo.service.impl;

import java.util.List;

import com.ricardo.dao.IStudentDAO;
import com.ricardo.entity.Student;
import com.ricardo.service.StudentService;

/**
 * @author : Ricardo Shaw
 * @date   : 2016年12月9日 下午6:26:25
 */
public class StudentServiceImpl implements StudentService {
	private IStudentDAO istudentDao;
	

	public IStudentDAO getIstudentDao() {
		return istudentDao;
	}

	public void setIstudentDao(IStudentDAO istudentDao) {
		this.istudentDao = istudentDao;
	}

	public List<Student> findBySnSt(String studentName, String studentPhone,
			int offset) {
		return istudentDao.findBySnSt(studentName, studentPhone, offset);
	}

	public Student findBySi(String studentId) {
		return istudentDao.findById(studentId);
	}

	public List<Student> findBySnSt(Student student, int offset) {
		return istudentDao.findBySnSt(student.getStudentName(), student.getStudentTelephone(), offset);
	}


	public int getMaxPage(String studentName, String studentPhone) {
		return istudentDao.calculatePageSize(studentName, studentPhone);
	}

	public String addStudent(Student student) {
		try{
			istudentDao.save(student);
			return "message|学生存储成功";
		}catch(Exception e){
			return "error|学生存储失败";
		}
	}

	public String modifyStudent(Student student) {
		try{
			istudentDao.attachDirty(student);
			return "message|学生修改成功";
		}catch(Exception e){
			return "error|学生修改失败";
		}
	}

	public String deleteStudent(Student student) {
		try{
			istudentDao.delete(student);
			return "message|学生删除成功";
		}catch(Exception e){
			return "error|学生删除失败";
		}
	}

}
