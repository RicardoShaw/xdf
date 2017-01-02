/**
 *
 * file_name   : test.java
 * @date       : 2016��11��25��
 * @author     : Ricardo Shaw
 * @email      : ricardoshaw@qq.com
 * @changedate : ����7:46:51
 * 
 **/
package TEST;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionContext;
import com.ricardo.dao.IAdminDAO;
import com.ricardo.dao.ICchapterDAO;
import com.ricardo.dao.IClDAO;
import com.ricardo.dao.IClinkcDAO;
import com.ricardo.dao.ICourseDAO;
import com.ricardo.dao.IScoreDAO;
import com.ricardo.dao.ISlinkcDAO;
import com.ricardo.dao.IStudentDAO;
import com.ricardo.dao.ITeacherDAO;
import com.ricardo.dao.ITlinkcDAO;
import com.ricardo.dao.impl.AdminDAO;
import com.ricardo.dao.impl.ClDAO;
import com.ricardo.dao.impl.SlinkcDAO;
import com.ricardo.dao.impl.StudentDAO;
import com.ricardo.dao.impl.TeacherDAO;
import com.ricardo.dao.impl.TlinkcDAO;
import com.ricardo.entity.Admin;
import com.ricardo.entity.Cchapter;
import com.ricardo.entity.Cl;
import com.ricardo.entity.Clinkc;
import com.ricardo.entity.Colinkch;
import com.ricardo.entity.Course;
import com.ricardo.entity.Score;
import com.ricardo.entity.Slinkc;
import com.ricardo.entity.Student;
import com.ricardo.entity.Teacher;
import com.ricardo.entity.Tlinkc;
import com.ricardo.service.ScoreService;
import com.ricardo.service.VisitorService;
import com.ricardo.util.AddClasses;
import com.ricardo.util.CreateCourseId;
import com.ricardo.util.TimeUtil;



/**
 * @author : Ricardo Shaw
 * @date   : 2016��11��25�� ����7:46:51
 */
public class test {
	public static void main(String[] args) throws FileNotFoundException{
		ApplicationContext atx = new ClassPathXmlApplicationContext("applicationContext.xml");
//		VisitorService visitorService = atx.getBean("visitorService",com.ricardo.service.impl.VisitorServiceImpl.class);
//		List<Cl> cles = visitorService.findAll();
//		System.out.println(cles.size());
//		ScoreService scoreService = atx.getBean("scoreService",com.ricardo.service.impl.ScoreServiceImpl.class);
//		Cl cl = new Cl();
//		cl.setClassId("J1SS1043");
//		Student student = new Student();
//		student.setStudentId("S20161216001");
//		student.setStudentName("xiaochi");
//		student.setStudentTelephone("18971472715");
//		Score score = new Score();
//		score.setCl(cl);
//		score.setStudent(student);
//		score.setCourseName("ge");
//		score.setChapterName("de");
//		score.setDtscore(new Float(98.99));
//		score.setHwscore("AAA");
//		scoreService.addScore(score);
//		
//		ICourseDAO icourseDao = atx.getBean("icourseDao",com.ricardo.dao.impl.CourseDAO.class);
//		Scanner in = new Scanner(new FileInputStream("c:\\k.dat"));
//		while(in.hasNextLine()){
//			String cl = in.nextLine();
//			System.out.println(cl);
//			String[] clinfo = cl.split("\\|");
//			Course course = new Course();
//			int id = Integer.parseInt(clinfo[0]);
//			course.setCourseId(CreateCourseId.getCourseId(id));
//			course.setCourseName(clinfo[1]);
//			icourseDao.save(course);
//		}
		
		
//		IClDAO iclDao = atx.getBean("iclDao",com.ricardo.dao.impl.ClDAO.class);
//		IStudentDAO istudentDao = atx.getBean("istudentDao",com.ricardo.dao.impl.StudentDAO.class);
//		Student astudent = istudentDao.findById("20161022006");
//		istudentDao.delete(astudent);
//		Scanner in = new Scanner(new FileInputStream("c:\\c.dat"));
//		while(in.hasNextLine()){
//			String cl = in.nextLine();
//			System.out.println(cl);
//			String[] clinfo = cl.split("\\|");
//			Cl acl = new Cl();
//			acl.setClassId(clinfo[0]);
//			acl.setClassName(clinfo[1]);
//			acl.setClassDate(clinfo[2]);
//			acl.setClassPlace(clinfo[3]);
//			acl.setClassStartDate(clinfo[4]);
//			acl.setClassEndDate(clinfo[5]);
//			iclDao.save(acl);
		
		//		ICchapterDAO icchapterDao = atx.getBean("icchapterDao",com.ricardo.dao.impl.CchapterDAO.class);
//		Cchapter chapter = icchapterDao.findById("2-15");
//		System.out.println(chapter.getChapterId()+"|"+chapter.getChapterName());
//		icchapterDao.delete(chapter);
		
		//		ITeacherDAO tDao = atx.getBean("iteacherDao", com.ricardo.dao.impl.TeacherDAO.class);
//		Teacher teacher = new Teacher();
//		teacher.setTeacherName("");
//		teacher.setTeacherPhone("");
//		System.out.println(teacher.getTeacherName());
//		System.out.println(teacher.getTeacherPhone());
//		List<Teacher> teacherlist = tDao.findByTnTt(teacher.getTeacherName(),teacher.getTeacherPhone(), 0, 20);
//		System.out.println(teacherlist.size());
		
//		IClDAO cDao = atx.getBean("iclDao",com.ricardo.dao.impl.ClDAO.class);
//		Cl cl = cDao.findById("J2SS2029");
//		List<Cl> cles = cDao.findAll();
//		for(Cl cl: cles){
//			System.out.println(cl.toString());
//		}
		
//		System.out.println(cl.toString());
		
		
		
		
		
		
//		ITlinkcDAO itlinkcDao = atx.getBean("itlinkcDao",com.ricardo.dao.impl.TlinkcDAO.class);
//		List<Tlinkc> tlinkcs = itlinkcDao.findByTnCiCnCsCe("", "", "", "2016-10", "",0);
//		for(Tlinkc tlinkc:tlinkcs){
//			log.debug(""+tlinkc.getId());
//			System.out.println(tlinkc.getId());
////		}
//		IClDAO iclDao = atx.getBean("iclDao",com.ricardo.dao.impl.ClDAO.class);
//		Cl cl = iclDao.findById("J1SS2038");
//		System.out.println(cl.getClassId());
//		iclDao.delete(cl);
//		TlcService ts = atx.getBean("tlcService",com.ricardo.service.impl.TlcServiceImpl.class);
//		Cl cl = iclDao.findById("J1SS2038");
//		ts.deleteCl(cl);
		
		
		
//		
//	
//		ISlinkcDAO slcdao = (ISlinkcDAO) atx.getBean("islinkcDao");
//		IClDAO cldao = (IClDAO) atx.getBean("iclDao");
//		ICourseDAO cdao =(ICourseDAO) atx.getBean("icourseDao");
//		IClinkcDAO clcdao = (IClinkcDAO) atx.getBean("iclinkcDao");
//		ITlinkcDAO tlcdao = atx.getBean("itlinkcDao",com.ricardo.dao.impl.TlinkcDAO.class);
//		IStudentDAO sdao = atx.getBean("istudentDao",com.ricardo.dao.impl.StudentDAO.class);
//		ITeacherDAO tdao = atx.getBean("iteacherDao",com.ricardo.dao.impl.TeacherDAO.class);
//		
//		Teacher teacher = new Teacher("TH000","123456");
//		int result = tdao.findByTiTp(teacher);
//		System.out.println(result);
//		result = tdao.findByTiTp(teacher.getUsername(), teacher.getPassword());
//		System.out.println(result);
//		List<Teacher> teachers = tdao.findByExample(teacher);
//		for(Teacher teacher1:teachers){
//			System.out.println(teacher1.getUsername()+" , " +teacher1.getPassword());
//		}
//		String st = "error|��������ʲô�?";
//		String[] st1 = st.split("\\|");
//		String st2 = st1[0];
//		String st3 = st1[1];
//		System.out.println(st2+"                         "+st3);
		
		
		
		
//		IScoreDAO scdao = atx.getBean("iscoreDao",com.ricardo.dao.impl.ScoreDAO.class);
//		Score score = new Score(null,null,"KC02","Lesson 1",null,null);
//		List<Score> scores=scdao.findByExample(score);
//		for(Score bscore:scores){
//			System.out.println(bscore.getId());
//		}
//	String hql="from Student as model where model.studentId like  ?  "
//			+ "and model.studentName like  ? "
//			+ " and model.studentSex like  ?  "
//			+ "and model.studentBirthday like  ?  "
//			+ " and model.studentPhoto like  ?  "
//			+ "and studentTelephone like  ?  "
//			+ " and model.studentEmail like  ?  "
//			+ "and model.studentQq like  ? "
//			+ " and model.studentAddress like  ? " 
			;
//	String[] values = new String[]{"2016","","18"};
//		List<Student> students = 
//				sdao.findAll();
//				sdao.findByPage(hql, values, 0, 10);
//		for(Student student:students){
//			System.out.println(student.getStudentId());
//		}
		
		
//		TclService ts = atx.getBean("tclService",com.ricardo.service.impl.TclServiceImpl.class);
//		
//		ts.deleteAClass("JS0001");
//		Course course = cdao.findById("KC001");
//		System.out.println(course.getCourseName());
//		System.out.println("------------------");
//		Cl cl = new
//				 Cl();
//		cl = cldao.findById("J1SS1043");
//		if(cl == null){
//			System.out.println("�ն���");
//			System.out.println("------------------");
//		}
//		
//		System.out.println(cl.getClassName());
//		System.out.println("------------------");
//		
//		List<Clinkc> clinkcs= clcdao.findByClassId("J1SS2038");
//		System.out.println(clinkcs.size());
//		for(Clinkc clinkc:clinkcs){
//			System.out.println(clinkc.getCourse().getCourseId());
//		}
//		System.out.println("------------------");
//		
//		List<Tlinkc> tlinkcs= tlcdao.findByCId("JS0001");
//		System.out.println(tlinkcs.size());
//		for(Tlinkc tlinkc:tlinkcs){
//			System.out.println(tlinkc.getTeacher().getUsername());
//		}
//		System.out.println("------------------");
//		
//		List<Slinkc> slinkcs = 
//				slcdao.findByClId("J1SS2038");
////				slcdao.findAll();
//		System.out.println(slinkcs.size());
//		for(Slinkc slinkc:slinkcs){
//			System.out.println(slinkc.getCl().getClassName()+" , "+slinkc.getStudent().getStudentId()+" ,  "+slinkc.getStudent().getStudentName());
//		}
//		System.out.println("------------------");
//		List<Score> scores = 
////				tmi.findByCSname("��");
//				tmi.findByCCS("","Lesson 1","");
////				tmi.
//		
//		for(Score  score : scores){
//			System.out.println(score.getStudent().getStudentId()+" , "+score.getStudent().getStudentName()+" , "+
//							score.getCl().getClassName()+" , "+score.getCourseId()+" , "+score.getChapterId()+" , "+score.getHwscore()
//							+" , "+score.getDtscore());
//		}
		
//		ValidLoginService vl = atx.getBean("ValidManager",com.ricardo.service.impl.ValidLoginServiceImpl.class);
//		
//			Teacher person = new Teacher("TH008","yashiki");
//			
//			System.out.println(vl.validLogin("TH008","yashiki"));
//		
//		
//		
//		
//	
//		
//
//		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		AdminDAO asi = atx.getBean("AdminDAO",com.ricardo.dao.impl.AdminDAO.class);
//		StudentDAO std = atx.getBean("StudentDAO",com.ricardo.dao.impl.StudentDAO.class);
//
//
//		List<Student> students = std.findAll();
//		for(Student student:students){
//			Set<Score> scores = student.getScores();
//			System.out.println(student.getStudentName());
//			for(Score score : scores){
//				System.out.println(score.getCourseId()+"\t"+score.getChapterId()+"\t"+score.getHwscore()+"\t"+score.getHwscore());
//			}
//		}
		
		
		
		
		
		
		
		
//		List<Admin> admins = asi.findAll();
//		for(Admin teacher :admins){
//			System.out.println(teacher.toString());
//			Set<Tlinkc> tlincs = teacher.getTlinkcs();
//			for(Tlinkc tlinkc:tlincs){
//				Set<Clinkc> clinkcs = tlinkc.getCl().getClinkcs();
//				for(Clinkc clinkc:clinkcs){
//					System.out.println(tlinkc.getTeacher().getTeacherName()+" "+tlinkc.getCl().getClassName()+" "+clinkc.getCourse().getCourseName());
//				}
//				
//			}
//		}
			
//		TlinkcDAO tlcdao = atx.getBean("TlinkcDAO", com.ricardo.dao.impl.TlinkcDAO.class);
//		TeacherDAO tdao = atx.getBean("TeacherDAO",com.ricardo.dao.impl.TeacherDAO.class);
//		ClDAO cldao = atx.getBean("ClDAO",com.ricardo.dao.impl.ClDAO.class);
//		
//		Teacher teacher=new Teacher("TH005","ricardo","124678");
//		tdao.save(teacher);
//		Cl	 cl = new Cl();
//		cl.setClassId("JS0001");
//		cl.setClassName("2017������");
//		cldao.save(cl);
//		Course course = new Course("KC005","�¸���һ(1-12)");
//		Tlinkc tlc  =  new Tlinkc(cl,teacher);
//		tlcdao.save(tlc);
			
//				List<Cl> cles = cDao.findAll(0,20);
//				int i = 0;
//			    for(Cl cl:cles){
//
//			    	System.out.println( "array["+i+"] = new Array('"+cl.getClassName()+"','"+"根目录"+"','"+cl.getClassName()+"')");
//			    	i++;
//			    	Set<Clinkc> clinkcs = cl.getClinkcs();
//			    	for(Clinkc clinkc:clinkcs){
//			    		Course course = clinkc.getCourse();
//			    		System.out.println( "array["+i+"] = new Array('"+course.getCourseName()+"','"+cl.getClassName()+"','"+course.getCourseName()+"')");
//			    		i++;
//			    		Set<Colinkch> colinkchs = course.getColinkchs();
//			    		for(Colinkch colinkch : colinkchs){
//			    				Cchapter chapter = colinkch.getCchapter();
//			    				System.out.println( "array["+i+"] = new Array('"+chapter.getChapterName()+"','"+course.getCourseName()+"','"+chapter.getChapterName()+"')");
//			    				i++;
//			    		}
//			    	}
//			  }

			ICchapterDAO icchapterDao = atx.getBean("icchapterDao",com.ricardo.dao.impl.CchapterDAO.class);
			
			Scanner in = new Scanner(new FileInputStream("c:\\chapter.dat"));
			while(in.hasNextLine()){
				String cl = in.nextLine();
				System.out.println(cl);
				String[] clinfo = cl.split("\\|");
				Cchapter chapter = new Cchapter();
				chapter.setChapterId(clinfo[0]);
				chapter.setChapterName(clinfo[1]);
				icchapterDao.save(chapter);
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	}
	
	}

