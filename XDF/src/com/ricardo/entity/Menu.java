package com.ricardo.entity;

/**
 * Menu entity. @author MyEclipse Persistence Tools
 */
public class Menu extends AbstractMenu implements java.io.Serializable {

	// Constructors

	/**
	 * 
	 */
	private static final long serialVersionUID = -7781707891363492667L;

	/** default constructor */
	public Menu() {
	}

	/** full constructor */
	public Menu(String menuName, String menuUrl, Integer parentId,
			String menuDescription, String state, String iconCls) {
		super(menuName, menuUrl, parentId, menuDescription, state, iconCls);
	}

}
