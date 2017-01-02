/**
 *
 * file_name   : IBaseDAO.java
 * @date       : 2016��11��27��
 * @author     : Ricardo Shaw
 * @email      : ricardoshaw@qq.com
 * @changedate : ����8:56:34
 * 
 **/
package com.ricardo.dao;

import java.util.List;

/**
 * @author : Ricardo Shaw
 * @date   : 2016��11��27�� ����8:56:34
 */
public interface IBaseDAO {
	public final static int pageSize=20;
	
	public void save(Object object) ;

	public void delete(Object object) ;
	
	public List findByExample(Object instance);
	
	public List findAll();
	
	public void attachDirty(Object instance) ;

	public void attachClean(Object instance) ;
	
}
