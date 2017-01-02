/**
 *
 * file_name   : IStudentDAO.java
 * @date       : 2016��11��27��
 * @author     : Ricardo Shaw
 * @email      : ricardoshaw@qq.com
 * @changedate : ����4:37:46
 * 
 **/
package com.ricardo.dao;

import java.util.List;

import com.ricardo.entity.Student;

/**
 * @author : Ricardo Shaw
 * @date   : 2016��11��27�� ����4:37:46
 */
public interface IStudentDAO  extends IBaseDAO{

	public Student findById(java.lang.String id) ;

	public List<Student> findBySnSt(String studentName,String studentPhone,int offset);
	
	public int calculatePageSize(String studentName,String studentPhone);

}
