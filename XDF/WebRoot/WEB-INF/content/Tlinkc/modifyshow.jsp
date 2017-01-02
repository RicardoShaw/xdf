<%@ page language="java" import="java.util.*"  contentType="text/html;charset=UTF-8"%>
<%@ page import="com.ricardo.entity.*" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<HTML><HEAD><TITLE>添加教师课程信息</TITLE>
<STYLE type=text/css>
body {
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
    var classNumber = document.getElementById("chapter.chapterId").value;
    if(classNumber=="") {
        alert('请输入章节编号（格式为2-15,2代表新概念二，15代表lesson15）!');
        return false;
    }
    var className = document.getElementById("chapter.chapterName").value;
    if(className=="") {
        alert('请输入章节名称,名称不能为空!');
        return false;
    }
    return true; 
}
 </script>
</HEAD>

<body>
<s:fielderror cssStyle="color:red" />
<table align="center" height="100%" cellSpacing=0 cellPadding=0 width="80%" border=0>
  <tr>
    <td align="left" vAlign=top ><s:form action="Student_modify"  onsubmit="return checkForm();" enctype="multipart/form-data" name="form1">
<table width='100%' cellspacing='1' cellpadding='3' class="tablewidth">
	<tr>
    <s:textfield name="student.studentId" label="学生编号" readonly="true"/></td>
  </tr>


  <tr>
   <td><s:textfield name="student.studentName"  label="学生姓名"readonly="true"/></td>
  </tr>

  <tr>

    <td>
    <s:select name="student.studentSex" list="#{'0':'男','1':'女'}" label="性别" headerKey="" headerValue="请选择性别"></s:select></td>
  </tr>
  
  <tr>
    <td width=70%><s:textfield name="student.studentBirthday" label ="学生生日"onclick="setDay(this)" /> </td>
  </tr>


  <tr>
    <td width=70%><s:textfield name="student.studentTelephone" label="联系电话"/></td>
  </tr>

  <tr>
    <td width=70%><s:textfield name="student.studentEmail" label="E-mail" /></td>
  </tr>

    <tr>

    <td width=70%><s:textfield name="student.studentQq" Label="QQ"/></td>
  </tr>


  <tr>
    <td width=70%><s:textfield name="student.studentAddress" label="家庭地址" /></td>
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
   </td></tr>
</table>
</body>
</HTML>