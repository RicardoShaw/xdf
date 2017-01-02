/**
 *
 * file_name   : CreateCourseId.java
 * @date       : 2016年12月19日
 * @author     : Ricardo Shaw
 * @email      : ricardoshaw@qq.com
 * @changedate : 下午7:54:09
 * 
 **/
package com.ricardo.util;

import java.text.DecimalFormat;
import java.text.Format;

/**
 * @author : Ricardo Shaw
 * @date   : 2016年12月19日 下午7:54:09
 */
public class CreateCourseId {
	private static String cid="KC";
	private static int Id = 0;
	
	public static String getCourseId(int id){
		String c1;
		DecimalFormat f1 = new DecimalFormat("000");
		c1 = cid+f1.format(id);
		return c1;
	}
	
	public static String getCourseId(){
		String c1;
		DecimalFormat f1 = new DecimalFormat("000");
		c1 = cid+f1.format(Id);
		return c1;
	}
}
