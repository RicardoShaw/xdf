/**
 *
 * file_name   : TeacherBaseAction.java
 * @date       : 2016年12月9日
 * @author     : Ricardo Shaw
 * @email      : ricardoshaw@qq.com
 * @changedate : 下午6:03:19
 * 
 **/
package com.ricardo.baseaction;

import com.opensymphony.xwork2.ActionSupport;
import com.ricardo.service.TeacherService;

/**
 * @author : Ricardo Shaw
 * @date   : 2016年12月9日 下午6:03:19
 */
public class TeacherBaseAction extends ActionSupport {
		protected TeacherService teacherService;

		public void setTeacherService(TeacherService teacherService) {
			this.teacherService = teacherService;
		}
		
		
}
