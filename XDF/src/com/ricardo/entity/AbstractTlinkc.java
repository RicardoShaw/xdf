package com.ricardo.entity;

/**
 * AbstractTlinkc entity provides the base persistence definition of the Tlinkc
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTlinkc implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -1759935276068711865L;
	private Integer id;
	private Cl cl;
	private Teacher teacher;

	// Constructors

	/** default constructor */
	public AbstractTlinkc() {
	}

	/** full constructor */
	public AbstractTlinkc(Cl cl, Teacher teacher) {
		this.cl = cl;
		this.teacher = teacher;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Cl getCl() {
		return this.cl;
	}

	public void setCl(Cl cl) {
		this.cl = cl;
	}

	public Teacher getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

}