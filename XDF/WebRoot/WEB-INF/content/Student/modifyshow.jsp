<%@ page language="java" import="java.util.*"  contentType="text/html;charset=UTF-8"%> 
<%@ page import="com.ricardo.entity.*" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    String username=(String)session.getAttribute("username");
    if(username==null){
        response.getWriter().println("<script>top.location.href='" + basePath + "login/login_view.action';</script>");
    }
%>
<HTML><HEAD><TITLE>修改学生信息</TITLE>
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
<script language="javascript">
/*验证表单*/
function checkForm() {
    var studentNumber = document.getElementById("student.studentId").value;
    if(studentNumber=="") {
        alert('请输入学生编号!');
        return false;
    }
    var studentName = document.getElementById("student.studentName").value;
    if(studentName=="") {
        alert('请输入学生姓名!');
        return false;
    }
    var studentSex = document.getElementById("student.studentSex").value;
    if(studentSex=="") {
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
    <TD align="left" vAlign=top ><s:form action="Student_modify" method="post" onsubmit="return checkForm();" enctype="multipart/form-data" name="form1">
<table width='100%' cellspacing='1' cellpadding='3' class="tablewidth">
  <tr>
    <td width=30%></td>
    <td width=70%><s:textfield name="student.studentId" label="学生编号" readonly="true"/>  </td>
  </tr>

  <tr>
    <td width=30%></td>
    <td width=70%><s:textfield name="student.studentName" label="学生姓名"  readonly="true"/> </td>
  </tr>

  <tr>
    <td width=30%></td>
    <td width=70%>
    <s:select name="student.studentSex" list="#{'男':'男','女':'女'}" label="性别"  headerKey="" headerValue="请选择性别"></s:select></td>
  </tr>

  <tr>
    <td width=30%></td>
    <td width=70%><s:textfield name="student.studentBirthday"  label="出生日期" onclick="setDay(this)" /> </td>
  </tr>


  <tr>
    <td width=30%></td>
    <td width=70%><s:textfield name="student.studentTelephone" label="联系电话"/></td>
  </tr>

  <tr>
    <td width=30%></td>
    <td width=70%><s:textfield name="student.studentEmail" label="E-mail"/></td>
  </tr>

    <tr>
    <td width=30%></td>
    <td width=70%><s:textfield name="student.studentQq" label="QQ"/></td>
  </tr>


  <tr>
    <td width=30%></td>
    <td width=70%><s:textfield name="student.studentAddress" label="家庭住址"/></td>
  </tr>


  <tr bgcolor='#FFFFFF'>
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
</HTML>

