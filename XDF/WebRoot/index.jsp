<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
<title>新东方XX老师-首页</title>
<link href="<%=basePath %>css/index.css" rel="stylesheet" type="text/css" />
 </head>
<body>
<div id="container">
	<div id="banner"><img src="<%=basePath %>images/logo.gif" /></div>
	<div id="globallink" background-size:100%>
		<ul>
			<li><a href="<%=basePath %>index.jsp">首页</a></li>
			<li><a href="Teacher_Hmain" target="OfficeMain">教师信息</a></li> 
			<li><a href="Tlinkc_Hmain" target="OfficeMain">班级信息</a></li> 
			<li><a href="Student_Hmain" target="OfficeMain">学生信息</a></li>  
			<li><a href="Score_Hmain" target="OfficeMain">成绩信息</a></li> 
		</ul>
		<br />
	</div> 
	<div id="main">
	 <iframe id="frame1" src="<%=basePath %>desk.jsp" name="OfficeMain" width="100%" height="100%" scrolling="yes" marginwidth=0 marginheight=0 frameborder=0 vspace=0 hspace=0 >
	 </iframe>
	</div>
	<div id="footer">
		<p><!--  段小川 QQ:317061512 手机:18086665256 &copy;版权所有 --> <a href="Teacher_login"><font color=red>后台登陆</font></a></p>
	</div>
</div>
</body>
</html>
