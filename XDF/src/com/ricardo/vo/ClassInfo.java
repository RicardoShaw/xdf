/**
 *
 * file_name   : ClassInfo.java
 * @date       : 2016年12月2日
 * @author     : Ricardo Shaw
 * @email      : ricardoshaw@qq.com
 * @changedate : 下午2:59:36
 * 
 **/
package com.ricardo.vo;

import java.io.Serializable;

/**
 * @author : Ricardo Shaw
 * @date   : 2016年12月2日 下午2:59:36
 */
public class ClassInfo implements Serializable{
	private String classId;
	private String className;
	private String classTeacher;
	private  String classDate;
	private String classPlace;
	private String classStartDate;
	private String classEndDate;
	
	public ClassInfo(){}
	

	
	
	
	/**
	 * @param classId
	 * @param className
	 * @param classTeacher
	 * @param classDate
	 * @param classPlace
	 * @param classStartDate
	 * @param classEndDate
	 */
	public ClassInfo(String classId, String className, String classTeacher,
			String classDate, String classPlace, String classStartDate,
			String classEndDate) {
		super();
		this.classId = classId;
		this.className = className;
		this.classTeacher = classTeacher;
		this.classDate = classDate;
		this.classPlace = classPlace;
		this.classStartDate = classStartDate;
		this.classEndDate = classEndDate;
	}





	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getClassTeacher() {
		return classTeacher;
	}
	public void setClassTeacher(String classTeacher) {
		this.classTeacher = classTeacher;
	}
	public String getClassDate() {
		return classDate;
	}
	public void setClassDate(String classDate) {
		this.classDate = classDate;
	}
	public String getClassPlace() {
		return classPlace;
	}
	public void setClassPlace(String classPlace) {
		this.classPlace = classPlace;
	}
	public String getClassStartDate() {
		return classStartDate;
	}
	public void setClassStartDate(String classStartDate) {
		this.classStartDate = classStartDate;
	}
	public String getClassEndDate() {
		return classEndDate;
	}
	public void setClassEndDate(String classEndDate) {
		this.classEndDate = classEndDate;
	}
	
	
	
	
	
	
	
}
