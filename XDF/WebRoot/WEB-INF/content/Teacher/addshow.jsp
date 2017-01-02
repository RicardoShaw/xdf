<%@ page language="java" import="java.util.*"  contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    String username=(String)session.getAttribute("username");
    if(username==null){
        response.getWriter().println("<script>top.location.href='" + basePath + "login/login_view.action';</script>");
    }
%>
<HTML><HEAD><TITLE>添加教师信息</TITLE> 
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
    var teacherNumber = document.getElementById("teacher.username").value;
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
    <TD align="left" vAlign=top >
    <s:form action="Teacher_add" onsubmit="return checkForm();"  enctype="multipart/form-data">
<table width='100%' cellspacing='1' cellpadding='3' class="tablewidth">
<tr>
    <td width=30%>教师编号:</td>
    <td width=70%><s:textfield name="teacher.username" value="#teacher.username" />  </td>
  </tr>

  <tr>
    <td width=30%>教师姓名:</td>
    <td width=70%><s:textfield name="teacher.teacherName" value="#teacher.teacherName" /> </td>
  </tr>

  <tr>
    <td width=30%>登录密码:</td>
    <td width=70%><s:password showPassword="true" name="teacher.username" value="#teacher.username" /> </td>
  </tr>

  <tr>
    <td width=30%>性别:</td>
    <td width=70%>

    <s:select name="teacher.teacherSex" list="#{'0':'男','1':'女'}" label="性别" headerKey="" headerValue="请选择性别"></s:select></td>
  </tr>

  <tr>
    <td width=30%>出生日期:</td>
    <td width=70%><s:textfield name="teacher.teacherBirthday" value="#teacher.teacherBirthday" onclick="setDay(this)" /> </td>
  </tr>

  <tr>
    <td width=30%>入职日期:</td>
    <td width=70%><s:textfield name="teacher.teacherArriveDate" value="#teacher.teacherArriveDate" onclick="setDay(this)" /></td>
  </tr>

  <tr>
    <td width=30%>身份证号:</td>
    <td width=70%><s:textfield name="teacher.teacherCardNumber" value="#teacher.teacherCardNumber"/></td>
  </tr>

  <tr>
    <td width=30%>联系电话:</td>
    <td width=70%><s:textfield name="teacher.teacherPhone" value="#teacher.teacherPhone"/></td>
  </tr>



  <tr>
    <td width=30%>家庭地址:</td>
    <td width=70%><s:textfield name="teacher.teacherAddress" value="#teacher.teacherAddress"/></td>
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
