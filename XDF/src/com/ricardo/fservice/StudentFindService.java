/**
 *
 * file_name   : StudentFindService.java
 * @date       : 2016��12��5��
 * @author     : Ricardo Shaw
 * @email      : ricardoshaw@qq.com
 * @changedate : ����7:40:14
 * 
 **/
package com.ricardo.fservice;

import java.util.List;

import com.ricardo.entity.Student;

/**
 * @author : Ricardo Shaw
 * @date   : 2016��12��5�� ����7:40:14
 */
public interface StudentFindService  extends IBaseFindService{

	public List<Student> findBySnSt(String studentName,String studentPhone,int offset);
	
	public Student findBySi(String studentId);
	
	public int getMaxPage(String studentName,String studentPhone);
}
