package com.ricardo.entity;

import java.util.Set;

/**
 * Course entity. @author MyEclipse Persistence Tools
 */
public class Course extends AbstractCourse implements java.io.Serializable {

	// Constructors

	/**
	 * 
	 */
	private static final long serialVersionUID = -2788171422092016160L;

	/** default constructor */
	public Course() {
	}

	/** minimal constructor */
	public Course(String courseId,String courseName) {
		super(courseId,courseName);
	}

	/** full constructor */
	public Course(String courseName, Set clinkcs, Set colinkchs) {
		super(courseName, clinkcs, colinkchs);
	}

}
