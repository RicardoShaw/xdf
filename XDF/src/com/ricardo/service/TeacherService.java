/**
 *
 * file_name   : TeacherService.java
 * @date       : 2016��12��5��
 * @author     : Ricardo Shaw
 * @email      : ricardoshaw@qq.com
 * @changedate : ����7:27:14
 * 
 **/
package com.ricardo.service;

import com.ricardo.fservice.TeacherFindService;
import com.ricardo.mservice.TeacherModifyService;

/**
 * @author : Ricardo Shaw
 * @date   : 2016��12��5�� ����7:27:14
 */
public interface TeacherService extends TeacherFindService,TeacherModifyService{

	/**
	 * @param username
	 * @param password
	 * @return
	 */
	int findByTuTp(String username, String password);
	
}
