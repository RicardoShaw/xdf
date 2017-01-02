/**
 *
 * file_name   : LoginServiceImpl.java
 * @date       : 2016年12月9日
 * @author     : Ricardo Shaw
 * @email      : ricardoshaw@qq.com
 * @changedate : 下午1:27:03
 * 
 **/
package com.ricardo.service.impl;

import com.ricardo.dao.ITeacherDAO;
import com.ricardo.service.LoginService;

/**
 * @author : Ricardo Shaw
 * @date   : 2016年12月9日 下午1:27:03
 */
public class LoginServiceImpl implements LoginService {
	private ITeacherDAO iteacherDao;
	
	public ITeacherDAO getIteacherDao() {
		return iteacherDao;
	}

	public void setIteacherDao(ITeacherDAO iteacherDao) {
		this.iteacherDao = iteacherDao;
	}


	public int findByTuTp(String username, String password) {
		return iteacherDao.findByTiTp(username, password);
	}

}
