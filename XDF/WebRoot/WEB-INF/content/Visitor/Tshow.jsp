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
<title>教师信息查询</title>
<link href="<%=basePath %>css/desk.css" rel="stylesheet" type="text/css"> 

  </head>
  
  <body>
  <table  >
    <tr><td><lable>老师编号：</lable><s:property value="teacher.username" /></td>
  </tr>

  <tr>
   			<td><lable>老师姓名：</lable><s:property value="teacher.teacherName"/></td>
  </tr>


  <tr>
   <td>所带班级:</td>
    </tr>
    <tr>
    <table>
    <tr>
    <td></td>
    
    </tr>
   	<s:iterator value="stlinkcs"  status="index" id="tlinkc">
   	<tr>
	<td><s:property value="#tlinkc.cl.classId" /></td>
	<td><s:property value="#tlinkc.cl.className" /></td>
	<td><s:property value="#tlinkc.cl.classStartDate" /></td>
	<td><s:property value="#tlinkc.cl.classEndDate" /></td>
	</tr>
	</s:iterator>
  </table>
  </tr>

  <tr>
      <td colspan="4" align="center">
        <input type="button" value="返回" onclick="history.back();"/>
      </td>
    </tr>
  
  </table>

	
	
	
  </body>
</html>
