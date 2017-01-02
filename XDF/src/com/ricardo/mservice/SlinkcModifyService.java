/**
 *
 * file_name   : SlinkcModifyService.java
 * @date       : 2016��11��28��
 * @author     : Ricardo Shaw
 * @email      : ricardoshaw@qq.com
 * @changedate : ����3:54:24
 * 
 **/
package com.ricardo.mservice;

import com.ricardo.entity.Slinkc;



/**
 * @author : Ricardo Shaw
 * @date   : 2016��11��28�� ����3:54:24
 */
public interface SlinkcModifyService {
	
		public String addSlinkc(Slinkc slinkc);
		
		public String modifySlinkc(Slinkc slinkc);
		
		public String deleteSlinkc(Slinkc slinkc);
}
