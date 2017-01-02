/**
 *
 * file_name   : TeacherAction.java
 * @date       : 2016年12月9日
 * @author     : Ricardo Shaw
 * @email      : ricardoshaw@qq.com
 * @changedate : 下午6:12:12
 * 
 **/
package com.ricardo.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.ricardo.baseaction.TeacherBaseAction;
import com.ricardo.entity.Teacher;

/**
 * @author : Ricardo Shaw
 * @date   : 2016年12月9日 下午6:12:12
 */
public class TeacherAction extends TeacherBaseAction {
	
	private Teacher teacher;
	
	private String username;
	
	private int totalPage;
	private int currentPage;
	
	private List<Teacher> teachers;
	

	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public List<Teacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public String main(){
		return "main";
	}
	public String Hmain(){
		setCurrentPage(0);
		return "Hmain";
	}
	

	public String Hquery(){
		if(currentPage == 0 ) {setCurrentPage(1);}
		if(totalPage == 0){setTotalPage(1);}
		String teacherName = teacher.getTeacherName();
		String teacherPhone = teacher.getTeacherPhone();
		setTotalPage(teacherService.getPageSize(teacherName, teacherPhone));
		List<Teacher> teacherlist = teacherService.findByTnTt(teacherName, teacherPhone, currentPage);
		setTeachers(teacherlist);
		return "Hquery_view";
	}
	
	public String query(){
		if(currentPage == 0 ) {setCurrentPage(1);}
		if(totalPage == 0){setTotalPage(1);}
		Teacher ateacher = teacherService.findByTi(username);
		setTeacher(ateacher);
		return "query_view";
	}
	
	public String addshow(){
		return "addshow_view";
	}
	
	public String add(){
		ActionContext ctx = ActionContext.getContext();
		String message = teacherService.addTeacher(teacher);
		String[]	 s1 = message.split("\\|");
		if("message".equalsIgnoreCase(s1[0])){
			ctx.getSession().put(s1[0],s1[1]);
			return "message";
		}else{
			ctx.getSession().put(s1[0],s1[1]);
			return "error";
		}

	}
	
	public String modifyshow(){
		ActionContext ctx = ActionContext.getContext();
		System.out.println("Teacher_modify"+username);
		Teacher ateacher = teacherService.findByTi(username);
		setTeacher(ateacher);
		return "modifyshow_view";
	}
	
	public String teachershow(){
		return "teachershow_view";
	}
	
	public String modify(){
		ActionContext ctx = ActionContext.getContext();
		String message = teacherService.modifyTeacher(teacher);
		String[]	 s1 = message.split("\\|");
		if("message".equalsIgnoreCase(s1[0])){
			ctx.getSession().put(s1[0],s1[1]);
			return "message";
		}else{
			ctx.getSession().put(s1[0],s1[1]);
			return "error";
		}
	}
	
	public String delete(){
		ActionContext ctx = ActionContext.getContext();
		Teacher ateacher = teacherService.findByTi(username);
		String message = teacherService.deleteTeacher(ateacher);
		String[]	 s1 = message.split("\\|");
		if("message".equalsIgnoreCase(s1[0])){
			ctx.getSession().put(s1[0],s1[1]);
			return "message";
		}else{
			ctx.getSession().put(s1[0],s1[1]);
			return "error";
		}
	}
	
	public String CheckLogin(){
		ActionContext ctx = ActionContext.getContext();
		setUsername(teacher.getUsername());
		int result = teacherService.findByTuTp(teacher.getUsername(), teacher.getPassword());
		if(result == 0){
//			setTip("请输入教师ID和教师密码");
			return "login";
		}else{
//			setTip(username+"用户，您已经登入成功");
//			Cookie cookie = new Cookie("username",username);
//			cookie.setMaxAge(10800);
//			ctx.getSession().put("cookie", cookie);
			ctx.getSession().put("username", username);
			
			return "manager";
		}
	}
	
	public String login(){
		return "login";
	}
}
