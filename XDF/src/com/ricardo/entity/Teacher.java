package com.ricardo.entity;

import java.util.Set;

/**
 * Teacher entity. @author MyEclipse Persistence Tools
 */
public class Teacher extends AbstractTeacher implements java.io.Serializable {

	// Constructors

	/**
	 * 
	 */
	private static final long serialVersionUID = -2979361503357275565L;

	/** default constructor */
	public Teacher() {
	}

	
	
	public Teacher(String teacherId,String teacherName,String teacherPsw){
		super( teacherId, teacherName,teacherPsw);
	}
	
	/** minimal constructor */
	public Teacher(String teacherPsw, String teacherName) {
		super(teacherPsw, teacherName);
	}

	/** full constructor */
	public Teacher(String teacherPsw, String teacherName, String teacherSex,
			String teacherBirthday, String teacherArriveDate,
			String teacherCardNumber, String teacherPhone, String teacherPhoto,
			String teacherAddress, Set tlinkcs) {
		super(teacherPsw, teacherName, teacherSex, teacherBirthday,
				teacherArriveDate, teacherCardNumber, teacherPhone,
				teacherPhoto, teacherAddress, tlinkcs);
	}

}
