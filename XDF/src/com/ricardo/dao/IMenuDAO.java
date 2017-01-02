/**
 *
 * file_name   : IMenuDAO.java
 * @date       : 2016��11��27��
 * @author     : Ricardo Shaw
 * @email      : ricardoshaw@qq.com
 * @changedate : ����4:15:30
 * 
 **/
package com.ricardo.dao;

import java.util.List;

import com.ricardo.entity.Menu;

/**
 * @author : Ricardo Shaw
 * @date   : 2016��11��27�� ����4:15:30
 */
public interface IMenuDAO  extends IBaseDAO{


	public Menu findById(java.lang.Integer id);



	

}
