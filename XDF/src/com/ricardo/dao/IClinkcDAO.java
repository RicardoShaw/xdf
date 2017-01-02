/**
 *
 * file_name   : IClinkcDAO.java
 * @date       : 2016��11��27��
 * @author     : Ricardo Shaw
 * @email      : ricardoshaw@qq.com
 * @changedate : ����4:06:25
 * 
 **/
package com.ricardo.dao;

import java.util.List;

import com.ricardo.entity.Clinkc;

/**
 * @author : Ricardo Shaw
 * @date   : 2016��11��27�� ����4:06:25
 */
public interface IClinkcDAO  extends IBaseDAO{
	
	public Clinkc findById(java.lang.Integer id);

	public int findByCiCi(String classId,String courseId);
	
	public List<Clinkc> findByCnCn(String className,String courseName,int offset);
	
	public int calculatePageSize(String className,String courseName);

}
