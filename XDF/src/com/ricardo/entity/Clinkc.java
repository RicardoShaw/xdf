package com.ricardo.entity;

/**
 * Clinkc entity. @author MyEclipse Persistence Tools
 */
public class Clinkc extends AbstractClinkc implements java.io.Serializable {

	// Constructors

	/**
	 * 
	 */
	private static final long serialVersionUID = -6850390038131613095L;

	/** default constructor */
	public Clinkc() {
	}

	/** full constructor */
	public Clinkc(Course course, Cl cl) {
		super(course, cl);
	}

}
