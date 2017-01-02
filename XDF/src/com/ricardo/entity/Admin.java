package com.ricardo.entity;

/**
 * Admin entity. @author MyEclipse Persistence Tools
 */
public class Admin extends AbstractAdmin implements java.io.Serializable {

	// Constructors

	/**
	 * 
	 */
	private static final long serialVersionUID = 8996413516738173516L;

	/** default constructor */
	public Admin() {
	}

	/** full constructor */
	public Admin(String username,String password) {
		super(username,password);
	}

}
