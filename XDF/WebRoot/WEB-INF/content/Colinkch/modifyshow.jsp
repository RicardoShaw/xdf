<%@ page language="java" import="java.util.*"  contentType="text/html;charset=gb2312"%> 
<%@ page import="com.ricardo.entity.Cchapter" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<HTML><HEAD><TITLE>�޸��½���Ϣ</TITLE>
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
/*��֤��*/
function checkForm() {
    var classNumber = document.getElementById("chapter.chapterId").value;
    if(classNumber=="") {
        alert('�������½ڱ�ţ���ʽΪ2-15,2�����¸������15����lesson15��!');
        return false;
    }
    var className = document.getElementById("chapter.chapterName").value;
    if(className=="") {
        alert('�������½�����,���Ʋ���Ϊ��!');
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
    <td align="left" vAlign=top ><s:form action="Chapter_modify" method="post" onsubmit="return checkForm();" enctype="multipart/form-data" name="form1">
<table width='100%' cellspacing='1' cellpadding='3' class="tablewidth">
  <tr>
    <td><s:textfield name="chapter.chapterId" label="�½ڱ��"/></td>
  </tr>

  <tr>

    <td><s:textfield name="chapter.chapterName" label="�½�����" /></td>
  </tr>

  <tr bgcolor='#FFFFFF'>
      <td colspan="4" align="center">
        <input type='submit' name='button' value='����' >
        &nbsp;&nbsp;
        <input type="reset" value='��д' />
      </td>
    </tr>

</table>
</s:form>
   </td></tr>
</table>
</body>
</HTML>
