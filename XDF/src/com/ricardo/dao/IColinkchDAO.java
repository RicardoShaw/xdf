/**
 *
 * file_name   : IColinkchDAO.java
 * @date       : 2016��11��27��
 * @author     : Ricardo Shaw
 * @email      : ricardoshaw@qq.com
 * @changedate : ����4:09:29
 * 
 **/
package com.ricardo.dao;


import java.util.List;

import com.ricardo.entity.Colinkch;

/**
 * @author : Ricardo Shaw
 * @date   : 2016��11��27�� ����4:09:29
 */
public interface IColinkchDAO  extends IBaseDAO{
	
	public Colinkch findById(java.lang.Integer id) ;
	
	public List<Colinkch> findByCnCn(String courseName,String chapterName,int offset);

	public int calculatePageSize(String courseName,String chapterName);
	
	public int findByCiCi(String courseId,String chapterId);
}
