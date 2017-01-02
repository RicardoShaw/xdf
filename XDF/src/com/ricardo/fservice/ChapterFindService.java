/**
 *
 * file_name   : ChapterFindService.java
 * @date       : 2016年12月12日
 * @author     : Ricardo Shaw
 * @email      : ricardoshaw@qq.com
 * @changedate : 下午7:12:18
 * 
 **/
package com.ricardo.fservice;

import java.util.List;

import com.ricardo.entity.Cchapter;

/**
 * @author : Ricardo Shaw
 * @date   : 2016年12月12日 下午7:12:18
 */
public interface ChapterFindService extends IBaseFindService{
	
	public List<Cchapter> findAll();
	
	public Cchapter findByChId(String chapterId);
	
	public List<Cchapter> findByChIdChN(String chapterId,String chapterName,int offset);
	
	public int getMaxPage(String chapterId, String chapterName);

}
