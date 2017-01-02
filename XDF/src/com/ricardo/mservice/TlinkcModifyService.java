/**
 *
 * file_name   : TlinkcModifyService.java
 * @date       : 2016年12月13日
 * @author     : Ricardo Shaw
 * @email      : ricardoshaw@qq.com
 * @changedate : 下午8:08:22
 * 
 **/
package com.ricardo.mservice;

import com.ricardo.entity.Tlinkc;

/**
 * @author : Ricardo Shaw
 * @date   : 2016年12月13日 下午8:08:22
 */
public interface TlinkcModifyService {
	public String addTlinkc(Tlinkc tlinkc);
	public String modifyTlinkc(Tlinkc tlinkc);
	public String deleteTlinkc(Tlinkc tlinkc);
}
