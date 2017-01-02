<%@ page language="java" import="java.util.*"  contentType="text/html;charset=UTF-8"%> 
<%@ page import="com.ricardo.entity.*" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
         int  i=0;
     List<Cl> cles = (List<Cl>)request.getAttribute("cles");
     int totalPage = (int)request.getAttribute("totalPage");
     int currentPage = (int)request.getAttribute("currentPage");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>分数信息查询</title>
<style type="text/css">
<!--
body {
    margin-left: 0px;
    margin-top: 0px;
    margin-right: 0px;
    margin-bottom: 0px;
}
.STYLE1 {font-size: 12px}
.STYLE3 {font-size: 12px; font-weight: bold; }
.STYLE4 {
    color: #03515d;
    font-size: 12px;
}
-->
</style>

 <script src="<%=basePath %>calendar.js"></script>
 <script src="<%=basePath %>liandong.js"></script>
<script language="javascript">
var  highlightcolor='#c1ebff';
//此处clickcolor只能用win系统颜色代码才能成功,如果用#xxxxxx的代码就不行,还没搞清楚为什么:(
var  clickcolor='#51b2f6';

function  changeto(){
source=event.srcElement;
if  (source.tagName=="TR"||source.tagName=="TABLE")
return;
while(source.tagName!="TD")
source=source.parentElement;
source=source.parentElement;
cs  =  source.children;
//alert(cs.length);
if  (cs[1].style.backgroundColor!=clickcolor&&source.id!="nc")
for(i=0;i<cs.length;i++){
    cs[i].style.backgroundColor=clickcolor;
}
else
for(i=0;i<cs.length;i++){
    cs[i].style.backgroundColor="";
}
}

function  changeback(){
if  (event.fromElement.contains(event.toElement)||source.contains(event.toElement)||source.id=="nc")
return
if  (event.toElement!=source&&cs[1].style.backgroundColor!=clickcolor)
//source.style.backgroundColor=originalcolor
for(i=0;i<cs.length;i++){
	cs[i].style.backgroundColor="";
}
}

/*跳转到查询结果的某页*/
function GoToPage(page,totalPage) {
    if(page>totalPage || page <= 0 ) return;
    document.scorehqueryform.currentPage.value = page;
    document.scorehqueryform.submit();
}

function changepage(totalPage)
{
    var pageValue=document.bookQueryForm.pageValue.value;
    if(pageValue>totalPage) {
        alert('你输入的页码超出了总页数!');
        return ;
    }
    document.scorehqueryform.currentPage.value = pageValue;
    document.scorehqueryform.submit();
}

</script>


</head>

<body>
<s:form action="Score_Hquery" theme="simple" name="scorehqueryform">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr>
    <td height="30" background="<%=basePath %>images/tab_05.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="12" height="30"><img src="<%=basePath %>images/tab_03.gif" width="12" height="30" /></td>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="46%" valign="middle"><table width="100%" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="5%"><div align="center"><img src="<%=basePath %>images/tb.gif" width="16" height="16" /></div></td>
                <td width="95%" class="STYLE1"><span class="STYLE3">你当前的位置</span>：[分数信息管理]-[分数信息查询]</td>
              </tr>
            </table></td>
            <td width="54%"><table border="0" align="right" cellpadding="0" cellspacing="0">

            </table></td>
          </tr>
        </table></td>
        <td width="16"><img src="<%=basePath %>images/tab_07.gif" width="16" height="30" /></td>
      </tr>
    </table></td>
  </tr>


  <tr>
  <td bgcolor="#FFFFFF">
  <label>&nbsp;学生姓名：</label><s:textfield name="studentName" />
  <br />
  <label>&nbsp;班级名称：</label><SELECT id="s1" name="classId" ><OPTION selected></OPTION> </SELECT>
  <label>课程名称：</label><SELECT id="s2" name="courseName" ><OPTION selected></OPTION></SELECT>
  <label>章节名称：</label><SELECT id="s3" name="chapterName"><OPTION selected></OPTION></SELECT>
<input type=hidden name=currentPage value="1" />
<s:submit value="确认查询" theme="simple"/>
  </td>
</tr>
  <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="8" background="<%=basePath %>images/tab_12.gif">&nbsp;</td>
        <td><table width="100%" border="0" cellpadding="0" cellspacing="1" bgcolor="b5d6e6" onmouseover="changeto()"  onmouseout="changeback()">
          <tr>
            <td  height="22" background="<%=basePath %>images/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">成绩编号</span></div></td>
            <td  height="22" background="<%=basePath %>images/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">学生名称</span></div></td>
            <td  height="22" background="<%=basePath %>images/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">班级名称</span></div></td>
            <td  height="22" background="<%=basePath %>images/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">课程名称</span></div></td>
            <td  height="22" background="<%=basePath %>images/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">章节名称</span></div></td>
            <td  height="22" background="<%=basePath %>images/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">作业成绩</span></div></td>
            <td  height="22" background="<%=basePath %>images/bg.gif" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1">听写成绩</span></div></td>
          </tr>
           <s:iterator value="scores" id="score" status="index" >
          <tr>
            <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1"><s:property value="#score.id"/></span></div></td>
            <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1"><s:property value="#score.student.studentName"/></span></div></td>
             <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1"><s:property value="#score.cl.className"/></span></div></td>
             <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1"><s:property value="#score.courseName"/></span></div></td>
             <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1"><s:property value="#score.chapterName"/></span></div></td>
              <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1"><s:property value="#score.hwscore"/></span></div></td>
               <td height="20" bgcolor="#FFFFFF"><div align="center"><span class="STYLE1"><s:property value="#score.dtscore"/></span></div></td> 
          </tr>
          </s:iterator>
        </table></td>
        <td width="8" background="images/tab_15.gif">&nbsp;</td>
      </tr>
    </table></td>
  </tr>



       <tr>
    <td height="35" background="<%=basePath %>images/tab_19.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="12" height="35"><img src="<%=basePath %>images/tab_18.gif" width="12" height="35" /></td>
        <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td class="STYLE4">&nbsp;&nbsp;当前第 <%=currentPage %>/<%=totalPage %> 页</td>
            <td><table border="0" align="right" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="40"><img src="<%=basePath %>images/first.gif" width="37" height="15" style="cursor:hand;" onclick="GoToPage(1,<%=totalPage %>);" /></td>
                  <td width="45"><img src="<%=basePath %>images/back.gif" width="43" height="15" style="cursor:hand;" onclick="GoToPage(<%=currentPage-1 %>,<%=totalPage %>);"/></td>
                  <td width="45"><img src="<%=basePath %>images/next.gif" width="43" height="15" style="cursor:hand;" onclick="GoToPage(<%=currentPage+1 %>,<%=totalPage %>);" /></td>
                  <td width="40"><img src="<%=basePath %>images/last.gif" width="37" height="15" style="cursor:hand;" onclick="GoToPage(<%=totalPage %>,<%=totalPage %>);"/></td>
                  <td width="100"><div align="center"><span class="STYLE1">转到第
                    <input name="pageValue" type="text" size="4" style="height:12px; width:20px; border:1px solid #999999;" />
                    页 </span></div></td>
                  <td width="40"><img src="<%=basePath %>images/go.gif" onclick="changepage(<%=totalPage %>);" width="37" height="15" /></td>
                </tr>
            </table></td>
          </tr>
        </table></td>
        <td width="16"><img src="<%=basePath %>images/tab_20.gif" width="16" height="35" /></td>
      </tr>
    </table>
    </td>
  </tr>



</table>
  </s:form>
</body>



<script language="javascript">
    //例子1-------------------------------------------------------------
  //数据源
  var array=new Array();
  
  <% 

    for(Cl cl:cles){
  %>
  array[<%=i%>] = new Array("根目录","班级","<%=cl.getClassId()%>","<%=cl.getClassName()%>")
  <%
  i++;
  Set<Clinkc> clinkcs = cl.getClinkcs();
  for(Clinkc clinkc:clinkcs){
    Course course = clinkc.getCourse();
  %>
  array[<%=i%>] = new Array("<%=cl.getClassId()%>","课程","<%=course.getCourseName()%>","<%=course.getCourseName()%>")
  <%
  i++;
  Set<Colinkch> colinkchs = course.getColinkchs();
    for(Colinkch colinkch : colinkchs){
      Cchapter chapter = colinkch.getCchapter();
  %>
  array[<%=i%>] = new Array("<%=course.getCourseName()%>","章节","<%=chapter.getChapterName()%>","<%=chapter.getChapterName()%>")
  
  <%
  i++;
  }//end for(Colinkch)
  }//end for(Clinkc)
  
  }//end for(cles)
  
 
  %>

  //--------------------------------------------
  //这是调用代码
  var liandong=new CLASS_LIANDONG_YAO(array) //设置数据源
  liandong.firstSelectChange("根目录","班级","s1"); //设置第一个选择框
  liandong.subSelectChange("s1","课程","s2"); //设置子级选择框
  liandong.subSelectChange("s2","章节","s3");
</script>

</html>