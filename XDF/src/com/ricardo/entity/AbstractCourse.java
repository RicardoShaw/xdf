package com.ricardo.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractCourse entity provides the base persistence definition of the Course
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractCourse implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -7051074844751736805L;
	private String courseId;
	private String courseName;
	private Set clinkcs = new HashSet();
	private Set colinkchs = new HashSet();

	// Constructors

	/** default constructor */
	public AbstractCourse() {
	}

	/** minimal constructor */
	public AbstractCourse(String courseId,String courseName) {
		this.courseId = courseId;
		this.courseName = courseName;
	}

	/** full constructor */
	public AbstractCourse(String courseName, Set clinkcs, Set colinkchs) {
		this.courseName = courseName;
		this.clinkcs = clinkcs;
		this.colinkchs = colinkchs;
	}

	// Property accessors

	public String getCourseId() {
		return this.courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return this.courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Set getClinkcs() {
		return this.clinkcs;
	}

	public void setClinkcs(Set clinkcs) {
		this.clinkcs = clinkcs;
	}

	public Set getColinkchs() {
		return this.colinkchs;
	}

	public void setColinkchs(Set colinkchs) {
		this.colinkchs = colinkchs;
	}

}