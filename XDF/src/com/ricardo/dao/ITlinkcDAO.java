/**
 *
 * file_name   : ITlinkcDAO.java
 * @date       : 2016��11��27��
 * @author     : Ricardo Shaw
 * @email      : ricardoshaw@qq.com
 * @changedate : ����4:54:31
 * 
 **/
package com.ricardo.dao;



import java.util.List;

import com.ricardo.entity.Tlinkc;

/**
 * @author : Ricardo Shaw
 * @date   : 2016��11��27�� ����4:54:31
 */
public interface ITlinkcDAO  extends IBaseDAO{
	
	public Tlinkc findById(java.lang.Integer id) ;
	
	public void delete(int id);
	
	public int findByTiCi(String teacherId,String classId);
	
	public List<Tlinkc> findByTiCn(String teacherId,String className,String classStartDate,String classEndDate,int offset);
	
	public int calculatePageSize(String teacherId,String className,String classStartDate,String classEndDate);
	
	public List<Tlinkc> findByTnCiCnCsCe(String teacherName,String classId,String className,String classStartDate,String classEndDate,int offset);
	
	public int  calculatePageSize(String teacherName,String classId,String className,String classStartDate,String classEndDate);
}
