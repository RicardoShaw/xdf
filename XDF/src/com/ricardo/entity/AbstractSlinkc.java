package com.ricardo.entity;

/**
 * AbstractSlinkc entity provides the base persistence definition of the Slinkc
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractSlinkc implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -6143494742457866923L;
	private Integer id;
	private Cl cl;
	private Student student;

	// Constructors

	/** default constructor */
	public AbstractSlinkc() {
	}

	/** full constructor */
	public AbstractSlinkc(Cl cl, Student student) {
		this.cl = cl;
		this.student = student;
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

	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}