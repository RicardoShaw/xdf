/**
 *
 * file_name   : CreateStudentId.java
 * @date       : 2016年12月19日
 * @author     : Ricardo Shaw
 * @email      : ricardoshaw@qq.com
 * @changedate : 下午8:10:12
 * 
 **/
package com.ricardo.util;


import java.text.DecimalFormat;
import java.util.Date;

/**
 * @author : Ricardo Shaw
 * @date   : 2016年12月19日 下午8:10:12
 */
public class CreateStudentId {
	private static String sid="S";
	private static int i = 1;
	
	public static String getStudentId(int id){
		String s1;
		DecimalFormat f1 = new DecimalFormat("000");
		s1 = sid+TimeUtil.formatTime(new Date())+f1.format(id);
		return s1;
	}
	public static String getStudentId(){
		String s1;
		DecimalFormat f1 = new DecimalFormat("000");
		s1 = sid+TimeUtil.formatTime(new Date())+f1.format(i);
		i++;
		return s1;
	}
}
