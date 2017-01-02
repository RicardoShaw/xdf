<%@ page language="java" import="java.util.*"  contentType="text/html;charset=UTF-8"%> 
<%@ page import="com.ricardo.entity.*" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    List<Cl> cles = (List<Cl>)request.getAttribute("cles");
    String username=(String)session.getAttribute("username");
    int i = 0;
    if(username==null){
        response.getWriter().println("<script>top.location.href='" + basePath + "login/login_view.action';</script>");
    }
%>
<HTML><HEAD><TITLE>添加分数信息</TITLE>
<STYLE type=text/css>
BODY {
	MARGIN-LEFT: 0px; BACKGROUND-COLOR: #ffffff
}
.STYLE1 {color: #ECE9D8}
.label {font-style.:italic; }
.errorLabel {font-style.:italic;  color:red; }
.errorMessage {font-weight:bold; color:red; }
</STYLE>
  <script src="<%=basePath %>calendar.js"></script>
 <script src="<%=basePath %>liandong.js"></script>
<script language="javascript">
/*验证表单*/
function checkForm() {
    var teacherNumber = document.getElementById("teacher.teacherNumber").value;
    if(teacherNumber=="") {
        alert('请输入教师编号!');
        return false;
    }
    var teacherName = document.getElementById("teacher.teacherName").value;
    if(teacherName=="") {
        alert('请输入教师姓名!');
        return false;
    }
    var teacherSex = document.getElementById("teacher.teacherSex").value;
    if(teacherSex=="") {
        alert('请输入性别!');
        return false;
    }
    return true; 
}
 </script>
</HEAD>
<BODY background="<%=basePath %>images/adminBg.jpg">
<s:fielderror cssStyle="color:red" />
<TABLE align="center" height="100%" cellSpacing=0 cellPadding=0 width="80%" border=0>
  <TBODY>
  <TR>
    <TD align="left" vAlign=top ><s:form action="Score_add" method="post"  enctype="multipart/form-data" name="form1">
<table width='100%' cellspacing='1' cellpadding='3' class="tablewidth">
  <tr>
    <td width=30%>班级编号:</td>
    <td width=70%><SELECT id="s4" name="" ><OPTION selected></OPTION> </SELECT></td>
  </tr>
  <tr>
    <td width=30%>学生编号:</td>
    <td width=70%><SELECT id="s5" name="studentId" ><OPTION selected></OPTION> </SELECT>  </td>
  </tr>

  <tr>
    <td width=30%>班级编号:</td>
    <td width=70%><SELECT id="s1" name="classId" ><OPTION selected></OPTION> </SELECT> </td>
  </tr>

 <tr>
    <td width=30%>课程名称:</td>
    <td width=70%><SELECT id="s2" name="courseName" ><OPTION selected></OPTION> </SELECT> </td>
  </tr>

 <tr>
    <td width=30%>章节名称:</td>
    <td width=70%><SELECT id="s3" name="chapterName" ><OPTION selected></OPTION> </SELECT> </td>
  </tr>

   <tr>
    <td width=30%></td>
    <td width=70%><s:textfield name="hwscore" label="作业成绩"/></td>
  </tr>

   <tr>
    <td width=30%></td>
    <td width=70%><s:textfield name="dtscore" label="听写成绩"/></td>
  </tr>
  

  <tr>
      <td colspan="4" align="center">
        <input type='submit' name='button' value='保存' >
        &nbsp;&nbsp;
        <input type="reset" value='重写' />
      </td>
    </tr>
</table>
</s:form>
   </TD></TR>
  </TBODY>
</TABLE>
</BODY>
<script language="javascript">
    //例子1-------------------------------------------------------------
  //数据源
  var array=new Array();
  
  <% 

    for(Cl cl:cles){
  %>
  array[<%=i%>] = new Array("根目录","班级","<%=cl.getClassId()%>","<%=cl.getClassName()%>")
  <%
  i++;
  Set<Slinkc> slinkcs = cl.getSlinkcs();
  for(Slinkc slinkc: slinkcs){
    Student student = slinkc.getStudent();
  %>
    array[<%=i%>] = new Array("<%=cl.getClassId()%>","学生","<%=student.getStudentId()%>","<%=student.getStudentName()%>")

  <%
    i++;
  }
  Set<Clinkc> clinkcs = cl.getClinkcs();
  for(Clinkc clinkc:clinkcs){
    Course course = clinkc.getCourse();
  %>
 
  array[<%=i%>] = new Array("<%=cl.getClassId()%>","课程","<%=course.getCourseName()%>","<%=course.getCourseName()%>")
  <%
  i++;
  Set<Colinkch> colinkchs = course.getColinkchs();
    for(Colinkch colinkch : colinkchs){
      Cchapter chapter = colinkch.getCchapter();
  %>
  array[<%=i%>] = new Array("<%=course.getCourseName()%>","章节","<%=chapter.getChapterName()%>","<%=chapter.getChapterName()%>")
  
  <%
  i++;
  }//end for(Colinkch)
  }//end for(Clinkc)
  
  }//end for(cles)
  
 
  %>

  //--------------------------------------------
  //这是调用代码
  var liandong=new CLASS_LIANDONG_YAO(array) //设置数据源
  liandong.firstSelectChange("根目录","班级","s1"); //设置第一个选择框
  liandong.subSelectChange("s1","课程","s2"); //设置子级选择框
  liandong.subSelectChange("s2","章节","s3");
  liandong.firstSelectChange("根目录","班级","s4"); //设置第一个选择框
  liandong.subSelectChange("s4","学生","s5"); //设置第一个选择框
</script>
</HTML>



