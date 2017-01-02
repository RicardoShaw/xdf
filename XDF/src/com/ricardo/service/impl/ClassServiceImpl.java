/**
 *
 * file_name   : ClassServiceImpl.java
 * @date       : 2016年12月12日
 * @author     : Ricardo Shaw
 * @email      : ricardoshaw@qq.com
 * @changedate : 下午6:41:08
 * 
 **/
package com.ricardo.service.impl;

import java.util.List;

import com.ricardo.dao.IClDAO;
import com.ricardo.entity.Cl;
import com.ricardo.service.ClassService;

/**
 * @author : Ricardo Shaw
 * @date   : 2016年12月12日 下午6:41:08
 */
public class ClassServiceImpl implements ClassService {
	private IClDAO iclDao;
	

	public IClDAO getIclDao() {
		return iclDao;
	}


	public void setIclDao(IClDAO iclDao) {
		this.iclDao = iclDao;
	}


	public Cl findByCi(String classId) {
		return iclDao.findById(classId);
	}


	public List<Cl> findAll() {
		return iclDao.findAll();
	}


	public List<Cl> findByClNameClStartDateEndDate(String className,
			String startDate, String endDate, int offset) {
		return iclDao.findByClNameClStartDateClEndDate(className, startDate, endDate, offset);
	}



	public int getMaxPage(String className, String startDate, String endDate) {
		return iclDao.calculatePageSize(className, startDate, endDate);
	}


	public String addClass(Cl cl) {
		try{
			iclDao.save(cl);
			return "message|班级存储成功";
		}catch(Exception e){
			return "error|班级存储失败";
		}
	}


	public String modifyClass(Cl cl) {
		try{
			iclDao.attachDirty(cl);
			return "message|班级更新成功";
		}catch(Exception e){
			return "error|班级更新失败";
		}
	}



	public String deleteClass(Cl cl) {
		try{
			iclDao.delete(cl);
			return "message|班级删除成功";
		}catch(Exception e){
			return "error|班级删除失败";
		}
	}

}
