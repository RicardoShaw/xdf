/**
 *
 * file_name   : StudentModifyService.java
 * @date       : 2016��11��28��
 * @author     : Ricardo Shaw
 * @email      : ricardoshaw@qq.com
 * @changedate : ����3:55:13
 * 
 **/
package com.ricardo.mservice;

import com.ricardo.entity.Student;



/**
 * @author : Ricardo Shaw
 * @date   : 2016��11��28�� ����3:55:13
 */
public interface StudentModifyService {
	public String addStudent(Student student);
	public String modifyStudent(Student student);
	public String deleteStudent(Student student);
}
