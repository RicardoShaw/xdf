<%@ page language="java" import="java.util.*"  contentType="text/html;charset=UTF-8"%> 
<%@ page import="com.ricardo.entity.Teacher" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    String username=(String)session.getAttribute("username");
    if(username==null){
        response.getWriter().println("<script>top.location.href='" + basePath + "login/login_view.action';</script>");
    }
%>
<HTML><HEAD><TITLE>修改教师信息</TITLE>
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
    <TD align="left" vAlign=top ><s:form action="Teacher_modify" method="post" onsubmit="return checkForm();" enctype="multipart/form-data" name="form1">
<table width='100%' cellspacing='1' cellpadding='3' class="tablewidth">
  <tr>
    <td width=30%></td>
    <td width=70%><s:textfield name="teacher.username" label="教师编号" readonly="true"/>  </td>
    
  </tr>

  <tr>
    <td width=30%></td>
    <td width=70%><s:textfield name="teacher.teacherName" label="教师姓名" readonly="true"/> </td>
  </tr>

  <tr>
    <td width=30%></td>
    <td width=70%><s:password showPassword="true" name="teacher.username" label="登入密码"/> </td>
  </tr>

  <tr>
    <td width=30%></td>
    <td width=70%>

    <s:select name="teacher.teacherSex" list="#{'0':'男','1':'女'}" label="性别" headerKey="" headerValue="请选择性别"></s:select></td>
  </tr>

  <tr>
    <td width=30%></td>
    <td width=70%><s:textfield name="teacher.teacherBirthday" onclick="setDay(this)" label="出生日期" /> </td>
  </tr>

  <tr>
    <td width=30%></td>
    <td width=70%><s:textfield name="teacher.teacherArriveDate"  onclick="setDay(this)" label="入职日期"/></td>
  </tr>

  <tr>
    <td width=30%></td>
    <td width=70%><s:textfield name="teacher.teacherCardNumber" label="身份证号"/></td>
  </tr>

  <tr>
    <td width=30%></td>
    <td width=70%><s:textfield name="teacher.teacherPhone" label="联系电话"/></td>
  </tr>


  <tr>
    <td width=30%></td>
    <td width=70%><s:textfield name="teacher.teacherAddress" label="家庭地址"/></td>
  </tr>


  <tr >
      <td colspan="4" >
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

