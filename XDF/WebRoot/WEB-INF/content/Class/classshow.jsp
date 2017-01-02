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
<title>班级信息查询</title>
<link href="<%=basePath %>css/desk.css" rel="stylesheet" type="text/css" /> 

  </head>
  
  <body>
  <table  >
    <tr><td>班级编号：<s:property value="cl.classId" /></td>
  </tr>

  <tr>
   			<td>班级名称：<s:property value="cl.className"/></td>
  </tr>

<tr>
   <td>班级课程章节:</td>
    </tr>
   	<s:iterator value="cl.clinkcs"  status="index" id="clinkc">
   	 	<td><s:property  value="#clinkc.course.courseId"/></td>
   		<s:iterator value="#clinkc.course.colinkchs" status="index" id="colinkch">
   		   	<tr>
   		   <td><s:property  value="#colinkch.cchapter.chapterId"/></td>
   		   <td><s:property  value="#colinkch.cchapter.chapterName"/></td>
			</tr>
   		
   		</s:iterator>
	</s:iterator>



  <tr>
   <td>班级学生:</td>
    </tr>
    <tr>
    <table>
   	<s:iterator value="cl.slinkcs"  status="index" id="slinkc">
   	<tr>
	<td><s:property value="#slinkc.student.studentId" /></td>
	<td><s:property value="#slinkc.student.studentName" /></td>
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
