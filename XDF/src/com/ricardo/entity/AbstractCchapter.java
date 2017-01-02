package com.ricardo.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractCchapter entity provides the base persistence definition of the
 * Cchapter entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractCchapter implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 8448212939728599522L;
	private String chapterId;
	private String chapterName;
	private Set colinkchs = new HashSet();

	// Constructors

	/** default constructor */
	public AbstractCchapter() {
	}

	/** full constructor */
	public AbstractCchapter(String chapterName, Set colinkchs) {
		this.chapterName = chapterName;
		this.colinkchs = colinkchs;
	}

	// Property accessors

	public String getChapterId() {
		return this.chapterId;
	}

	public void setChapterId(String chapterId) {
		this.chapterId = chapterId;
	}

	public String getChapterName() {
		return this.chapterName;
	}

	public void setChapterName(String chapterName) {
		this.chapterName = chapterName;
	}

	public Set getColinkchs() {
		return this.colinkchs;
	}

	public void setColinkchs(Set colinkchs) {
		this.colinkchs = colinkchs;
	}

}