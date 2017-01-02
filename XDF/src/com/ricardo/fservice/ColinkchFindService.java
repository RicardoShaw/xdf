/**
 *
 * file_name   : ColinkchFindService.java
 * @date       : 2016年12月12日
 * @author     : Ricardo Shaw
 * @email      : ricardoshaw@qq.com
 * @changedate : 下午7:16:10
 * 
 **/
package com.ricardo.fservice;

import java.util.List;

import com.ricardo.entity.Colinkch;

/**
 * @author : Ricardo Shaw
 * @date   : 2016年12月12日 下午7:16:10
 */
public interface ColinkchFindService  extends IBaseFindService{
	public List<Colinkch> findAll();
	
	public Colinkch findByCi(int id);
	
	public List<Colinkch> findByCnCn(String courseName,String chapterName,int offset);
	
	public int getMaxPage(String courseName,String chapterName);
	
	public int findByCiCi(String courseId,String chapterId);
}
