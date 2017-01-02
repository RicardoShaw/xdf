/**
 *
 * file_name   : SlinkcFindService.java
 * @date       : 2016年12月12日
 * @author     : Ricardo Shaw
 * @email      : ricardoshaw@qq.com
 * @changedate : 下午6:50:29
 * 
 **/
package com.ricardo.fservice;

import java.util.List;

import com.ricardo.entity.Slinkc;

/**
 * @author : Ricardo Shaw
 * @date   : 2016年12月12日 下午6:50:29
 */
public interface SlinkcFindService  extends IBaseFindService{
	
	public  Slinkc findById(int id);
	
	public List<Slinkc> findBySnCi(String studentName,String classId,int offset);
	
	public int getMaxPage(String studentName,String classId);
	
	public int findBySiCi(String studentId,String classId);
	
	
	public List<Slinkc> findAll();
 }
