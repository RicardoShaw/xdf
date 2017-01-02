package com.ricardo.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractCl entity provides the base persistence definition of the Cl entity. @author
 * MyEclipse Persistence Tools
 */

public abstract class AbstractCl implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 566673080464000807L;
	private String classId;
	private String className;
	private String classDate;
	private String classPlace;
	private String classStartDate;
	private String classEndDate;
	private Set<Slinkc> slinkcs = new HashSet();
	private Set<Score> scores = new HashSet();
	private Set<Clinkc> clinkcs = new HashSet();
	private Set<Tlinkc> tlinkcs = new HashSet();

	// Constructors

	/** default constructor */
	public AbstractCl() {
	}
	

	/** full constructor */
	public AbstractCl(String className, String classDate, String classPlace,
			String classStartDate, String classEndDate, Set slinkcs,
			Set scores, Set clinkcs, Set tlinkcs) {
		this.className = className;
		this.classDate = classDate;
		this.classPlace = classPlace;
		this.classStartDate = classStartDate;
		this.classEndDate = classEndDate;
		this.slinkcs = slinkcs;
		this.scores = scores;
		this.clinkcs = clinkcs;
		this.tlinkcs = tlinkcs;
	}

	// Property accessors

	public String getClassId() {
		return this.classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public String getClassName() {
		return this.className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getClassDate() {
		return this.classDate;
	}

	public void setClassDate(String classDate) {
		this.classDate = classDate;
	}

	public String getClassPlace() {
		return this.classPlace;
	}

	public void setClassPlace(String classPlace) {
		this.classPlace = classPlace;
	}

	public String getClassStartDate() {
		return this.classStartDate;
	}

	public void setClassStartDate(String classStartDate) {
		this.classStartDate = classStartDate;
	}

	public String getClassEndDate() {
		return this.classEndDate;
	}

	public void setClassEndDate(String classEndDate) {
		this.classEndDate = classEndDate;
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

	public Set getClinkcs() {
		return this.clinkcs;
	}

	public void setClinkcs(Set clinkcs) {
		this.clinkcs = clinkcs;
	}

	public Set getTlinkcs() {
		return this.tlinkcs;
	}

	public void setTlinkcs(Set tlinkcs) {
		this.tlinkcs = tlinkcs;
	}

}