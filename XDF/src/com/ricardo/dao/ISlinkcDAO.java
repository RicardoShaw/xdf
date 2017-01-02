/**
 *
 * file_name   : ISlinkcDAO.java
 * @date       : 2016��11��27��
 * @author     : Ricardo Shaw
 * @email      : ricardoshaw@qq.com
 * @changedate : ����4:22:07
 * 
 **/
package com.ricardo.dao;




import java.util.List;

import com.ricardo.entity.Slinkc;

/**
 * @author : Ricardo Shaw
 * @date   : 2016��11��27�� ����4:22:07
 */
public interface ISlinkcDAO  extends IBaseDAO{

	public Slinkc findById(java.lang.Integer id) ;

	public List<Slinkc> findByClId(String classId);
	
	public int findBySiCi(String studentId,String classId);

	public List<Slinkc> findBySnCi(String studentName,String classId,int offset);
	
	public int calculatePageSize(String studentName,String classId);
 	
}
