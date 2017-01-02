/**
 *
 * file_name   : VisitorAction.java
 * @date       : 2016��12��6��
 * @author     : Ricardo Shaw
 * @email      : ricardoshaw@qq.com
 * @changedate : ����12:55:49
 * 
 **/
package com.ricardo.action;

import java.util.List;
import java.util.Set;

import com.opensymphony.xwork2.ActionContext;
import com.ricardo.baseaction.VisitorBaseAction;
import com.ricardo.entity.Cl;
import com.ricardo.entity.Clinkc;
import com.ricardo.entity.Course;
import com.ricardo.entity.Score;
import com.ricardo.entity.Slinkc;
import com.ricardo.entity.Student;
import com.ricardo.entity.Teacher;
import com.ricardo.entity.Tlinkc;

/**
 * @author : Ricardo Shaw
 * @date   : 2016��12��6�� ����12:55:49
 */
public class VisitorAction extends VisitorBaseAction {
	
	//输入
	private Teacher teacher;
	private Student student;
	private Score score;
	private Cl cl;
	private Tlinkc tlinkc;
	
	//输出
	private List<Teacher> teachers;
	private List<Student> students;
	private List<Tlinkc> tlinkcs;
	private List<Score> scores;
	private List<Cl> cles;
	private List<Course> courses;
	private Set<Tlinkc> stlinkcs;
	private Set<Slinkc> sslinkcs;
	private Set<Clinkc> sclinkcs;
	private Set<Score> sscores;
	
	
	private int offset;
	private int pageSize;
	
	private String username;
	private String classId;
	private String studentId;
	private String courseName;
	private String chapterName;
	private String className;
	
	
	
	
	/**
	 * @return the className
	 */
	public String getClassName() {
		return className;
	}
	/**
	 * @param className the className to set
	 */
	public void setClassName(String className) {
		this.className = className;
	}
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	public Set<Score> getSscores() {
		return sscores;
	}
	public void setSscores(Set<Score> sscores) {
		this.sscores = sscores;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public Set<Clinkc> getSclinkcs() {
		return sclinkcs;
	}
	public void setSclinkcs(Set<Clinkc> sclinkcs) {
		this.sclinkcs = sclinkcs;
	}
	public Set<Slinkc> getSslinkcs() {
		return sslinkcs;
	}
	public void setSslinkcs(Set<Slinkc> sslinkcs) {
		this.sslinkcs = sslinkcs;
	}
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Set<Tlinkc> getStlinkcs() {
		return stlinkcs;
	}
	public void setStlinkcs(Set<Tlinkc> stlinkcs) {
		this.stlinkcs = stlinkcs;
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
	public int getOffset() {
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Score getScore() {
		return score;
	}
	public void setScore(Score score) {
		this.score = score;
	}
	public Cl getCl() {
		return cl;
	}
	public void setCl(Cl cl) {
		this.cl = cl;
	}
	public Tlinkc getTlinkc() {
		return tlinkc;
	}
	public void setTlinkc(Tlinkc tlinkc) {
		this.tlinkc = tlinkc;
	}
	public List<Teacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public List<Tlinkc> getTlinkcs() {
		return tlinkcs;
	}
	public void setTlinkcs(List<Tlinkc> tlinkcs) {
		this.tlinkcs = tlinkcs;
	}
	public List<Score> getScores() {
		return scores;
	}
	public void setScores(List<Score> scores) {
		this.scores = scores;
	}
	public List<Cl> getCles() {
		return cles;
	}
	public void setCles(List<Cl> cles) {
		this.cles = cles;
	}

	
	public String Thfind(){
		ActionContext ctx = ActionContext.getContext();
		if(teacher == null){ teacher=new Teacher();
			teacher.setTeacherName("");
			teacher.setTeacherPhone("");}
		String teacherName = teacher.getTeacherName();
		String teacherPhone = teacher.getTeacherPhone();
		System.out.println(teacherName);
		System.out.println(teacherPhone);
		List<Teacher> teacherlist = visitorService.findByTnTt(teacherName,teacherPhone, 0);
		setTeachers(teacherlist);
		ctx.getSession().put("message", "��ʦ���ҳɹ�����ѯ����"+teacher.getTeacherName()+" , "+teacher.getTeacherPhone());
		return "Thfind_view";
	}
	
	public String Shfind(){
		ActionContext ctx = ActionContext.getContext();
		if(student == null){
			student = new Student();
			student.setStudentName("王小明");
			student.setStudentTelephone("");
		}
		List<Student> studentlist = visitorService.findBySnSt(student.getStudentName(),student.getStudentTelephone(), offset);
		setStudents(studentlist);
		ctx.getSession().put("message", "ѧ����ҳɹ�����ѯ����"+student.getStudentName()+" , "+student.getStudentTelephone());
		return "Shfind_view";
	}
	
	public String Chfind(){
		ActionContext ctx = ActionContext.getContext();
		
		if(teacher == null){
			teacher = new Teacher();
			teacher.setTeacherName("");
			teacher.setTeacherPhone("");
		}
		if(cl == null ){
			cl=new Cl();
			cl.setClassId("");
			cl.setClassName("");
			cl.setClassStartDate("");
			cl.setClassEndDate("");
		}

		List<Tlinkc> tlinkclist = visitorService.findByCiCnTn(teacher.getTeacherName(),cl.getClassId(),cl.getClassName(),cl.getClassStartDate(),cl.getClassEndDate(), offset);
		setTlinkcs(tlinkclist);
		ctx.getSession().put("message", "�༶���ҳɹ�����ѯ����"+teacher.getTeacherName()+" , "+cl.getClassName()+" , "+cl.getClassStartDate()+","+cl.getClassEndDate());
		return "Chfind_view";
	}
	
	public String Schfind(){
		ActionContext ctx = ActionContext.getContext();
		if(student == null){
			student = new Student();
			student.setStudentName("王小明");
		}
		if(className == null){
			className="";
		}
		if(courseName == null){
			courseName = "";
		}
		if(chapterName == null){
			chapterName ="";
		}
		List<Cl> acles = visitorService.findAll();
		setCles(acles);
		ctx.put("acles", acles);
		System.out.println(className);
//		List<Score> scorelist = visitorService.findBySnCnCnCn(student.getStudentName(), className, courseName, chapterName,   offset);
//		setScores(scorelist);
		return "Schfind_view";
	}
	
	public String Tshow(){
		ActionContext ctx = ActionContext.getContext();
		Teacher ateacher = visitorService.findByTi(username);
		setTeacher(ateacher);
		Set<Tlinkc> tlinkclist = ateacher.getTlinkcs();
		setStlinkcs(tlinkclist);
		return "Tshow_view";
	}
	
	public String Cshow(){
		ActionContext ctx = ActionContext.getContext();
		Cl acl = visitorService.findByCi(classId);
		setCl(acl);
		Set<Slinkc> slinkcset = acl.getSlinkcs();
		Set<Clinkc> clinkcset = acl.getClinkcs();
		setSslinkcs(slinkcset);
		setSclinkcs(clinkcset);
		return "Cshow_view";
	}
	
	public String Sshow(){
		Student astudent = visitorService.findBySi(studentId);
		setStudent(astudent);
		Set<Score> scorelist = astudent.getScores();
		setSscores(scorelist);
		return "Sshow_view";
	}
	
	
}
