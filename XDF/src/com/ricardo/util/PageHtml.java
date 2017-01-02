 package com.ricardo.util;

public class PageHtml {
 
			
	public static String Control(int page, int count,String action) {
				
				String strHtml = "";

				if (page >= 1) {
						strHtml += "<div class=\"pagination\">";
						strHtml += "<a href=\""+action+"?currentPage=1\" title=\"First Page\">&laquo; 第一页</a>";
						
					}
					
					
		 				
				if(count==1){
					strHtml += "<a href=\""+action+"?currentPage=1\" title=\"Previous Page\">&laquo; 上一页</a> ";
					strHtml += "<a href=\""+action+"?currentPage=1\" class=\"number current\" title=\"1\">1</a>";
					strHtml += "<a href=\""+action+"?currentPage=1\" title=\"Next Page\">下一页 &raquo;</a>";
				}
				
				
				
				if (count ==2&&page==1){
					
					strHtml += "<a href=\""+action+"?currentPage=1\" title=\"Previous Page\">&laquo; 上一页</a> ";
					strHtml += "<a href=\""+action+"?currentPage=1\" class=\"number current\" title=\"1\">1</a>";
					strHtml += "<a href=\""+action+"?currentPage=2\" class=\"number\" title=\"2\">2</a>";
					strHtml += "<a href=\""+action+"?currentPage=2\" title=\"Next Page\">下一页 &raquo;</a>";
					
				}
				
				
				if (count ==2&&page==2){
					
					strHtml += "<a href=\""+action+"?currentPage=1\" title=\"Previous Page\">&laquo; 上一页</a> ";
					strHtml += "<a href=\""+action+"?currentPage=1\" class=\"number\" title=\"1\">1</a>";
					strHtml += "<a href=\""+action+"?currentPage=2\" class=\"number current\" title=\"2\">2</a>";
					strHtml += "<a href=\""+action+"?currentPage=2\" title=\"Next Page\">下一页 &raquo;</a>";

				}
				

				
				if (count ==3&&page==1){
					
					strHtml += "<a href=\""+action+"?currentPage=1\" title=\"Previous Page\">&laquo; 上一页</a> ";
					strHtml += "<a href=\""+action+"?currentPage=1\" class=\"number current\" title=\"1\">1</a>";
					strHtml += "<a href=\""+action+"?currentPage=2\" class=\"number\" title=\"2\">2</a>";
					strHtml += "<a href=\""+action+"?currentPage=3\" class=\"number\" title=\"3\">3</a> ";
					strHtml += "<a href=\""+action+"?currentPage=2\" title=\"Next Page\">下一页 &raquo;</a>";
					
				}
				
				
				if (count ==3&&page==2){
					
					strHtml += "<a href=\""+action+"?currentPage=2\" title=\"Previous Page\">&laquo; 上一页</a> ";
					strHtml += "<a href=\""+action+"?currentPage=1\" class=\"number\" title=\"1\">1</a>";
					strHtml += "<a href=\""+action+"?currentPage=2\" class=\"number current\" title=\"2\">2</a>";
					strHtml += "<a href=\""+action+"?currentPage=3\" class=\"number\" title=\"3\">3</a>";
					strHtml += "<a href=\""+action+"?currentPage=3\" title=\"Next Page\">下一页 &raquo;</a>";

				}
				
				
				if (count ==3&&page==3){
					
					strHtml += "<a href=\""+action+"?currentPage=2\" title=\"Previous Page\">&laquo; 上一页</a> ";
					strHtml += "<a href=\""+action+"?currentPage=1\" class=\"number\" title=\"1\">1</a>";
					strHtml += "<a href=\""+action+"?currentPage=2\" class=\"number\" title=\"2\">2</a>";
					strHtml += "<a href=\""+action+"?currentPage=3\" class=\"number current\" title=\"3\">3</a>";
					strHtml += "<a href=\""+action+"?currentPage=3\" title=\"Next Page\">下一页 &raquo;</a>";

				}

	 	
				
		       if(count>3&&page==1){
					
		    	   strHtml += "<a href=\""+action+"?currentPage=1\" title=\"Previous Page\">&laquo; 上一页</a> ";
					strHtml += "<a href=\""+action+"?currentPage=1\" class=\"number current \" title=\"1\">1</a>";
					strHtml += "<a href=\""+action+"?currentPage=2\" class=\"number\" title=\"2\">2</a>";
					strHtml += "<a href=\""+action+"?currentPage=3\" class=\"number\" title=\"3\">3</a>";
	                strHtml += " " + " ... ";
	                strHtml += "<a href=\""+action+"?currentPage=" +count+ "\" class=\"number \" title=\"3\">" +count+ "</a>";
	                strHtml += "<a href=\""+action+"?currentPage=2\" title=\"Next Page\">下一页 &raquo;</a>";
					
				}
		
				
				if(count>3&&page==2){
					
					strHtml += "<a href=\""+action+"?currentPage=1\" title=\"Previous Page\">&laquo; 上一页</a> ";
					strHtml += "<a href=\""+action+"?currentPage=1\" class=\"number\" title=\"1\">1</a>";
	                strHtml += "<a href=\""+action+"?currentPage=2\" class=\"number current\" title=\"2\">2</a>";
	                strHtml += "<a href=\""+action+"?currentPage=3\" class=\"number\" title=\"3\">3</a>";
	                strHtml += " " + " ... ";
	                strHtml += "<a href=\""+action+"?currentPage=" +count+ "\" class=\"number \" title=\"3\">" +count+ "</a>";
	                strHtml += "<a href=\""+action+"?currentPage=3\" title=\"Next Page\">下一页 &raquo;</a>";
					
				}
				
				
				if(count>3&&page==3){
					
					strHtml += "<a href=\""+action+"?currentPage=2\" title=\"Previous Page\">&laquo; 上一页</a> ";
					strHtml += "<a href=\""+action+"?currentPage=1\" class=\"number\" title=\"1\">1</a>";
					strHtml += "<a href=\""+action+"?currentPage=2\" class=\"number\" title=\"2\">2</a>";
	                strHtml += "<a href=\""+action+"?currentPage=3\" class=\"number current \" title=\"3\">3</a>";
	               strHtml  += " " + " ... ";
	               strHtml  += "<a href=\""+action+"?currentPage=" +count+ "\" class=\"number \" title=\"3\">" +count+ "</a>";
	               strHtml  += "<a href=\""+action+"?currentPage=4\" title=\"Next Page\">下一页 &raquo;</a>";
					
				}
				
				
				
				if(count>3&&page>3&&page<count-2){
					
					int a = page -1;
					int b = page +1;
					
		
					strHtml += "<a href=\""+action+"?currentPage=" +a+ "\" title=\"Previous Page\">&laquo; 上一页</a> ";
					strHtml += "<a href=\""+action+"?currentPage=1\" class=\"number \" title=\"1\">1</a>";
					strHtml += " " + " ... ";
					strHtml += "<a href=\""+action+"?currentPage=" +a+ "\" class=\"number\" title=\"2\">" +a+ "</a>";
	                strHtml += "<a href=\""+action+"?currentPage=" +page+ "\" class=\"number current \" title=\"2\">" +page+ "</a>";
	                strHtml += "<a href=\""+action+"?currentPage=" +b+ "\" class=\"number\" title=\"2\">" +b+ "</a>";
	                strHtml += " " + " ... ";
	                strHtml += "<a href=\""+action+"?currentPage=" +count+ "\" class=\"number\" title=\"3\">" +count+ "</a>";
	                strHtml += "<a href=\""+action+"?currentPage=" +b+ "\" title=\"Next Page\">下一页 &raquo;</a>";
					
				}
			
				
				
				if(count>3&&page==count){

					int c=count -2;
					int d=count -1;
					
					strHtml += "<a href=\""+action+"?currentPage=" +d+ "\" title=\"Previous Page\">&laquo; 上一页</a> ";
					strHtml += "<a href=\""+action+"?currentPage=1\" class=\"number\" title=\"1\">1</a>";
					strHtml += " " + " ... ";
					strHtml += "<a href=\""+action+"?currentPage=" +c+ "\" class=\"number\" title=\"2\">" +c+ "</a>";
					strHtml += "<a href=\""+action+"?currentPage=" +d+ "\" class=\"number\" title=\"2\">" +d+ "</a>";
	                strHtml += "<a href=\""+action+"?currentPage=" +count+ "\" class=\"number current \" title=\"3\">" +count+ "</a>";
	                strHtml += "<a href=\""+action+"?currentPage=" +count+ "\" title=\"Next Page\">下一页 &raquo;</a>";
					
	 
					
				}
				
				
				if(count>3&&page==count-1){

					int e=count -2;
					int f=count -1;
					
					strHtml += "<a href=\""+action+"?currentPage=" +e+ "\" title=\"Previous Page\">&laquo; 上一页</a> ";
					strHtml += "<a href=\""+action+"?currentPage=1\" class=\"number\" title=\"1\">1</a>";
					strHtml += " " + " ... ";	
					strHtml += "<a href=\""+action+"?currentPage=" +e+ "\" class=\"number\" title=\"2\">" +e+ "</a>";
	                strHtml += "<a href=\""+action+"?currentPage=" +f+ "\" class=\"number current\" title=\"2\">" +f+ "</a>";
	                strHtml += "<a href=\""+action+"?currentPage=" +count+ "\" class=\"number\" title=\"3\">" +count+ "</a>";
	                strHtml += "<a href=\""+action+"?currentPage=" +count+ "\" title=\"Next Page\">下一页 &raquo;</a>";
				
					
				}
				
				if(count>3&&page==count-2){

					int e=count -2;
					int f=count -1;
					int g=count-3;
					
					strHtml += "<a href=\""+action+"?currentPage=" +g+ "\" title=\"Previous Page\">&laquo; 上一页</a> ";
					strHtml += "<a href=\""+action+"?currentPage=1\" class=\"number\" title=\"1\">1</a>";
					strHtml += " " + " ... ";		
	                strHtml += "<a href=\""+action+"?currentPage=" +e+ "\" class=\"number current\" title=\"3\">" +e+ "</a>";
	                strHtml += "<a href=\""+action+"?currentPage=" +f+ "\" class=\"number\" title=\"3\">" +f+ "</a>";
	                strHtml += "<a href=\""+action+"?currentPage=" +count+ "\" class=\"number\" title=\"3\">" +count+ "</a>";
	                strHtml += "<a href=\""+action+"?currentPage=" +f+ "\" title=\"Next Page\">下一页 &raquo;</a>";
				
					
				}
				
				
			 
				
				
				
					
				if (page <= count) {
					
					strHtml += "<a href=\""+action+"?currentPage="+count+"\" title=\"Last Page\">最后一页 &raquo;</a>" ;
					strHtml += "</div>" ;
				}
 			
					return strHtml; 	
				
				}
			
			
			
	 			
				
//			  <div class="pagination"> 
//			    <a href=""+action+"?currentPage=firstpage" title="First Page">&laquo; 第一页</a>
//				<a href="#" title="Previous Page">&laquo; 上一页</a> 
//				<a href="#" class="number current" title="1">1</a> 
//				<a href="#" class="number" title="2">2</a> 
//				<a href="#" title="Next Page">下一页 &raquo;</a>
//				<a href=""+action+"?currentPage=lastpage" title="Last Page">最后一页 &raquo;</a> 
//			 </div>				
			
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
