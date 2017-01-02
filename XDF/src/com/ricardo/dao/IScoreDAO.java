/**
 *
 * file_name   : IScoreDAO.java
 * @date       : 2016��11��27��
 * @author     : Ricardo Shaw
 * @email      : ricardoshaw@qq.com
 * @changedate : ����4:18:48
 * 
 **/
package com.ricardo.dao;

import java.util.List;





import com.ricardo.entity.Score;

/**
 * @author : Ricardo Shaw
 * @date   : 2016��11��27�� ����4:18:48
 */
public interface IScoreDAO  extends IBaseDAO{
	
	
	public Score findById(java.lang.Integer id);

	public List<Score> findBySnCnCnCn(String studentName, String className,
			String chapterName, int offset);

	public int calculatePageSize(String studentName, String className,
			String chapterName);
	
	public List<Score> findBySnCnCnCnDt(String studentName, String className,
			String chapterName,float dtupperlimit,float dtlowerlimit, int offset);

	public int calculatePageSize(String studentName, String className,
			String chapterName,float dtupperlimit,float dtlowerlimit);
	
}
