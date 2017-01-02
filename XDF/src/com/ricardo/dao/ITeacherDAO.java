/**
 *
 * file_name   : ITeacherDAO.java
 * @date       : 2016��11��27��
 * @author     : Ricardo Shaw
 * @email      : ricardoshaw@qq.com
 * @changedate : ����4:48:33
 * 
 **/
package com.ricardo.dao;

import java.util.List;

import com.ricardo.entity.Teacher;

/**
 * @author : Ricardo Shaw
 * @date   : 2016��11��27�� ����4:48:33
 */
public interface ITeacherDAO  extends IBaseDAO{
	
	public Teacher findById(java.lang.String id);
	
	public int findByTiTp(String teacherId,String password);
	
	public List<Teacher> findByTnTt(String teacherName,String teacherTelephone,int offset);
	
	public int calculatePageSize(String teacherName,String teacherTelephone);
	
	
	
}
