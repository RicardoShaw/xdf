/**
 *
 * file_name   : ColinkchModifyService.java
 * @date       : 2016��11��28��
 * @author     : Ricardo Shaw
 * @email      : ricardoshaw@qq.com
 * @changedate : ����3:51:14
 * 
 **/
package com.ricardo.mservice;

import com.ricardo.entity.Colinkch;


/**
 * @author : Ricardo Shaw
 * @date   : 2016��11��28�� ����3:51:14
 */
public interface ColinkchModifyService {
		public String addColinkch(Colinkch colinkch);
		public String modifyColinkch(Colinkch colinkch);
		public String deleteColinkch(Colinkch colinkch);

}
