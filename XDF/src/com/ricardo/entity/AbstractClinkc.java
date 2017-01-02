package com.ricardo.entity;

/**
 * AbstractClinkc entity provides the base persistence definition of the Clinkc
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractClinkc implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -3272757536973584008L;
	private Integer id;
	private Course course;
	private Cl cl;

	// Constructors

	/** default constructor */
	public AbstractClinkc() {
	}

	/** full constructor */
	public AbstractClinkc(Course course, Cl cl) {
		this.course = course;
		this.cl = cl;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Cl getCl() {
		return this.cl;
	}

	public void setCl(Cl cl) {
		this.cl = cl;
	}

}