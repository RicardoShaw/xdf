/**
 *
 * file_name   : ICchapterDAO.java
 * @date       : 2016��11��27��
 * @author     : Ricardo Shaw
 * @email      : ricardoshaw@qq.com
 * @changedate : ����3:55:04
 * 
 **/
package com.ricardo.dao;

import java.util.List;

import com.ricardo.entity.Cchapter;

/**
 * @author : Ricardo Shaw
 * @date   : 2016��11��27�� ����3:55:04
 */
public interface ICchapterDAO extends IBaseDAO{

	public Cchapter findById(java.lang.String id) ;

	public List<Cchapter> findByChIdChN(String chapterId,String chapterName,int offset) ;

	public Cchapter merge(Cchapter detachedInstance);
	
	public int calculatePageSize(String chapterId,String chapterName);
	
}
