/**
 *
 * file_name   : TeacherFindService.java
 * @date       : 2016��12��5��
 * @author     : Ricardo Shaw
 * @email      : ricardoshaw@qq.com
 * @changedate : ����7:33:35
 * 
 **/
package com.ricardo.fservice;

import java.util.List;

import com.ricardo.entity.Teacher;

/**
 * @author : Ricardo Shaw
 * @date   : 2016��12��5�� ����7:33:35
 */
public interface TeacherFindService  extends IBaseFindService{

	public List<Teacher> findByTnTt(String teacherName,String teacherPhone,int offset);
	
	public int getPageSize(String teacherName,String teacherPhone);
	
	public int validate(String username,String password);
	
	public Teacher findByTi(String username);
	
	
}
