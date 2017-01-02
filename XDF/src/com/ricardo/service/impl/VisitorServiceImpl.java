/**
 *
 * file_name   : VisitorServiceImpl.java
 * @date       : 2016��12��5��
 * @author     : Ricardo Shaw
 * @email      : ricardoshaw@qq.com
 * @changedate : ����7:14:39
 * 
 **/
package com.ricardo.service.impl;

import java.util.List;

import com.ricardo.dao.IClDAO;
import com.ricardo.dao.IScoreDAO;
import com.ricardo.dao.IStudentDAO;
import com.ricardo.dao.ITeacherDAO;
import com.ricardo.dao.ITlinkcDAO;
import com.ricardo.entity.Cl;
import com.ricardo.entity.Score;
import com.ricardo.entity.Student;
import com.ricardo.entity.Teacher;
import com.ricardo.entity.Tlinkc;
import com.ricardo.service.VisitorService;

/**
 * @author : Ricardo Shaw
 * @date   : 2016��12��5�� ����7:14:39
 */
public class VisitorServiceImpl implements VisitorService {
	private ITeacherDAO iteacherDao;
	private IStudentDAO istudentDao;
	private IClDAO iclDao;
	private ITlinkcDAO itlinkcDao;
	private IScoreDAO iscoreDao;

	
	public IScoreDAO getIscoreDao() {
		return iscoreDao;
	}

	public void setIscoreDao(IScoreDAO iscoreDao) {
		this.iscoreDao = iscoreDao;
	}

	public ITeacherDAO getIteacherDao() {
		return iteacherDao;
	}

	public void setIteacherDao(ITeacherDAO iteacherDao) {
		this.iteacherDao = iteacherDao;
	}

	public IStudentDAO getIstudentDao() {
		return istudentDao;
	}

	public void setIstudentDao(IStudentDAO istudentDao) {
		this.istudentDao = istudentDao;
	}

	public IClDAO getIclDao() {
		return iclDao;
	}

	public void setIclDao(IClDAO iclDao) {
		this.iclDao = iclDao;
	}

	public ITlinkcDAO getItlinkcDao() {
		return itlinkcDao;
	}

	public void setItlinkcDao(ITlinkcDAO itlinkcDao) {
		this.itlinkcDao = itlinkcDao;
	}


	public List<Teacher> findByTnTt(String teacherName,String teacherPhone, int offset, int pageSize) {
		return iteacherDao.findByTnTt(teacherName,teacherPhone, offset);
	}


	public List<Tlinkc> findByCiCnTn(String teacherName,String classId,String className,String classStartDate,String classEndDate, int offset,
			int pageSize) {
		return itlinkcDao.findByTnCiCnCsCe(teacherName,classId,className,classStartDate,classEndDate, offset);
	}



	public List<Score> findByCnCnCn(String studentName,String className, String courseName,
			String chapterName,Float dtupperlimit,Float dtlowerlimit, int offset, int pageSize) {
		return iscoreDao.findBySnCnCnCnDt(studentName, className, chapterName, dtupperlimit, dtlowerlimit, offset);
	}


	public Teacher findByTi(String username) {
		return iteacherDao.findById(username);
	}


	public Cl findByCi(String classId) {
		return iclDao.findById(classId);
	}

	public List<Student> findBySnSt(String studentName, String studentPhone,
			int offset) {
		return istudentDao.findBySnSt(studentName, studentPhone, offset);
	}

	public Student findBySi(String studentId) {
		// TODO Auto-generated method stub
		return istudentDao.findById(studentId);
	}

	public List<Cl> findAll(int offset,int pageSize) {
		// TODO Auto-generated method stub
		return iclDao.findAll();
	}

	public List<Score> findByCnCnCn(String studentName, String className,
			String courseName, String chapterName, int offset, int pageSize) {
		return iscoreDao.findBySnCnCnCn(studentName, className, chapterName,  offset);
	}

	public List<Cl> findAll() {
		return  iclDao.findAll();
	}

	public List<Cl> findByClNameClStartDateEndDate(String className,
			String startDate, String endDate, int offset) {
		return null;
	}


	public int getMaxPage(String className, String startDate, String endDate) {
		return 0;
	}


	public List<Score> findBySnCnCnCn(String studentName, String className,
			String courseName, String chapterName, float dtupperlimit,
			float dtlowerlimit, int offset) {
		return null;
	}


	public List<Score> findBySnCnCnCn(String studentName, String className,
			String courseName, String chapterName, int offset) {

		return null;
	}


	public Score findByScId(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	public int getMaxPage(String studentName, String className,
			String courseName, String chapterName, float dtupperlimit,
			float dtlowerlimit) {
		// TODO Auto-generated method stub
		return 0;
	}


	public int getMaxPage(String studentName, String className,
			String courseName, String chapterName) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.ricardo.fservice.TeacherFindService#findByTnTt(java.lang.String, java.lang.String, int)
	 */
	@Override
	public List<Teacher> findByTnTt(String teacherName, String teacherPhone,
			int offset) {
		return null;
	}


	public int getPageSize(String teacherName, String teacherPhone) {
		return 0;
	}


	public int validate(String username, String password) {
		return 0;
	}


	public int getMaxPage(String studentName, String studentPhone) {
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.ricardo.fservice.TlinkcFindService#findByCiCnTn(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int)
	 */
	@Override
	public List<Tlinkc> findByCiCnTn(String teacherName, String classId,
			String className, String classStartDate, String classEndDate,
			int offset) {
		// TODO Auto-generated method stub
		return null;
	}


	public int calculatePageSize(String teacherName, String classId,
			String className, String classStartDate, String classEndDate) {
		// TODO Auto-generated method stub
		return 0;
	}


	public List<Tlinkc> findByTiCn(String username, String className, int offset) {
		// TODO Auto-generated method stub
		return null;
	}


	public int calculatePageSize(String username, String className) {
		// TODO Auto-generated method stub
		return 0;
	}


	public Tlinkc findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	public int findByTiCi(String username, String classId) {
		// TODO Auto-generated method stub
		return 0;
	}


	public int getMaxPage(String teacherName, String classId, String className,
			String classStartDate, String classEndDate) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.ricardo.fservice.TlinkcFindService#findByTiCn(java.lang.String, java.lang.String, java.lang.String, java.lang.String, int)
	 */
	@Override
	public List<Tlinkc> findByTiCn(String username, String className,
			String classStartDate, String classEndDate, int offset) {
		// TODO Auto-generated method stub
		return null;
	}





}
