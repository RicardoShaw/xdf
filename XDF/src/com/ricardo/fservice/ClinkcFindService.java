/**
 *
 * file_name   : ClinkcFindService.java
 * @date       : 2016年12月12日
 * @author     : Ricardo Shaw
 * @email      : ricardoshaw@qq.com
 * @changedate : 下午7:15:51
 * 
 **/
package com.ricardo.fservice;

import java.util.List;

import com.ricardo.entity.Clinkc;

/**
 * @author : Ricardo Shaw
 * @date   : 2016年12月12日 下午7:15:51
 */
public interface ClinkcFindService  extends IBaseFindService{
	public Clinkc findById(int id);
	
	public List<Clinkc> findByCnCn(String className,String courseName,int offset);
	
	public int getMaxPage(String className,String courseName);
	
	public int findByCiCi(String classId,String courseId);
}
