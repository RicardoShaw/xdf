<%@ page language="java" import="java.util.*"  contentType="text/html;charset=gb2312"%> 
<%@ page import="com.ricardo.entity.Cchapter" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<HTML><HEAD><TITLE>添加章节信息</TITLE>
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

<body background="<%=basePath %>images/adminBg.jpg">
<s:fielderror cssStyle="color:red" />
<table align="center" height="100%" cellSpacing=0 cellPadding=0 width="80%" border=0>
  <tr>
    <td align="left" vAlign=top ><s:form action="Chapter_add" method="post" onsubmit="return checkForm();" enctype="multipart/form-data" name="form1">
<table width='100%' cellspacing='1' cellpadding='3' class="tablewidth">
  <tr>
  <td width=30%></td>
    <td width=70%><s:textfield name="chapter.chapterId" label="章节编号" readonly="true"/></td>
  </tr>

  <tr>
<td width=30%></td>
  <td width=70%><s:textfield name="chapter.chapterName" label="章节名称" /></td>
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
   </td></tr>
</table>
</body>
</HTML>