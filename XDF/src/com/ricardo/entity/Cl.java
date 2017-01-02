package com.ricardo.entity;

import java.util.Set;

/**
 * Cl entity. @author MyEclipse Persistence Tools
 */
public class Cl extends AbstractCl implements java.io.Serializable {

	// Constructors

	/**
	 * 
	 */
	private static final long serialVersionUID = 4274581190978289658L;

	/** default constructor */
	public Cl() {
	}

	/** full constructor */
	public Cl(String className, String classDate, String classPlace,
			String classStartDate, String classEndDate, Set slinkcs,
			Set scores, Set clinkcs, Set tlinkcs) {
		super(className, classDate, classPlace, classStartDate, classEndDate,
				slinkcs, scores, clinkcs, tlinkcs);
	}

}
