package com.ricardo.entity;

/**
 * Colinkch entity. @author MyEclipse Persistence Tools
 */
public class Colinkch extends AbstractColinkch implements java.io.Serializable {

	// Constructors

	/**
	 * 
	 */
	private static final long serialVersionUID = 4753709976084232727L;

	/** default constructor */
	public Colinkch() {
	}

	/** full constructor */
	public Colinkch(Course course, Cchapter cchapter) {
		super(course, cchapter);
	}

}
