package com.ricardo.entity;

import java.util.Set;

/**
 * Student entity. @author MyEclipse Persistence Tools
 */
public class Student extends AbstractStudent implements java.io.Serializable {

	// Constructors

	/**
	 * 
	 */
	private static final long serialVersionUID = -406390686528789530L;

	/** default constructor */
	public Student() {
	}

	/** minimal constructor */
	public Student(String studentName, String studentTelephone) {
		super(studentName, studentTelephone);
	}

	/** full constructor */
	public Student(String studentName, String studentSex,
			String studentBirthday, String studentPhoto,
			String studentTelephone, String studentEmail, String studentQq,
			String studentAddress, Set slinkcs, Set scores) {
		super(studentName, studentSex, studentBirthday, studentPhoto,
				studentTelephone, studentEmail, studentQq, studentAddress,
				slinkcs, scores);
	}

}
