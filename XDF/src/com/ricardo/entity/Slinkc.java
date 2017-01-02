package com.ricardo.entity;

/**
 * Slinkc entity. @author MyEclipse Persistence Tools
 */
public class Slinkc extends AbstractSlinkc implements java.io.Serializable {

	// Constructors

	/**
	 * 
	 */
	private static final long serialVersionUID = -2556339761044179321L;

	/** default constructor */
	public Slinkc() {
	}

	/** full constructor */
	public Slinkc(Cl cl, Student student) {
		super(cl, student);
	}

}
