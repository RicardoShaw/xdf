package com.ricardo.entity;

/**
 * Tlinkc entity. @author MyEclipse Persistence Tools
 */
public class Tlinkc extends AbstractTlinkc implements java.io.Serializable {

	// Constructors

	/**
	 * 
	 */
	private static final long serialVersionUID = -6932401174589606030L;

	/** default constructor */
	public Tlinkc() {
	}

	/** full constructor */
	public Tlinkc(Cl cl, Teacher teacher) {
		super(cl, teacher);
	}

}
