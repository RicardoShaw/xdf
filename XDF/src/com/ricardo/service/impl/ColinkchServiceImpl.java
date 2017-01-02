/**
 *
 * file_name   : ColinkchServiceImpl.java
 * @date       : 2016年12月15日
 * @author     : Ricardo Shaw
 * @email      : ricardoshaw@qq.com
 * @changedate : 下午3:03:57
 * 
 **/
package com.ricardo.service.impl;

import java.util.List;

import com.ricardo.dao.IColinkchDAO;
import com.ricardo.entity.Colinkch;
import com.ricardo.service.ColinkchService;

/**
 * @author : Ricardo Shaw
 * @date   : 2016年12月15日 下午3:03:57
 */
public class ColinkchServiceImpl implements ColinkchService {
	private IColinkchDAO icolinkchDao;
	
	public IColinkchDAO getIcolinkchDao() {
		return icolinkchDao;
	}

	public void setIcolinkchDao(IColinkchDAO icolinkchDao) {
		this.icolinkchDao = icolinkchDao;
	}


	
	public List<Colinkch> findAll() {
		return icolinkchDao.findAll();
	}




	public String addColinkch(Colinkch colinkch) {
		try{
			icolinkchDao.save(colinkch);
			return "message|课程章节连接成功";
		}catch(Exception e){
			return "error|课程章节连接失败";
		}
	}


	public String modifyColinkch(Colinkch colinkch) {
		try{
			icolinkchDao.attachDirty(colinkch);
			return "message|课程章节修改成功";
		}catch(Exception e){
			return "error|课程章节修改失败";
		}
	}


	public String deleteColinkch(Colinkch colinkch) {
		try{
			icolinkchDao.delete(colinkch);
			return "message|课程章节删除成功";
		}catch(Exception e){
			return "error|课程章节删除失败";
		}
	}

	public List<Colinkch> findByCnCn(String courseName,
			String chapterName, int offset) {
		return icolinkchDao.findByCnCn(courseName, chapterName, offset);
	}


	public int getMaxPage(String courseName, String chapterName) {
		return icolinkchDao.calculatePageSize(courseName, chapterName);
	}


	public Colinkch findByCi(int id) {
		return icolinkchDao.findById(id);
	}


	public int findByCiCi(String courseId, String chapterId) {
		return icolinkchDao.findByCiCi(courseId, chapterId);
	}

}
