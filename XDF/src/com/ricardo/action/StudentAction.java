/**
 *
 * file_name   : StudentAction.java
 * @date       : 2016年12月9日
 * @author     : Ricardo Shaw
 * @email      : ricardoshaw@qq.com
 * @changedate : 下午6:35:40
 * 
 **/
package com.ricardo.action;

import java.util.List;
import java.util.Set;

import com.opensymphony.xwork2.ActionContext;
import com.ricardo.baseaction.StudentBaseAction;
import com.ricardo.entity.Cl;
import com.ricardo.entity.Score;
import com.ricardo.entity.Student;

/**
 * @author : Ricardo Shaw
 * @date   : 2016年12月9日 下午6:35:40
 */
public class StudentAction extends StudentBaseAction {
	private Student student;
	
	private String studentId;
	private int totalPage;
	
	private List<Student> students;
	private int currentPage;
	
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
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
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String main(){
		if(currentPage == 0 ) {setCurrentPage(1);}
		setTotalPage(studentService.getMaxPage("", ""));
		setStudents(studentService.findBySnSt("", "", currentPage));
		return "main";
	}
	public String Hmain(){
		return "Hmain";
	}
	
	public String studentshow(){
		System.out.println("student_studentshow"+studentId);
		Student astudent = studentService.findBySi(studentId);
		System.out.println("Student_studentshow"+astudent.getStudentId());
		setStudent(astudent);
		return "studentshow_view";
	}
	

	public String Hquery(){
		if(currentPage == 0 ) {setCurrentPage(1);}
		if(totalPage == 0){setTotalPage(1);}
		String studentName = student.getStudentName();
		String studentPhone = student.getStudentTelephone();
		setTotalPage(studentService.getMaxPage(studentName, studentPhone));
		List<Student> studentlist = studentService.findBySnSt(studentName, studentPhone, currentPage);
		setStudents(studentlist);
		return "Hquery_view";
	}
	
	public String query(){
		if(currentPage == 0 ) {setCurrentPage(1);}
		if(totalPage == 0){setTotalPage(1);}
		String studentName = student.getStudentName();
		String studentPhone = student.getStudentTelephone();
		setTotalPage(studentService.getMaxPage(studentName, studentPhone));
		List<Student> studentlist = studentService.findBySnSt(studentName, studentPhone, currentPage);
		setStudents(studentlist);
		return "query_view";
	}
	
	public String addshow(){
		return "addshow_view";
	}
	
	public String add(){
		ActionContext ctx = ActionContext.getContext();
		String message = studentService.addStudent(student);
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
		Student astudent = studentService.findBySi(studentId);
		setStudent(astudent);
		return "modifyshow_view";
	}
	
	public String modify(){
		ActionContext ctx = ActionContext.getContext();
		String message = studentService.modifyStudent(student);
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
		Student astudent = studentService.findBySi(studentId);
		String message = studentService.deleteStudent(astudent);
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
