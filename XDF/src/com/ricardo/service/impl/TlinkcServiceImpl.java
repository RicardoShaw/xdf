/**
 *
 * file_name   : TlinkcServiceImpl.java
 * @date       : 2016年12月14日
 * @author     : Ricardo Shaw
 * @email      : ricardoshaw@qq.com
 * @changedate : 上午11:45:21
 * 
 **/
package com.ricardo.service.impl;

import java.util.List;

import com.ricardo.dao.ITlinkcDAO;
import com.ricardo.entity.Tlinkc;
import com.ricardo.service.TlinkcService;

/**
 * @author : Ricardo Shaw
 * @date   : 2016年12月14日 上午11:45:21
 */
public class TlinkcServiceImpl implements TlinkcService {
	private ITlinkcDAO itlinkcDao;

	public ITlinkcDAO getItlinkcDao() {
		return itlinkcDao;
	}
	public void setItlinkcDao(ITlinkcDAO itlinkcDao) {
		this.itlinkcDao = itlinkcDao;
	}

	public List<Tlinkc> findByCiCnTn(String teacherName, String classId,
			String className, String classStartDate, String classEndDate,
			int offset) {
		return itlinkcDao.findByTnCiCnCsCe(teacherName, classId, className, classStartDate, classEndDate, offset);
	}

	public int getMaxPage(String teacherName, String classId,
			String className, String classStartDate, String classEndDate) {
		return itlinkcDao.calculatePageSize(teacherName, classId, className, classStartDate, classEndDate);
	}

	public List<Tlinkc> findByTiCn(String username, String className, String classStartDate,String classEndDate,int offset) {
		return itlinkcDao.findByTiCn(username, className,classStartDate,classEndDate, offset);
	}

	public int getMaxPage(String username, String className, String classStartDate,String classEndDate) {
		return itlinkcDao.calculatePageSize(username, className,classStartDate,classEndDate);
	}

	public Tlinkc findById(int id) {
		return itlinkcDao.findById(id);
	}

	public String addTlinkc(Tlinkc tlinkc) {
		try{
			itlinkcDao.save(tlinkc);
			return "message|教师选课存储成功";
		}catch(Exception e){
			return "error|教师选课失败";
		}
	}

	public String modifyTlinkc(Tlinkc tlinkc) {
		try{
			itlinkcDao.attachDirty(tlinkc);
			return "message|教师选课修改成功";
		}catch(Exception e){
			return "error|教师选课修改失败";
		}
	}

	public String deleteTlinkc(Tlinkc tlinkc) {
		try{
			itlinkcDao.delete(tlinkc);
			return "message|教师选课删除成功";
		}catch(Exception e){
			return "error|教师选课删除失败";
		}
	}

	public int findByTiCi(String username, String classId) {
		return itlinkcDao.findByTiCi(username, classId);
	}



	
}
