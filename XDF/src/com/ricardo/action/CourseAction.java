/**
 *
 * file_name   : CourseAction.java
 * @date       : 2016年12月15日
 * @author     : Ricardo Shaw
 * @email      : ricardoshaw@qq.com
 * @changedate : 下午6:44:09
 * 
 **/
package com.ricardo.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.ricardo.baseaction.CourseBaseAction;
import com.ricardo.entity.Course;
import com.ricardo.util.CreateCourseId;

/**
 * @author : Ricardo Shaw
 * @date   : 2016年12月15日 下午6:44:09
 */
public class CourseAction extends CourseBaseAction {
	
	private Course course;
	private String filepath;
	private int totalPage;
	private int currentPage;
	private String courseId;
	private int id;
	
	
	private List<Course> courses;
	
	
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
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
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
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
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
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
		String courseId = course.getCourseId();
		String courseName = course.getCourseName();
		setTotalPage(courseService.getMaxPage(courseId, courseName));
		List<Course> courselist=courseService.findByCourseIdCourseName(courseId, courseName, currentPage);
		setCourses(courselist);
		return "Hquery_view";
	}
	
	public String query(){
		if(currentPage == 0 ) {setCurrentPage(1);}
		if(totalPage == 0){setTotalPage(1);}
		String courseId = course.getCourseId();
		String courseName = course.getCourseName();
		setTotalPage(courseService.getMaxPage(courseId, courseName));
		List<Course> courselist=courseService.findByCourseIdCourseName(courseId, courseName, currentPage);
		setCourses(courselist);
		return "query_view";
	}
	
	public String addshow(){
		return "addshow_view";
	}
	
	public String add(){
		ActionContext ctx = ActionContext.getContext();
		String message = courseService.addCourse(course);
		String[]	 s1 = message.split("\\|");
		if("message".equalsIgnoreCase(s1[0])){
			ctx.put(s1[0],s1[1]);
			return "message";
		}else{
			ctx.put(s1[0],s1[1]);
			return "error";
		}
	}
	
	public String tadd(){
		ActionContext ctx = ActionContext.getContext();
		
		course.setCourseId(CreateCourseId.getCourseId(id));
		String message = courseService.addCourse(course);
		String[]	 s1 = message.split("\\|");
		if("error".equalsIgnoreCase(s1[0])){
			ctx.put(s1[0],s1[1]);
			return "error";
		}
		
		ctx.getSession().put("message","批量添加成功");
		return "message";
			
	}
	
	
	public String modifyshow(){
		ActionContext ctx = ActionContext.getContext();
		setCourse(courseService.findByCourseId(courseId));
		return "modifyshow_view";
	}
	
	public String modify(){
		ActionContext ctx = ActionContext.getContext();
		String message = courseService.modifyCourse(course);
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
		Course acourse = courseService.findByCourseId(courseId);
		String message = courseService.deleteCourse(acourse);
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
