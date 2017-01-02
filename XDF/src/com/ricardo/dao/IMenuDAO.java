/**
 *
 * file_name   : IMenuDAO.java
 * @date       : 2016年11月27日
 * @author     : Ricardo Shaw
 * @email      : ricardoshaw@qq.com
 * @changedate : 下午4:15:30
 * 
 **/
package com.ricardo.dao;

import java.util.List;

import com.ricardo.entity.Menu;

/**
 * @author : Ricardo Shaw
 * @date   : 2016年11月27日 下午4:15:30
 */
public interface IMenuDAO  extends IBaseDAO{


	public Menu findById(java.lang.Integer id);



	

}
