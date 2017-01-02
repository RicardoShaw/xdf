/**
 *
 * file_name   : TeacherModifyService.java
 * @date       : 2016��11��28��
 * @author     : Ricardo Shaw
 * @email      : ricardoshaw@qq.com
 * @changedate : ����3:57:52
 * 
 **/
package com.ricardo.mservice;

import com.ricardo.entity.Teacher;



/**
 * @author : Ricardo Shaw
 * @date   : 2016��11��28�� ����3:57:52
 */
public interface TeacherModifyService {
		
	public String addTeacher(Teacher teacher);
	
	public String modifyTeacher(Teacher teacher);
	
	public String deleteTeacher(Teacher teacher);

}
