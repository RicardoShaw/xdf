package com.ricardo.entity;

import java.util.Set;

/**
 * Cchapter entity. @author MyEclipse Persistence Tools
 */
public class Cchapter extends AbstractCchapter implements java.io.Serializable {

	// Constructors

	/**
	 * 
	 */
	private static final long serialVersionUID = -8080845621027830960L;

	/** default constructor */
	public Cchapter() {
	}

	/** full constructor */
	public Cchapter(String chapterName, Set colinkchs) {
		super(chapterName, colinkchs);
	}

}
