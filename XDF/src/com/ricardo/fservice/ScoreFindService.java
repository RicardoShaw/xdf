/**
 *
 * file_name   : ScoreFindService.java
 * @date       : 2016��12��5��
 * @author     : Ricardo Shaw
 * @email      : ricardoshaw@qq.com
 * @changedate : ����7:38:41
 * 
 **/
package com.ricardo.fservice;

import java.util.List;

import com.ricardo.entity.Score;

/**
 * @author : Ricardo Shaw
 * @date   : 2016��12��5�� ����7:38:41
 */
public interface ScoreFindService  extends IBaseFindService{

	public List<Score> findBySnCnCnCn(String studentName,String classId,String courseName,String chapterName,float dtupperlimit,float dtlowerlimit,int offset);
	
	public List<Score> findBySnCnCnCn(String studentName,String classId,String courseName,String chapterName,int offset);
	
	public Score findByScId(int id);
	
	public int getMaxPage(String studentName,String classId,String courseName,String chapterName,float dtupperlimit,float dtlowerlimit);
	
	public int getMaxPage(String studentName,String classId,String courseName,String chapterName);
}
