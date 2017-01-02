package com.ricardo.entity;

/**
 * Score entity. @author MyEclipse Persistence Tools
 */
public class Score extends AbstractScore implements java.io.Serializable {

	// Constructors

	/**
	 * 
	 */
	private static final long serialVersionUID = 3974381032527989543L;

	/** default constructor */
	public Score() {
	}

	/** full constructor */
	public Score(Cl cl, Student student, String courseId, String chapterId,
			String hwscore, Float dtscore) {
		super(cl, student, courseId, chapterId, hwscore, dtscore);
	}

}
