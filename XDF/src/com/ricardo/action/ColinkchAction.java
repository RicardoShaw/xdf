/**
 *
 * file_name   : ColinkchAction.java
 * @date       : 2016年12月15日
 * @author     : Ricardo Shaw
 * @email      : ricardoshaw@qq.com
 * @changedate : 下午5:30:27
 * 
 **/
package com.ricardo.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.ricardo.baseaction.ColinkchBaseAction;
import com.ricardo.entity.Cchapter;
import com.ricardo.entity.Colinkch;
import com.ricardo.entity.Course;

/**
 * @author : Ricardo Shaw
 * @date   : 2016年12月15日 下午5:30:27
 */
public class ColinkchAction extends ColinkchBaseAction {
	
	private int totalPage;
	private int currentPage;
	private int id;
	
	private String courseId;
	private String chapterId;
	private String courseName;
	private String chapterName;
	
	private Colinkch colinkch;
	
	private List<Colinkch> colinkchs;
	private List<Course> courses;
	private List<Cchapter> chapteres;
	
	
	
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	public List<Cchapter> getChapteres() {
		return chapteres;
	}
	public void setChapteres(List<Cchapter> chapteres) {
		this.chapteres = chapteres;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public Colinkch getColinkch() {
		return colinkch;
	}
	public void setColinkch(Colinkch colinkch) {
		this.colinkch = colinkch;
	}
	
	public List<Colinkch> getColinkchs() {
		return colinkchs;
	}
	public void setColinkchs(List<Colinkch> colinkchs) {
		this.colinkchs = colinkchs;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getChapterId() {
		return chapterId;
	}
	public void setChapterId(String chapterId) {
		this.chapterId = chapterId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getChapterName() {
		return chapterName;
	}
	public void setChapterName(String chapterName) {
		this.chapterName = chapterName;
	}
	
	
	public String main(){
		return "main";
	}
	public String Hmain(){
		return "Hmain";
	}

	public String Hquery(){
		setTotalPage(colinkchService.getMaxPage(courseName, chapterName));
		List<Colinkch> colinkchlist=colinkchService.findByCnCn(courseName, chapterName, currentPage);
		setColinkchs(colinkchlist);
		return "Hquery_view";
	}
	
	public String query(){
		setTotalPage(colinkchService.getMaxPage(courseName, chapterName));
		List<Colinkch> colinkchlist=colinkchService.findByCnCn(courseName, chapterName, currentPage);
		setColinkchs(colinkchlist);
		return "query_view";
	}
	
	public String addshow(){
		setCourses(courseService.findAll());
		setChapteres(chapterService.findAll());
		return "addshow_view";
	}
	
	public String add(){
		ActionContext ctx = ActionContext.getContext();
		Colinkch acolinkch = new Colinkch();
		acolinkch.setCourse(courseService.findByCourseId(courseId));
		acolinkch.setCchapter(chapterService.findByChId(chapterId));
		String message = colinkchService.addColinkch(acolinkch);
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
		Colinkch acolinkch = colinkchService.findByCi(id);
		setColinkch(acolinkch);
		return "modifyshow_view";
	}
	
	public String modify(){
		ActionContext ctx = ActionContext.getContext();
		String message = colinkchService.modifyColinkch(colinkch);
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
		Colinkch acolinkch = colinkchService.findByCi(id);
		String message = colinkchService.deleteColinkch(acolinkch);
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
