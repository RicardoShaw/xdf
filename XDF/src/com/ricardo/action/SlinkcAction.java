/**
 *
 * file_name   : SlinkcAction.java
 * @date       : 2016年12月18日
 * @author     : Ricardo Shaw
 * @email      : ricardoshaw@qq.com
 * @changedate : 下午4:30:47
 * 
 **/
package com.ricardo.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.opensymphony.xwork2.ActionContext;
import com.ricardo.baseaction.SlinkcBaseAction;
import com.ricardo.entity.Cl;
import com.ricardo.entity.Slinkc;
import com.ricardo.entity.Student;
import com.ricardo.entity.Teacher;
import com.ricardo.entity.Tlinkc;

/**
 * @author : Ricardo Shaw
 * @date   : 2016年12月18日 下午4:30:47
 */
public class SlinkcAction extends SlinkcBaseAction {
	
	private int currentPage;
	private int totalPage;
	private int id;
	
	private String username;
	private String classId;
	private String studentId;
	
	private String studentName;
	
	private Slinkc slinkc;
	
	private List<Slinkc> slinkcs;
	
	private List<Student> students;
	
	private List<Cl> cles;
	
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public Slinkc getSlinkc() {
		return slinkc;
	}
	public void setSlinkc(Slinkc slinkc) {
		this.slinkc = slinkc;
	}
	public List<Slinkc> getSlinkcs() {
		return slinkcs;
	}
	public void setSlinkcs(List<Slinkc> slinkcs) {
		this.slinkcs = slinkcs;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public List<Cl> getCles() {
		return cles;
	}
	public void setCles(List<Cl> cles) {
		this.cles = cles;
	}
	public String main(){
		return "main";
	}
	public String Hmain(){
		ActionContext ctx = ActionContext.getContext();
		setCles(classService.findAll());
		return "Hmain";
	}

	public String Hquery(){	
		setTotalPage(slinkcService.getMaxPage(studentName, classId));
		List<Slinkc> slinkclist = slinkcService.findBySnCi(studentName, classId, currentPage);
		setSlinkcs(slinkclist);
		return "Hquery_view";
	}
	
	public String query(){
		setTotalPage(slinkcService.getMaxPage(studentName, classId));
		List<Slinkc> slinkclist = slinkcService.findBySnCi(studentName, classId, currentPage);
		setSlinkcs(slinkclist);
		return "query_view";
	}
	
	public String addshow(){
		ActionContext ctx = ActionContext.getContext();
		Teacher teacher= teacherService.findByTi(username);
		Set<Tlinkc> stlinkc = teacher.getTlinkcs();
		ctx.put("stlinkc", stlinkc);
		return "addshow_view";
	}
	
	public String add(){
		ActionContext ctx = ActionContext.getContext();
		int flag = slinkcService.findBySiCi(studentId, classId);
		if(flag == 0){
			Cl acl = classService.findByCi(classId);
			Student astudent = studentService.findBySi(studentId);
			Slinkc aslinkc = new Slinkc();
			aslinkc.setCl(acl);
			aslinkc.setStudent(astudent);
			String message = slinkcService.addSlinkc(aslinkc);
			String[]	 s1 = message.split("\\|");
			if("message".equalsIgnoreCase(s1[0])){
				ctx.getSession().put(s1[0],s1[1]);
				return "message";
			}else{
				ctx.getSession().put(s1[0],s1[1]);
				return "error";
			}

		}else{
			ctx.getSession().put("error","学生班级已经关联，不用在此关联");
			return "error";
		}

	}
	
	public String modifyshow(){
		setSlinkc(slinkcService.findById(id));
		return "modifyshow_view";
	}
	
	public String modify(){
		ActionContext ctx = ActionContext.getContext();
		Cl acl = classService.findByCi(classId);
		slinkc.setCl(acl);
		String message = slinkcService.modifySlinkc(slinkc);
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
		Slinkc aslinkc = slinkcService.findById(id);
		String message =slinkcService.deleteSlinkc(aslinkc);
		String[]	 s1 = message.split("\\|");
		if("message".equalsIgnoreCase(s1[0])){
			ctx.getSession().put(s1[0],s1[1]);
			return "message";
		}else{
			ctx.getSession().put(s1[0],s1[1]);
			return "error";
		}
	}
}
