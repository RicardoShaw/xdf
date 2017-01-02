package com.ricardo.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractTeacher entity provides the base persistence definition of the
 * Teacher entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractTeacher implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = -3911633372268628429L;
	private String username;
	private String password;
	
	private String teacherName;
	private String teacherSex;
	private String teacherBirthday;
	private String teacherArriveDate;
	private String teacherCardNumber;
	private String teacherPhone;
	private String teacherPhoto;
	private String teacherAddress;
	
	private Set tlinkcs = new HashSet();

	// Constructors

	/** default constructor */
	public AbstractTeacher() {
	}
	
	public AbstractTeacher(String username,String password){
		this.username = username;
		this.password = password;
	}
	
	public AbstractTeacher(String username,String teacherName,String password){
		this.setUsername(username);
		this.teacherName = teacherName;
		this.setPassword(password);
	}
	
	

//	/** minimal constructor */
//	public AbstractTeacher(String password, String teacherName) {
//		this.password = password;
//		this.teacherName = teacherName;
//	}

	/** full constructor */
	public AbstractTeacher(String password, String teacherName,
			String teacherSex, String teacherBirthday,
			String teacherArriveDate, String teacherCardNumber,
			String teacherPhone, String teacherPhoto, String teacherAddress,
			Set tlinkcs) {
		this.setPassword(password);
		this.teacherName = teacherName;
		this.teacherSex = teacherSex;
		this.teacherBirthday = teacherBirthday;
		this.teacherArriveDate = teacherArriveDate;
		this.teacherCardNumber = teacherCardNumber;
		this.teacherPhone = teacherPhone;
		this.teacherPhoto = teacherPhoto;
		this.teacherAddress = teacherAddress;
		this.tlinkcs = tlinkcs;
	}

	// Property accessors



	public String getTeacherName() {
		return this.teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getTeacherSex() {
		return this.teacherSex;
	}

	public void setTeacherSex(String teacherSex) {
		this.teacherSex = teacherSex;
	}

	public String getTeacherBirthday() {
		return this.teacherBirthday;
	}

	public void setTeacherBirthday(String teacherBirthday) {
		this.teacherBirthday = teacherBirthday;
	}

	public String getTeacherArriveDate() {
		return this.teacherArriveDate;
	}

	public void setTeacherArriveDate(String teacherArriveDate) {
		this.teacherArriveDate = teacherArriveDate;
	}

	public String getTeacherCardNumber() {
		return this.teacherCardNumber;
	}

	public void setTeacherCardNumber(String teacherCardNumber) {
		this.teacherCardNumber = teacherCardNumber;
	}

	public String getTeacherPhone() {
		return this.teacherPhone;
	}

	public void setTeacherPhone(String teacherPhone) {
		this.teacherPhone = teacherPhone;
	}

	public String getTeacherPhoto() {
		return this.teacherPhoto;
	}

	public void setTeacherPhoto(String teacherPhoto) {
		this.teacherPhoto = teacherPhoto;
	}

	public String getTeacherAddress() {
		return this.teacherAddress;
	}

	public void setTeacherAddress(String teacherAddress) {
		this.teacherAddress = teacherAddress;
	}

	public Set getTlinkcs() {
		return this.tlinkcs;
	}

	public void setTlinkcs(Set tlinkcs) {
		this.tlinkcs = tlinkcs;
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