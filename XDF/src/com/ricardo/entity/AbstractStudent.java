package com.ricardo.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractStudent entity provides the base persistence definition of the
 * Student entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractStudent implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 6961325660575651455L;
	private String studentId;
	private String studentName;
	private String studentSex;
	private String studentBirthday;
	private String studentPhoto;
	private String studentTelephone;
	private String studentEmail;
	private String studentQq;
	private String studentAddress;
	private Set slinkcs = new HashSet();
	private Set scores = new HashSet();

	// Constructors

	/** default constructor */
	public AbstractStudent() {
	}

	/** minimal constructor */
	public AbstractStudent(String studentName, String studentTelephone) {
		this.studentName = studentName;
		this.studentTelephone = studentTelephone;
	}

	/** full constructor */
	public AbstractStudent(String studentName, String studentSex,
			String studentBirthday, String studentPhoto,
			String studentTelephone, String studentEmail, String studentQq,
			String studentAddress, Set slinkcs, Set scores) {
		this.studentName = studentName;
		this.studentSex = studentSex;
		this.studentBirthday = studentBirthday;
		this.studentPhoto = studentPhoto;
		this.studentTelephone = studentTelephone;
		this.studentEmail = studentEmail;
		this.studentQq = studentQq;
		this.studentAddress = studentAddress;
		this.slinkcs = slinkcs;
		this.scores = scores;
	}

	// Property accessors

	public String getStudentId() {
		return this.studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return this.studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentSex() {
		return this.studentSex;
	}

	public void setStudentSex(String studentSex) {
		this.studentSex = studentSex;
	}

	public String getStudentBirthday() {
		return this.studentBirthday;
	}

	public void setStudentBirthday(String studentBirthday) {
		this.studentBirthday = studentBirthday;
	}

	public String getStudentPhoto() {
		return this.studentPhoto;
	}

	public void setStudentPhoto(String studentPhoto) {
		this.studentPhoto = studentPhoto;
	}

	public String getStudentTelephone() {
		return this.studentTelephone;
	}

	public void setStudentTelephone(String studentTelephone) {
		this.studentTelephone = studentTelephone;
	}

	public String getStudentEmail() {
		return this.studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public String getStudentQq() {
		return this.studentQq;
	}

	public void setStudentQq(String studentQq) {
		this.studentQq = studentQq;
	}

	public String getStudentAddress() {
		return this.studentAddress;
	}

	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
	}

	public Set getSlinkcs() {
		return this.slinkcs;
	}

	public void setSlinkcs(Set slinkcs) {
		this.slinkcs = slinkcs;
	}

	public Set getScores() {
		return this.scores;
	}

	public void setScores(Set scores) {
		this.scores = scores;
	}

}