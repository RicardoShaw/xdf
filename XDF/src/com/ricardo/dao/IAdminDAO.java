/**
 *
 * file_name   : IAdminDAO.java
 * @date       : 2016��11��27��
 * @author     : Ricardo Shaw
 * @email      : ricardoshaw@qq.com
 * @changedate : ����3:46:48
 * 
 **/
package com.ricardo.dao;


import java.util.List;

import com.ricardo.entity.Admin;

/**
 * @author : Ricardo Shaw
 * @date   : 2016��11��27�� ����3:46:48
 */
public interface IAdminDAO extends IBaseDAO{
	// property constants
	
	
	Admin findById(java.lang.String id) ;

	List<Admin> findByPassword(Object password) ;
	
	Admin merge(Admin detachedInstance) ;
	
	int findByNP(Admin admin);
	
	int findByNP(String username,String password);
	
}
