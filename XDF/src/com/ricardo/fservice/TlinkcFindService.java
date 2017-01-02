/**
 *
 * file_name   : TlinkcFindService.java
 * @date       : 2016��12��5��
 * @author     : Ricardo Shaw
 * @email      : ricardoshaw@qq.com
 * @changedate : ����7:39:45
 * 
 **/
package com.ricardo.fservice;

import java.util.List;

import com.ricardo.entity.Tlinkc;

/**
 * @author : Ricardo Shaw
 * @date   : 2016��12��5�� ����7:39:45
 */
public interface TlinkcFindService  extends IBaseFindService{

	public List<Tlinkc> findByCiCnTn(String teacherName,String classId,String className,String classStartDate,String classEndDate,int offset);
	
	public int getMaxPage(String teacherName,String classId,String className,String classStartDate,String classEndDate);
	
	public List<Tlinkc> findByTiCn(String username,String className,String classStartDate,String classEndDate,int offset);
	
	public int getMaxPage(String username,String className,String classStartDate,String classEndDate);
	
	public Tlinkc findById(int id);
	
	public int findByTiCi(String username,String classId);
	

}
