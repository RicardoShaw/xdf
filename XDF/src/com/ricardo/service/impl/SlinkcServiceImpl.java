/**
 *
 * file_name   : SlinkcServiceImpl.java
 * @date       : 2016年12月18日
 * @author     : Ricardo Shaw
 * @email      : ricardoshaw@qq.com
 * @changedate : 下午4:12:39
 * 
 **/
package com.ricardo.service.impl;

import java.util.List;

import com.ricardo.dao.ISlinkcDAO;
import com.ricardo.entity.Slinkc;
import com.ricardo.service.SlinkcService;

/**
 * @author : Ricardo Shaw
 * @date   : 2016年12月18日 下午4:12:39
 */
public class SlinkcServiceImpl implements SlinkcService {
	private ISlinkcDAO islinkcDao;
	
	public ISlinkcDAO getIslinkcDao() {
		return islinkcDao;
	}


	public void setIslinkcDao(ISlinkcDAO islinkcDao) {
		this.islinkcDao = islinkcDao;
	}


	public String addSlinkc(Slinkc slinkc) {
		try{
			islinkcDao.save(slinkc);
			return "message|学生班级关联成功";
		}catch(Exception e){
			return "error|学生班级关联失败";
		}
	}


	public String modifySlinkc(Slinkc slinkc) {
		try{
			islinkcDao.attachDirty(slinkc);
			return "message|学生班级修改成功";
		}catch(Exception e){
			return "error|学生班级修改失败";
		}
	}


	public String deleteSlinkc(Slinkc slinkc) {
		try{
			islinkcDao.delete(slinkc);
			return "message|学生班级删除成功";
		}catch(Exception e){
			return "error|学生班级删除失败";
		}
	}


	public Slinkc findById(int id) {
		return islinkcDao.findById(id);
	}


	public List<Slinkc> findBySnCi(String studentName, String classId,
			int offset) {
		return islinkcDao.findBySnCi(studentName, classId, offset);
	}


	public int getMaxPage(String studentName, String classId) {
		return islinkcDao.calculatePageSize(studentName, classId);
	}


	public int findBySiCi(String studentId, String classId) {
		return islinkcDao.findBySiCi(studentId, classId);
	}


	public List<Slinkc> findAll() {
		return islinkcDao.findAll();
	}

}
