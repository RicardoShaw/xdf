package com.ricardo.entity;

/**
 * AbstractAdmin entity provides the base persistence definition of the Admin
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractAdmin  implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3494940476461766157L;
	private String username;
	private String password;
	
	// Fields
	public AbstractAdmin(String username,String password){
		this.username = username;
		this.password = password;
	}

	public AbstractAdmin(){
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
}