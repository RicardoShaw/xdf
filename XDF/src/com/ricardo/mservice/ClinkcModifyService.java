/**
 *
 * file_name   : ClinkcModifyService.java
 * @date       : 2016��11��28��
 * @author     : Ricardo Shaw
 * @email      : ricardoshaw@qq.com
 * @changedate : ����3:42:52
 * 
 **/
package com.ricardo.mservice;

import com.ricardo.entity.Clinkc;



/**
 * @author : Ricardo Shaw
 * @date   : 2016��11��28�� ����3:42:52
 */
public interface ClinkcModifyService {
	public String addClinkc(Clinkc clinkc);
	
	public String modifyClinkc(Clinkc clinkc);
	
	public String deleteClinkc(Clinkc clinkc);

}
