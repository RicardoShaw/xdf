/**
 *
 * file_name   : ClinkcServiceImpl.java
 * @date       : 2016年12月18日
 * @author     : Ricardo Shaw
 * @email      : ricardoshaw@qq.com
 * @changedate : 下午7:16:46
 * 
 **/
package com.ricardo.service.impl;

import java.util.List;

import com.ricardo.dao.IClinkcDAO;
import com.ricardo.entity.Clinkc;
import com.ricardo.service.ClinkcService;

/**
 * @author : Ricardo Shaw
 * @date   : 2016年12月18日 下午7:16:46
 */
public class ClinkcServiceImpl implements ClinkcService {
	private IClinkcDAO iclinkcDao;
	

	public IClinkcDAO getIclinkcDao() {
		return iclinkcDao;
	}


	public void setIclinkcDao(IClinkcDAO iclinkcDao) {
		this.iclinkcDao = iclinkcDao;
	}


	public Clinkc findById(int id) {
		return iclinkcDao.findById(id);
	}


	public List<Clinkc> findByCnCn(String className, String courseName,
			int offset) {
		return iclinkcDao.findByCnCn(className, courseName, offset);
	}

	
	public int getMaxPage(String className, String courseName) {
		return iclinkcDao.calculatePageSize(className, courseName);
	}


	public int findByCiCi(String classId, String courseId) {
		return iclinkcDao.findByCiCi(classId, courseId);
	}


	public String addClinkc(Clinkc clinkc) {
		try{
			iclinkcDao.save(clinkc);
			return "message|班级课程关联成功";
		}catch(Exception e){
			return "error|班级课程关联失败";
		}
	}


	public String modifyClinkc(Clinkc clinkc) {
		try{
			iclinkcDao.attachDirty(clinkc);
			return "message|班级课程修改成功";
		}catch(Exception e){
			return "error|班级课程修改失败";
		}
	}


	public String deleteClinkc(Clinkc clinkc) {
		try{
			iclinkcDao.delete(clinkc);
			return "message|班级课程删除成功";
		}catch(Exception e){
			return "error|班级课程删除失败";
		}
	}

}
