/**
 *
 * file_name   : ClModifyService.java
 * @date       : 2016��11��28��
 * @author     : Ricardo Shaw
 * @email      : ricardoshaw@qq.com
 * @changedate : ����3:49:31
 * 
 **/
package com.ricardo.mservice;

import com.ricardo.entity.Cl;



/**
 * @author : Ricardo Shaw
 * @date   : 2016��11��28�� ����3:49:31
 */
public interface ClModifyService {
	
	public String addClass(Cl cl);
	
	public String modifyClass(Cl cl);
	
	public String deleteClass(Cl cl);
	
	
}
