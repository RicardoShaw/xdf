/**
 *
 * file_name   : ScoreAction.java
 * @date       : 2016年12月13日
 * @author     : Ricardo Shaw
 * @email      : ricardoshaw@qq.com
 * @changedate : 下午4:10:04
 * 
 **/
package com.ricardo.action;


import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.ricardo.baseaction.ScoreBaseAction;
import com.ricardo.entity.Cchapter;
import com.ricardo.entity.Cl;
import com.ricardo.entity.Score;
import com.ricardo.entity.Student;


/**
 * @author : Ricardo Shaw
 * @date   : 2016年12月13日 下午4:10:04
 */
public class ScoreAction extends ScoreBaseAction {
	private Score score;
	
	private String studentName;
	private String studentId;
	private String classId;
	private String courseName;
	private String chapterName;
	private String hwscore;
	private double upperlimit;
	private double lowerlimit;
	private double dtscore;
	
	private int id;
	private int currentPage;
	private int totalPage; 
	
	private List<Cl> cles;
	
	

	public List<Cl> getCles() {
		return cles;
	}


	public void setCles(List<Cl> cles) {
		this.cles = cles;
	}


	public String getStudentId() {
		return studentId;
	}


	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}


	public String getHwscore() {
		return hwscore;
	}


	public void setHwscore(String hwscore) {
		this.hwscore = hwscore;
	}

	private List<Score> scores;

	
	public Score getScore() {
		return score;
	}


	public void setScore(Score score) {
		this.score = score;
	}


	public String getStudentName() {
		return studentName;
	}


	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}


	public String getClassId() {
		return classId;
	}


	public void setClassId(String classId) {
		this.classId = classId;
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


	public double getUpperlimit() {
		return upperlimit;
	}


	public void setUpperlimit(double upperlimit) {
		this.upperlimit = upperlimit;
	}


	public double getLowerlimit() {
		return lowerlimit;
	}


	public void setLowerlimit(double lowerlimit) {
		this.lowerlimit = lowerlimit;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
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


	public List<Score> getScores() {
		return scores;
	}


	public void setScores(List<Score> scores) {
		this.scores = scores;
	}
	
	public double getDtscore() {
		return dtscore;
	}


	public void setDtscore(double dtscore) {
		this.dtscore = dtscore;
	}


	public String main(){
		ActionContext ctx = ActionContext.getContext();
		List<Cl> acles = classService.findAll();
		setCles(acles);
		setUpperlimit(100.0);
		setLowerlimit(0.0);
		setCurrentPage(0);
		setTotalPage(0);
		return "main";
	}
	
	public String Hmain(){
		if(currentPage == 0 ) {setCurrentPage(1);}
		if(totalPage == 0)		{setTotalPage(1);}
		ActionContext ctx = ActionContext.getContext();
		List<Cl> acles = classService.findAll();
		setCles(acles);
		return "Hmain";
	}
	

	public String scoreshow(){
		return "scoreshow_view";
	}
	
	
	public String Hquery(){
		ActionContext ctx = ActionContext.getContext();
		List<Cl> acles = classService.findAll();
		ctx.put("cles", acles);
		setTotalPage(scoreService.getMaxPage(studentName, classId, courseName, chapterName));
		List<Score> scorelist = scoreService.findBySnCnCnCn(studentName, classId, courseName, chapterName, currentPage);
		setScores(scorelist);
		return "Hquery_view";
	}
	
	public String query(){
		if(currentPage == 0 ) {setCurrentPage(1);}
		if(totalPage == 0){setTotalPage(1);}
		ActionContext ctx = ActionContext.getContext();
		List<Cl> acles = classService.findAll();
		ctx.put("cles", acles);
		setCles(acles);
		setTotalPage(scoreService.getMaxPage(studentName, classId, courseName, chapterName,new Float(upperlimit),new Float(lowerlimit)));
		List<Score> scorelist = scoreService.findBySnCnCnCn(studentName, classId, courseName, chapterName,new Float(upperlimit),new Float(lowerlimit), currentPage);
		setScores(scorelist);
		return "query_view";
	}
	
	public String addshow(){
		ActionContext ctx = ActionContext.getContext();
		List<Cl> acles = classService.findAll();
		ctx.put("cles", acles);
		return "addshow_view";
	}
	
	public String add(){
		ActionContext ctx = ActionContext.getContext();
		Cl cl = classService.findByCi(classId);
		Student student = studentService.findBySi(studentId);
		Score ascore = new Score();
		ascore.setStudent(student);
		ascore.setCl(cl);
		ascore.setChapterName(chapterName);
		ascore.setCourseName(courseName);
		ascore.setDtscore(new Float(dtscore));
		ascore.setHwscore(hwscore);
		String message = scoreService.addScore(ascore);
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
		List<Cl> acles = classService.findAll();
		ctx.put("acles", acles);
		Score ascore = scoreService.findByScId(id);
		setScore(ascore);
		return "modifyshow_view";
	}
	
	public String modify(){
		ActionContext ctx = ActionContext.getContext();
		String message = scoreService.modifyScore(score);
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
		Score ascore = scoreService.findByScId(id);
		String message = scoreService.deleteScore(ascore);
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
