<%@ page language="java" import="java.util.*" contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>学生信息查询</title>
<link href="<%=basePath %>css/desk.css" rel="stylesheet" type="text/css"> 

  </head>
  
  <body>
  <table  >
    <tr><td><lable>学生编号：</lable><s:property value="student.studentId" /></td>
  </tr>

  <tr>
   			<td><lable>学生姓名：</lable><s:property value="student.studentName"/></td>
  </tr>

<tr>
   <td>学生课程章节成绩:</td>
    </tr>
    
    <tr>
      <td>&nbsp;班级名称&nbsp;&nbsp;</td>
     <td>&nbsp;课程名称&nbsp;&nbsp;</td>
     <td>&nbsp;章节名称&nbsp;&nbsp;</td>
     <td>&nbsp;作业成绩&nbsp;&nbsp;</td>
     <td>&nbsp;听写成绩&nbsp;&nbsp;</td>
    </tr>
   <s:iterator value="sscores" status="index" id="score">
   <tr>
    <td><s:property value="#score.cl.className"/></td>
     <td><s:property value="#score.courseName"/></td>
     <td><s:property value="#score.chapterName"/></td>
     <td><s:property value="#score.hwscore"/></td>
     <td><s:property value="#score.dtscore"/></td>
   </tr>
   </s:iterator>


  <tr>
      <td colspan="4" align="center">
        <input type="button" value="返回" onclick="history.back();"/>
      </td>
    </tr>
  
  </table>

	
	
	
  </body>
</html>
