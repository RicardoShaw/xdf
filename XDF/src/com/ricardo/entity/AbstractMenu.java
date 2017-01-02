package com.ricardo.entity;

/**
 * AbstractMenu entity provides the base persistence definition of the Menu
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractMenu implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 6751049746534887447L;
	private Integer menuId;
	private String menuName;
	private String menuUrl;
	private Integer parentId;
	private String menuDescription;
	private String state;
	private String iconCls;

	// Constructors

	/** default constructor */
	public AbstractMenu() {
	}

	/** full constructor */
	public AbstractMenu(String menuName, String menuUrl, Integer parentId,
			String menuDescription, String state, String iconCls) {
		this.menuName = menuName;
		this.menuUrl = menuUrl;
		this.parentId = parentId;
		this.menuDescription = menuDescription;
		this.state = state;
		this.iconCls = iconCls;
	}

	// Property accessors

	public Integer getMenuId() {
		return this.menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return this.menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getMenuUrl() {
		return this.menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getMenuDescription() {
		return this.menuDescription;
	}

	public void setMenuDescription(String menuDescription) {
		this.menuDescription = menuDescription;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getIconCls() {
		return this.iconCls;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

}