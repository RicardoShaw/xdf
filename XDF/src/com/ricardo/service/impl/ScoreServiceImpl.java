/**
 *
 * file_name   : ScoreServiceImpl.java
 * @date       : 2016年12月13日
 * @author     : Ricardo Shaw
 * @email      : ricardoshaw@qq.com
 * @changedate : 下午4:00:50
 * 
 **/
package com.ricardo.service.impl;

import java.util.List;

import com.ricardo.dao.IScoreDAO;
import com.ricardo.entity.Score;
import com.ricardo.service.ScoreService;

/**
 * @author : Ricardo Shaw
 * @date   : 2016年12月13日 下午4:00:50
 */
public class ScoreServiceImpl implements ScoreService {
	private IScoreDAO iscoreDao;

	public IScoreDAO getIscoreDao() {
		return iscoreDao;
	}


	public void setIscoreDao(IScoreDAO iscoreDao) {
		this.iscoreDao = iscoreDao;
	}


	public List<Score> findBySnCnCnCn(String studentName, String classId,
			String courseName, String chapterName, int offset) {
		return iscoreDao.findBySnCnCnCn(studentName, classId,  chapterName, offset);
	}



	public List<Score> findBySnCnCnCn(String studentName, String classId,
			String courseName, String chapterName, float dtupperlimit,
			float dtlowerlimit, int offset) {
		return iscoreDao.findBySnCnCnCnDt(studentName, classId, chapterName, dtupperlimit, dtlowerlimit, offset);
	}


	public Score findByScId(int id) {
		return iscoreDao.findById(id);
	}



	public int getMaxPage(String studentName,String classId,String courseName,String chapterName) {
		return iscoreDao.calculatePageSize(studentName, classId, chapterName);
	}



	public int getMaxPage(String studentName,String classId,String courseName,String chapterName,float dtupperlimit,float dtlowerlimit) {
		return iscoreDao.calculatePageSize(studentName, classId, chapterName,dtupperlimit,dtlowerlimit);
	}



	public String addScore(Score score) {
		try{
			iscoreDao.save(score);
			return "message|分数存储成功";
		}catch(Exception e){
			return "error|分数存储失败";
		}
	}



	public String modifyScore(Score score) {
		try{
			iscoreDao.attachDirty(score);
			return "message|分数更新成功";
		}catch(Exception e){
			return "error|分数更新失败";
		}
	}


	public String deleteScore(Score score) {
		try{
			iscoreDao.delete(score);
			return "message|分数删除成功";
		}catch(Exception e){
			return "error|分数删除失败";
		}
	}


}
