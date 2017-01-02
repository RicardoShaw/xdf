/**
 *
 * file_name   : VisitorBaseAction.java
 * @date       : 2016年12月6日
 * @author     : Ricardo Shaw
 * @email      : ricardoshaw@qq.com
 * @changedate : 下午12:11:09
 * 
 **/
package com.ricardo.baseaction;

import com.opensymphony.xwork2.ActionSupport;
import com.ricardo.service.VisitorService;

/**
 * @author : Ricardo Shaw
 * @date   : 2016年12月6日 下午12:11:09
 */
public class VisitorBaseAction extends ActionSupport {
	protected VisitorService visitorService;
	
	public void setVisitorService(VisitorService visitorService){
		this.visitorService=visitorService;
	}
}
