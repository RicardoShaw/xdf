/**
 *
 * file_name   : IClDAO.java
 * @date       : 2016��11��27��
 * @author     : Ricardo Shaw
 * @email      : ricardoshaw@qq.com
 * @changedate : ����4:01:29
 * 
 **/
package com.ricardo.dao;

import java.util.List;

import com.ricardo.entity.Cl;

/**
 * @author : Ricardo Shaw
 * @date   : 2016��11��27�� ����4:01:29
 */
public interface IClDAO  extends IBaseDAO{
	
	public Cl findById(String classId) ;
	
	public List<Cl> findAll();
	
	public List<Cl> findByClNameClStartDateClEndDate(String className,String startDate,String endDate,int offset);
	
	public int calculatePageSize(String className,String startDate,String endDate);

}
