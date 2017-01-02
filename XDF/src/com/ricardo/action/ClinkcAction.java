/**
 *
 * file_name   : ClinkcAction.java
 * @date       : 2016年12月18日
 * @author     : Ricardo Shaw
 * @email      : ricardoshaw@qq.com
 * @changedate : 下午7:26:35
 * 
 **/
package com.ricardo.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.opensymphony.xwork2.ActionContext;
import com.ricardo.baseaction.ClinkcBaseAction;
import com.ricardo.entity.Cl;
import com.ricardo.entity.Clinkc;
import com.ricardo.entity.Course;
import com.ricardo.entity.Tlinkc;

/**
 * @author : Ricardo Shaw
 * @date   : 2016年12月18日 下午7:26:35
 */
public class ClinkcAction extends ClinkcBaseAction {
	private int totalPage;
	private int currentPage;
	private int id;
	private String username;
	private String classId;
	private String courseId;
	private String className;
	private String courseName;
	private Clinkc clinkc;
	private List<Clinkc> clinkcs;
	private List<Cl> cles;
	private List<Course> courses;
	
	
	
	public List<Cl> getCles() {
		return cles;
	}
	public void setCles(List<Cl> cles) {
		this.cles = cles;
	}
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public Clinkc getClinkc() {
		return clinkc;
	}
	public void setClinkc(Clinkc clinkc) {
		this.clinkc = clinkc;
	}
	public List<Clinkc> getClinkcs() {
		return clinkcs;
	}
	public void setClinkcs(List<Clinkc> clinkcs) {
		this.clinkcs = clinkcs;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
		setTotalPage(clinkcService.getMaxPage(className,courseName));
		List<Clinkc> clinkclist = clinkcService.findByCnCn(className, courseName, currentPage);
		setClinkcs(clinkclist);
		return "Hquery_view";
	}
	
	public String query(){
		if(currentPage == 0 ) {setCurrentPage(1);}
		if(totalPage == 0){setTotalPage(1);}
		setTotalPage(clinkcService.getMaxPage(className,courseName));
		List<Clinkc> clinkclist = clinkcService.findByCnCn(className, courseName, currentPage);
		setClinkcs(clinkclist);
		return "query_view";
	}
	
	public String addshow(){
		ActionContext ctx = ActionContext.getContext();
		setUsername((String)ctx.getSession().get("username"));
		Set<Tlinkc> tlinkcs=teacherService.findByTi(username).getTlinkcs();
		List<Cl> cllist = new ArrayList<Cl>(); 
		for(Tlinkc tlinkc:tlinkcs){
			cllist.add(tlinkc.getCl());
		}
		setCles(cllist);
		setCourses(courseService.findAll());
		return "addshow_view";
	}
	
	public String add(){
		ActionContext ctx = ActionContext.getContext();
		int flag = clinkcService.findByCiCi(classId, courseId);
		if(flag == 0){
			Cl acl = classService.findByCi(classId);
			Course acourse = courseService.findByCourseId(courseId);
			clinkc = new Clinkc();
			clinkc.setCl(acl);
			clinkc.setCourse(acourse);
			String message = clinkcService.addClinkc(clinkc);
			String[]	 s1 = message.split("\\|");
			if("message".equalsIgnoreCase(s1[0])){
				ctx.put(s1[0],s1[1]);
				return "message";
			}else{
				ctx.put(s1[0],s1[1]);
				return "error";
			}
		}else{
			ctx.getSession().put("error","班级课程已经关联了，不需要在此关联");
			return "error";
		}

	}
	
	public String modifyshow(){
		setClinkc(clinkcService.findById(id));
		ActionContext ctx = ActionContext.getContext();
		setUsername((String)ctx.getSession().get("username"));
		System.out.println("Clinkc_addshow"+username);
		Set<Tlinkc> tlinkcs=teacherService.findByTi(username).getTlinkcs();
		List<Cl> cllist = new ArrayList<Cl>(); 
		for(Tlinkc tlinkc:tlinkcs){
			cllist.add(tlinkc.getCl());
		}
		setCles(cllist);
		setCourses(courseService.findAll());
		System.out.println("Clinkc_addshow"+cles.size()+" |"+courses.size());
		return "modifyshow_view";
	}
	
	public String modify(){
		ActionContext ctx = ActionContext.getContext();
		Cl acl = classService.findByCi(classId);
		Course acourse=courseService.findByCourseId(courseId);
		clinkc.setCl(acl);
		clinkc.setCourse(acourse);
		String message =clinkcService.modifyClinkc(clinkc);
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
		Clinkc aclinkc = clinkcService.findById(id);
		String message =clinkcService.deleteClinkc(aclinkc);
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
