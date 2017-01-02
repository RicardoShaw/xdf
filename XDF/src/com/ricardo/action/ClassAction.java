/**
 *
 * file_name   : ClassAction.java
 * @date       : 2016年12月13日
 * @author     : Ricardo Shaw
 * @email      : ricardoshaw@qq.com
 * @changedate : 下午8:01:14
 * 
 **/
package com.ricardo.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.ricardo.baseaction.ClassBaseAction;
import com.ricardo.entity.Cl;

/**
 * @author : Ricardo Shaw
 * @date   : 2016年12月13日 下午8:01:14
 */
public class ClassAction extends ClassBaseAction {
	private Cl cl;
	private String classId;
	
	private int totalPage;
	private int currentPage;
	
	private List<Cl> classes;


	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public Cl getCl() {
		return cl;
	}
	public void setCl(Cl cl) {
		this.cl = cl;
	}
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	
	
	public List<Cl> getClasses() {
		return classes;
	}
	public void setClasses(List<Cl> classes) {
		this.classes = classes;
	}
	public String main(){
		return "main";
	}
	public String Hmain(){
		return "Hmain";
	}

	public String Hquery(){
		if(currentPage == 0 ) {setCurrentPage(1);}
		if(totalPage == 0){setTotalPage(1);}
		String className = cl.getClassName();
		String startDate = cl.getClassStartDate();
		String endDate = cl.getClassEndDate();
		setTotalPage(classService.getMaxPage(className, startDate,endDate));
		List<Cl> cllist = classService.findByClNameClStartDateEndDate(className, startDate, endDate, currentPage);
		setClasses(cllist);
		return "Hquery_view";
	}
	
	public String query(){
		if(currentPage == 0 ) {setCurrentPage(1);}
		if(totalPage == 0){setTotalPage(1);}
		String className = cl.getClassName();
		String startDate = cl.getClassStartDate();
		String endDate = cl.getClassEndDate();
		setTotalPage(classService.getMaxPage(className, startDate,endDate));
		List<Cl> cllist = classService.findByClNameClStartDateEndDate(className, startDate, endDate, currentPage);
		setClasses(cllist);
		return "query_view";
	}
	
	public String addshow(){
		return "addshow_view";
	}
	
	public String add(){
		ActionContext ctx = ActionContext.getContext();
		String message = classService.addClass(cl);
		String[]	 s1 = message.split("\\|");
		if("message".equalsIgnoreCase(s1[0])){
			ctx.put(s1[0],s1[1]);
			return "message";
		}else{
			ctx.put(s1[0],s1[1]);
			return "error";
		}

	}
	
	public String modifyshow(){
		setCl( classService.findByCi(classId));
		return "modifyshow_view";
	}
	
	public String modify(){
		ActionContext ctx = ActionContext.getContext();
		String message = classService.modifyClass(cl);
		String[]	 s1 = message.split("\\|");
		if("message".equalsIgnoreCase(s1[0])){
			ctx.put(s1[0],s1[1]);
			return "message";
		}else{
			ctx.put(s1[0],s1[1]);
			return "error";
		}
	}
	
	public String delete(){
		ActionContext ctx = ActionContext.getContext();
		Cl acl = classService.findByCi(classId);
		String message = classService.deleteClass(acl);
		String[]	 s1 = message.split("\\|");
		if("message".equalsIgnoreCase(s1[0])){
			ctx.put(s1[0],s1[1]);
			return "message";
		}else{
			ctx.put(s1[0],s1[1]);
			return "error";
		}
	}

}
