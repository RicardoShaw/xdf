/**
 *
 * file_name   : CourseFindService.java
 * @date       : 2016��12��8��
 * @author     : Ricardo Shaw
 * @email      : ricardoshaw@qq.com
 * @changedate : ����12:13:25
 * 
 **/
package com.ricardo.fservice;

import java.util.List;

import com.ricardo.entity.Cl;

/**
 * @author : Ricardo Shaw
 * @date   : 2016��12��8�� ����12:13:25
 */
public interface ClFindService  extends IBaseFindService{
	public Cl findByCi(String classId);
	public List<Cl> findAll();
	public List<Cl> findByClNameClStartDateEndDate(String className,String startDate,String endDate,int offset);
	public int getMaxPage(String className,String startDate,String endDate);
	
}
