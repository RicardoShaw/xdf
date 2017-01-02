/**
 *
 * file_name   : TlinkcAction.java
 * @date       : 2016年12月17日
 * @author     : Ricardo Shaw
 * @email      : ricardoshaw@qq.com
 * @changedate : 下午7:38:10
 * 
 **/
package com.ricardo.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.ricardo.baseaction.TlinkcBaseAction;
import com.ricardo.entity.Cl;
import com.ricardo.entity.Teacher;
import com.ricardo.entity.Tlinkc;

/**
 * @author : Ricardo Shaw
 * @date   : 2016年12月17日 下午7:38:10
 */
public class TlinkcAction extends TlinkcBaseAction {
	private int totalPage;
	private int currentPage;
	
	private int id;
	private String username;
	private String teacherName;
	private String classId;
	private String className;
	private String classStartDate;
	private String classEndDate;
	private String tip;
	
	private Tlinkc tlinkc;
	private Cl cl;
	private Teacher teacher;
	
	private List<Tlinkc> tlinkcs;
	
	private List<Cl> cles;
	
	
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	public List<Cl> getCles() {
		return cles;
	}
	public void setCles(List<Cl> cles) {
		this.cles = cles;
	}
	public List<Tlinkc> getTlinkcs() {
		return tlinkcs;
	}
	public void setTlinkcs(List<Tlinkc> tlinkcs) {
		this.tlinkcs = tlinkcs;
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
	public Tlinkc getTlinkc() {
		return tlinkc;
	}
	public void setTlinkc(Tlinkc tlinkc) {
		this.tlinkc = tlinkc;
	}
	public Cl getCl() {
		return cl;
	}
	public void setCl(Cl cl) {
		this.cl = cl;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public String getClassStartDate() {
		return classStartDate;
	}
	public void setClassStartDate(String classStartDate) {
		this.classStartDate = classStartDate;
	}
	public String getClassEndDate() {
		return classEndDate;
	}
	public void setClassEndDate(String classEndDate) {
		this.classEndDate = classEndDate;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	
	
	public String main(){
		ActionContext ctx = ActionContext.getContext();
		username=(String) ctx.getSession().get("username");
		return "main";
	}
	
	public String Hmain(){
		return "Hmain";
	}

	public String Hquery(){	
		if(currentPage == 0 ) {setCurrentPage(1);}
		if(totalPage == 0){setTotalPage(1);}
		setTotalPage(tlinkcService.getMaxPage(teacherName, "", className, classStartDate, classEndDate));
		List<Tlinkc> tlinkclist = tlinkcService.findByCiCnTn(teacherName, "", className, classStartDate, classEndDate, currentPage);
		setTlinkcs(tlinkclist);
		return "Hquery_view";
	}
	
	public String query(){
		System.out.println("Tlinkc_query"+tlinkcService.getMaxPage(username, className,classStartDate, classEndDate));
		System.out.println(username+"|"+className+"|"+classStartDate+"|"+classEndDate);
		setTotalPage(tlinkcService.getMaxPage(username, className,classStartDate, classEndDate));
		List<Tlinkc> tlinkclist = tlinkcService.findByTiCn(username, className, classStartDate, classEndDate,currentPage);
		setTlinkcs(tlinkclist);
		System.out.println("Tlinkc_query"+tlinkclist.size());
		
		return "query_view";
	}
	
	public String addshow(){
		ActionContext ctx = ActionContext.getContext();
		setUsername((String)ctx.getSession().get("username"));
		setCles(classService.findAll());
		return "addshow_view";
	}
	
	public String add(){
		ActionContext ctx = ActionContext.getContext();
		int flag = tlinkcService.findByTiCi(username, classId);
		if(flag == 0){
			Cl acl = classService.findByCi(classId);
			Teacher teacher = teacherService.findByTi(username);
			Tlinkc atlinkc = new Tlinkc();
			atlinkc.setCl(acl);
			atlinkc.setTeacher(teacher);
			String message = tlinkcService.addTlinkc(atlinkc);
			String[]	 s1 = message.split("\\|");
			if("message".equalsIgnoreCase(s1[0])){
				ctx.put(s1[0],s1[1]);
				setTip(s1[1]);
				return "message";
			}else{
				ctx.put(s1[0],s1[1]);
				setTip(s1[1]);
				return "error";
			}
		}else{
			ctx.put("error", "教师班级已经关联了，不需要在此关联");
			setTip("教师班级已经关联了，不需要在此关联");
			return "error";
		}

	}
	
	public String modifyshow(){
		ActionContext ctx = ActionContext.getContext();
		setUsername((String)ctx.getSession().get("username"));
		setCles(classService.findAll());
		return "modifyshow_view";
	}
	
	
	public String tlinkcshow(){
		setTlinkc(tlinkcService.findById(id));
		return "tlinkcshow_view";
	}
	
	
	public String modify(){
		ActionContext ctx = ActionContext.getContext();	
		setTlinkc(tlinkcService.findById(id));
		Cl acl = classService.findByCi(classId);
		Teacher ateacher = teacherService.findByTi(username);
		tlinkc.setCl(acl);
		tlinkc.setTeacher(ateacher);
		String message = tlinkcService.modifyTlinkc(tlinkc);
		String[]	 s1 = message.split("\\|");
		if("message".equalsIgnoreCase(s1[0])){
			ctx.put(s1[0],s1[1]);
			setTip(s1[1]);
			return "message";
		}else{
			ctx.put(s1[0],s1[1]);
			setTip(s1[1]);
			return "error";
		}
	}
	
	public String delete(){
		ActionContext ctx = ActionContext.getContext();
		Tlinkc atlinkc = tlinkcService.findById(id);
		String message =tlinkcService.deleteTlinkc(atlinkc);
		String[]	 s1 = message.split("\\|");
		if("message".equalsIgnoreCase(s1[0])){
			ctx.put(s1[0],s1[1]);
			setTip(s1[1]);
			return "message";
		}else{
			ctx.put(s1[0],s1[1]);
			setTip(s1[1]);
			return "error";
		}
	}

}
