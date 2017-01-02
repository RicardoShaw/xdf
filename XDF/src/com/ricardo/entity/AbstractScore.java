package com.ricardo.entity;

/**
 * AbstractScore entity provides the base persistence definition of the Score
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractScore implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 6439010351076190125L;
	private Integer id;
	private Cl cl;
	private Student student;
	private String courseName;
	private String chapterName;
	private String  hwscore;
	private Float dtscore;

	// Constructors

	/** default constructor */
	public AbstractScore() {
		this.cl = new Cl();
		this.student = new Student();
	}

	/** full constructor */
	public AbstractScore(Cl cl, Student student, String courseName,
			String chapterName, String hwscore, Float dtscore) {
		this.cl = cl;
		this.student = student;
		this.courseName = courseName;
		this.chapterName = chapterName;
		this.hwscore = hwscore;
		this.dtscore = dtscore;
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

	public String getCourseName() {
		return this.courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getChapterName() {
		return this.chapterName;
	}

	public void setChapterName(String chapterName) {
		this.chapterName = chapterName;
	}

	public String getHwscore() {
		return this.hwscore;
	}

	public void setHwscore(String hwscore) {
		this.hwscore = hwscore;
	}

	public Float getDtscore() {
		return this.dtscore;
	}

	public void setDtscore(Float dtscore) {
		this.dtscore = dtscore;
	}

}