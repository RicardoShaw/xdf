package com.ricardo.entity;

/**
 * AbstractColinkch entity provides the base persistence definition of the
 * Colinkch entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractColinkch implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -8695265896246974397L;
	private Integer id;
	private Course course;
	private Cchapter cchapter;

	// Constructors

	/** default constructor */
	public AbstractColinkch() {
	}

	/** full constructor */
	public AbstractColinkch(Course course, Cchapter cchapter) {
		this.course = course;
		this.cchapter = cchapter;
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

	public Cchapter getCchapter() {
		return this.cchapter;
	}

	public void setCchapter(Cchapter cchapter) {
		this.cchapter = cchapter;
	}

}