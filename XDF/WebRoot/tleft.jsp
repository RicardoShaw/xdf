<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.sql.*" errorPage="" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//basePath = "http://localhost:8080/SalarySystem/"
%>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
.STYLE1 {
	font-size: 12px;
	color: #FFFFFF;
}
.STYLE3 {
	font-size: 12px;
	color: #033d61;
}
-->
</style>
<style type="text/css">
.menu_title SPAN {
	FONT-WEIGHT: bold; LEFT: 3px; COLOR: #ffffff; POSITION: relative; TOP: 2px 
}
.menu_title2 SPAN {
	FONT-WEIGHT: bold; LEFT: 3px; COLOR: #FFCC00; POSITION: relative; TOP: 2px
}

</style>
<script>
//var he=document.body.clientHeight-105;
var he = document.documentElement.clientHeight;// - 105;
document.write("<div id=tt style=height:"+he+";overflow:hidden>");
</script>

<table width="165" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td height="28" background="images/main_40.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="19%">&nbsp;</td>
        <td width="81%" height="20"><span class="STYLE1">管理菜单</span></td>
      </tr>
    </table></td>
  </tr>
   
<tr>
  <td valign="top"><table width="151" border="0" align="center" cellpadding="0" cellspacing="0">
   <tr>
   <td height="23" background="images/main_47.gif" id="imgmenu1" class="menu_title" onMouseOver="this.className='menu_title2';" onClick="showsubmenu(1)" onMouseOut="this.className='menu_title';" style="cursor:hand"><table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
              <td width="18%">&nbsp;</td>
              <td width="82%" class="STYLE1">教师选课信息管理</td>
        </tr>
          </table></td>
        </tr>
        <tr>
          <td background="images/main_51.gif" id="submenu1">
		 <div class="sec_menu" >
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td><table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="16%" height="25"><div align="center"><img src="images/left.gif" width="10" height="10" /></div></td>
                  <td width="84%" height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3" onclick="javascript:parent.document.getElementById('ContentFrame').src='<%=basePath %>Tlinkc_addshow';">添加教师选课信息</span></td>
                      </tr>
                  </table></td>
                </tr>
                <tr>
                  <td height="23"><div align="center"><img src="images/left.gif" width="10" height="10" /></div></td>
                  <td height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3" onclick="javascript:parent.document.getElementById('ContentFrame').src='<%=basePath %>Tlinkc_main';" >教师选课信息管理</span></td>
                      </tr>
                  </table></td>
                </tr>
              </table></td>
            </tr>
            <tr>
              <td height="5"><img src="images/main_52.gif" width="151" height="5" /></td>
            </tr>
          </table></div></td>
        </tr>
      </table></td>
    </tr>

<tr>
  <td valign="top"><table width="151" border="0" align="center" cellpadding="0" cellspacing="0">
   <tr>
   <td height="23" background="images/main_47.gif" id="imgmenu2" class="menu_title" onMouseOver="this.className='menu_title2';" onClick="showsubmenu(2)" onMouseOut="this.className='menu_title';" style="cursor:hand"><table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
              <td width="18%">&nbsp;</td>
              <td width="82%" class="STYLE1">学生选课信息管理</td>
        </tr>
          </table></td>
        </tr>
        <tr>
          <td background="images/main_51.gif" id="submenu2">
		 <div class="sec_menu" >
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td><table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="16%" height="25"><div align="center"><img src="images/left.gif" width="10" height="10" /></div></td>
                  <td width="84%" height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3" onclick="javascript:parent.document.getElementById('ContentFrame').src='<%=basePath %>Slinkc_addshow';">添加学生选课信息</span></td>
                      </tr>
                  </table></td>
                </tr>
                <tr>
                  <td height="23"><div align="center"><img src="images/left.gif" width="10" height="10" /></div></td>
                  <td height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3" onclick="javascript:parent.document.getElementById('ContentFrame').src='<%=basePath %>Slinkc_main';" >学生选课信息管理</span></td>
                      </tr>
                  </table></td>
                </tr>
              </table></td>
            </tr>
            <tr>
              <td height="5"><img src="images/main_52.gif" width="151" height="5" /></td>
            </tr>
          </table></div></td>
        </tr>
      </table></td>
    </tr>

<tr>
  <td valign="top"><table width="151" border="0" align="center" cellpadding="0" cellspacing="0">
   <tr>
   <td height="23" background="images/main_47.gif" id="imgmenu3" class="menu_title" onMouseOver="this.className='menu_title2';" onClick="showsubmenu(3)" onMouseOut="this.className='menu_title';" style="cursor:hand"><table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
              <td width="18%">&nbsp;</td>
              <td width="82%" class="STYLE1">班级课程信息管理</td>
        </tr>
          </table></td>
        </tr>
        <tr>
          <td background="images/main_51.gif" id="submenu3">
		 <div class="sec_menu" >
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td><table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="16%" height="25"><div align="center"><img src="images/left.gif" width="10" height="10" /></div></td>
                  <td width="84%" height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3" onclick="javascript:parent.document.getElementById('ContentFrame').src='<%=basePath %>Clinkc_addshow';">添加班级课程信息</span></td>
                      </tr>
                  </table></td>
                </tr>
                <tr>
                  <td height="23"><div align="center"><img src="images/left.gif" width="10" height="10" /></div></td>
                  <td height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3" onclick="javascript:parent.document.getElementById('ContentFrame').src='<%=basePath %>Clinkc_main';" >班级课程信息管理</span></td>
                      </tr>
                  </table></td>
                </tr>
              </table></td>
            </tr>
            <tr>
              <td height="5"><img src="images/main_52.gif" width="151" height="5" /></td>
            </tr>
          </table></div></td>
        </tr>
      </table></td>
    </tr>

<tr>
  <td valign="top"><table width="151" border="0" align="center" cellpadding="0" cellspacing="0">
   <tr>
   <td height="23" background="images/main_47.gif" id="imgmenu4" class="menu_title" onMouseOver="this.className='menu_title2';" onClick="showsubmenu(4)" onMouseOut="this.className='menu_title';" style="cursor:hand"><table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
              <td width="18%">&nbsp;</td>
              <td width="82%" class="STYLE1">课程章节信息管理</td>
        </tr>
          </table></td>
        </tr>
        <tr>
          <td background="images/main_51.gif" id="submenu4">
		 <div class="sec_menu" >
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td><table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="16%" height="25"><div align="center"><img src="images/left.gif" width="10" height="10" /></div></td>
                  <td width="84%" height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3" onclick="javascript:parent.document.getElementById('ContentFrame').src='<%=basePath %>Colinkch_addshow';">添加课程章节信息</span></td>
                      </tr>
                  </table></td>
                </tr>
                <tr>
                  <td height="23"><div align="center"><img src="images/left.gif" width="10" height="10" /></div></td>
                  <td height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3" onclick="javascript:parent.document.getElementById('ContentFrame').src='<%=basePath %>Colinkch_main';" >课程章节信息管理</span></td>
                      </tr>
                  </table></td>
                </tr>
              </table></td>
            </tr>
            <tr>
              <td height="5"><img src="images/main_52.gif" width="151" height="5" /></td>
            </tr>
          </table></div></td>
        </tr>
      </table></td>
    </tr>

<tr>
  <td valign="top"><table width="151" border="0" align="center" cellpadding="0" cellspacing="0">
   <tr>
   <td height="23" background="images/main_47.gif" id="imgmenu5" class="menu_title" onMouseOver="this.className='menu_title2';" onClick="showsubmenu(5)" onMouseOut="this.className='menu_title';" style="cursor:hand"><table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
              <td width="18%">&nbsp;</td>
              <td width="82%" class="STYLE1">学生信息管理</td>
        </tr>
          </table></td>
        </tr>
        <tr>
          <td background="images/main_51.gif" id="submenu5">
		 <div class="sec_menu" >
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td><table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="16%" height="25"><div align="center"><img src="images/left.gif" width="10" height="10" /></div></td>
                  <td width="84%" height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3" onclick="javascript:parent.document.getElementById('ContentFrame').src='<%=basePath %>Student_addshow';">添加学生信息</span></td>
                      </tr>
                  </table></td>
                </tr>
                <tr>
                  <td height="23"><div align="center"><img src="images/left.gif" width="10" height="10" /></div></td>
                  <td height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3" onclick="javascript:parent.document.getElementById('ContentFrame').src='<%=basePath %>Student_main';" >学生信息管理</span></td>
                      </tr>
                  </table></td>
                </tr>
              </table></td>
            </tr>
            <tr>
              <td height="5"><img src="images/main_52.gif" width="151" height="5" /></td>
            </tr>
          </table></div></td>
        </tr>
      </table></td>
    </tr>

<tr>
  <td valign="top"><table width="151" border="0" align="center" cellpadding="0" cellspacing="0">
   <tr>
   <td height="23" background="images/main_47.gif" id="imgmenu6" class="menu_title" onMouseOver="this.className='menu_title2';" onClick="showsubmenu(6)" onMouseOut="this.className='menu_title';" style="cursor:hand"><table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
              <td width="18%">&nbsp;</td>
              <td width="82%" class="STYLE1">班级信息管理</td>
        </tr>
          </table></td>
        </tr>
        <tr>
          <td background="images/main_51.gif" id="submenu6">
		 <div class="sec_menu" >
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td><table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="16%" height="25"><div align="center"><img src="images/left.gif" width="10" height="10" /></div></td>
                  <td width="84%" height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3" onclick="javascript:parent.document.getElementById('ContentFrame').src='<%=basePath %>Class_addshow';">添加班级信息</span></td>
                      </tr>
                  </table></td>
                </tr>
                <tr>
                  <td height="23"><div align="center"><img src="images/left.gif" width="10" height="10" /></div></td>
                  <td height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3" onclick="javascript:parent.document.getElementById('ContentFrame').src='<%=basePath %>Class_main';" >班级信息管理</span></td>
                      </tr>
                  </table></td>
                </tr>
              </table></td>
            </tr>
            <tr>
              <td height="5"><img src="images/main_52.gif" width="151" height="5" /></td>
            </tr>
          </table></div></td>
        </tr>
      </table></td>
    </tr>
    
    
    <tr>
  <td valign="top"><table width="151" border="0" align="center" cellpadding="0" cellspacing="0">
   <tr>
   <td height="23" background="images/main_47.gif" id="imgmenu7" class="menu_title" onMouseOver="this.className='menu_title2';" onClick="showsubmenu(7)" onMouseOut="this.className='menu_title';" style="cursor:hand"><table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
              <td width="18%">&nbsp;</td>
              <td width="82%" class="STYLE1">课程信息管理</td>
        </tr>
          </table></td>
        </tr>
        <tr>
          <td background="images/main_51.gif" id="submenu7">
		 <div class="sec_menu" >
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td><table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="16%" height="25"><div align="center"><img src="images/left.gif" width="10" height="10" /></div></td>
                  <td width="84%" height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3" onclick="javascript:parent.document.getElementById('ContentFrame').src='<%=basePath %>Course_addshow';">添加课程信息</span></td>
                      </tr>
                  </table></td>
                </tr>
                <tr>
                  <td height="23"><div align="center"><img src="images/left.gif" width="10" height="10" /></div></td>
                  <td height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3" onclick="javascript:parent.document.getElementById('ContentFrame').src='<%=basePath %>Course_main';" >课程信息管理</span></td>
                      </tr>
                  </table></td>
                </tr>
              </table></td>
            </tr>
            <tr>
              <td height="5"><img src="images/main_52.gif" width="151" height="5" /></td>
            </tr>
          </table></div></td>
        </tr>
      </table></td>
    </tr>
    
    
    
        <tr>
  <td valign="top"><table width="151" border="0" align="center" cellpadding="0" cellspacing="0">
   <tr>
   <td height="23" background="images/main_47.gif" id="imgmenu15" class="menu_title" onMouseOver="this.className='menu_title2';" onClick="showsubmenu(15)" onMouseOut="this.className='menu_title';" style="cursor:hand"><table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
              <td width="18%">&nbsp;</td>
              <td width="82%" class="STYLE1">章节信息管理</td>
        </tr>
          </table></td>
        </tr>
        <tr>
          <td background="images/main_51.gif" id="submenu15">
		 <div class="sec_menu" >
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td><table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="16%" height="25"><div align="center"><img src="images/left.gif" width="10" height="10" /></div></td>
                  <td width="84%" height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3" onclick="javascript:parent.document.getElementById('ContentFrame').src='<%=basePath %>Chapter_addshow';">添加章节信息</span></td>
                      </tr>
                  </table></td>
                </tr>
                <tr>
                  <td height="23"><div align="center"><img src="images/left.gif" width="10" height="10" /></div></td>
                  <td height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3" onclick="javascript:parent.document.getElementById('ContentFrame').src='<%=basePath %>Chapter_main';" >章节信息管理</span></td>
                      </tr>
                  </table></td>
                </tr>
              </table></td>
            </tr>
            <tr>
              <td height="5"><img src="images/main_52.gif" width="151" height="5" /></td>
            </tr>
          </table></div></td>
        </tr>
      </table></td>
    </tr>
    
    


<tr>
  <td valign="top"><table width="151" border="0" align="center" cellpadding="0" cellspacing="0">
   <tr>
   <td height="23" background="images/main_47.gif" id="imgmenu8" class="menu_title" onMouseOver="this.className='menu_title2';" onClick="showsubmenu(8)" onMouseOut="this.className='menu_title';" style="cursor:hand"><table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
              <td width="18%">&nbsp;</td>
              <td width="82%" class="STYLE1">成绩信息管理</td>
        </tr>
          </table></td>
        </tr>
        <tr>
          <td background="images/main_51.gif" id="submenu8">
		 <div class="sec_menu" >
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td><table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="16%" height="25"><div align="center"><img src="images/left.gif" width="10" height="10" /></div></td>
                  <td width="84%" height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3" onclick="javascript:parent.document.getElementById('ContentFrame').src='<%=basePath %>Score_addshow';">添加成绩信息</span></td>
                      </tr>
                  </table></td>
                </tr>
                <tr>
                  <td height="23"><div align="center"><img src="images/left.gif" width="10" height="10" /></div></td>
                  <td height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3" onclick="javascript:parent.document.getElementById('ContentFrame').src='<%=basePath %>Score_main';" >成绩信息管理</span></td>
                      </tr>
                  </table></td>
                </tr>
              </table></td>
            </tr>
            <tr>
              <td height="5"><img src="images/main_52.gif" width="151" height="5" /></td>
            </tr>
          </table></div></td>
        </tr>
      </table></td>
    </tr>


      
<tr>
  <td valign="top"><table width="151" border="0" align="center" cellpadding="0" cellspacing="0">
   <tr>
   <td height="23" background="images/main_47.gif" id="imgmenu500" class="menu_title" onMouseOver="this.className='menu_title2';" onClick="showsubmenu(500)" onMouseOut="this.className='menu_title';" style="cursor:hand"><table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr>
              <td width="18%">&nbsp;</td>
              <td width="82%" class="STYLE1">个人信息管理</td>
        </tr>
          </table></td>
        </tr>
        <tr>
          <td background="images/main_51.gif" id="submenu500">
		 <div class="sec_menu" >
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td><table width="90%" border="0" align="center" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="16%" height="25"><div align="center"><img src="images/left.gif" width="10" height="10" /></div></td>
                  <td width="84%" height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3" onclick="javascript:parent.document.getElementById('ContentFrame').src='<%=basePath %>Teacher_modifyshow?username=<s:property value="#session.username"/>';">修改用户密码</span></td>
                      </tr>
                  </table></td>
                </tr>
                <tr>
                  <td height="23"><div align="center"><img src="images/left.gif" width="10" height="10" /></div></td>
                  <td height="23"><table width="95%" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td height="20" style="cursor:hand" onmouseover="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#7bc4d3'; "onmouseout="this.style.borderStyle='none'"><span class="STYLE3" onclick="javascript:parent.document.getElementById('ContentFrame').src='<%=basePath %>Loginout_loginout';" >退出当前系统</span></td>
                      </tr>
                  </table></td>
                </tr>
              </table></td>
            </tr>
            <tr>
              <td height="5"><img src="images/main_52.gif" width="151" height="5" /></td>
            </tr>
          </table></div></td>
        </tr>
      </table></td>
    </tr>
  <tr>
    <td height="18" background="images/main_58.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td height="18" valign="bottom"><div align="center" class="STYLE3">版本：2016V1.0</div></td>
      </tr>
    </table></td>
  </tr>
</table>
<script>




function showsubmenu(sid)
{
whichEl = eval("submenu" + sid);
imgmenu = eval("imgmenu" + sid);
if (whichEl.style.display == "none")
{
eval("submenu" + sid + ".style.display=\"\";");
imgmenu.background="images/main_47.gif";
}
else
{
eval("submenu" + sid + ".style.display=\"none\";");
imgmenu.background="images/main_48.gif";
}
}

</script>
