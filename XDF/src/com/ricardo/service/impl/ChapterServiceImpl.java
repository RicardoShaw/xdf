/**
 *
 * file_name   : ChapterServiceImpl.java
 * @date       : 2016年12月14日
 * @author     : Ricardo Shaw
 * @email      : ricardoshaw@qq.com
 * @changedate : 下午12:17:29
 * 
 **/
package com.ricardo.service.impl;

import java.util.List;

import com.ricardo.dao.ICchapterDAO;
import com.ricardo.entity.Cchapter;
import com.ricardo.service.ChapterService;

/**
 * @author : Ricardo Shaw
 * @date   : 2016年12月14日 下午12:17:29
 */
public class ChapterServiceImpl implements ChapterService {
	private ICchapterDAO icchapterDao;

	public ICchapterDAO getIcchapterDao() {
		return icchapterDao;
	}

	public void setIcchapterDao(ICchapterDAO icchapterDao) {
		this.icchapterDao = icchapterDao;
	}

	
	public List<Cchapter> findAll() {
		return icchapterDao.findAll();
	}

	public String addChapter(Cchapter chapter) {
		try{
			icchapterDao.save(chapter);
			return "message|章节存储成功";
		}catch(Exception e){
			return "error|章节存储失败";
		}
	}

	public String deleteChapter(Cchapter chapter){
		try{
			icchapterDao.delete(chapter);
			return "message|章节删除成功";
		}catch(Exception e){
			return "error|章节删除失败";
		}
	}
	
	
	public String modifyChapter(Cchapter chapter) {
		try{
			icchapterDao.attachDirty(chapter);
			return "message|章节更新成功";
		}catch(Exception e){
			return "error|章节更新失败";
		}
	}

	public List<Cchapter> findByChIdChN(String chapterId, String chapterName,int offset) {
		return icchapterDao.findByChIdChN(chapterId, chapterName,offset);
	}
	
	public int getMaxPage(String chapterId, String chapterName){
			return icchapterDao.calculatePageSize(chapterId, chapterName);
	}
	
	public Cchapter findByChId(String chapterId) {
		return icchapterDao.findById(chapterId);
	}




}
