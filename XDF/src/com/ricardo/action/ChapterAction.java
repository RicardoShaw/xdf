/**
 *
 * file_name   : ChapterAction.java
 * @date       : 2016年12月14日
 * @author     : Ricardo Shaw
 * @email      : ricardoshaw@qq.com
 * @changedate : 下午12:32:13
 * 
 **/
package com.ricardo.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.ricardo.baseaction.ChapterBaseAction;
import com.ricardo.entity.Cchapter;

/**
 * @author : Ricardo Shaw
 * @date   : 2016年12月14日 下午12:32:13
 */
public class ChapterAction extends ChapterBaseAction {

		private static final long serialVersionUID = -8273404868467414130L;
			
			
			private String tip;
			
			private int currentPage;
			private int totalPage;
			
			private Cchapter chapter;
			private String chapterId;

			private List<Cchapter> chapters;

			public Cchapter getChapter() {
				return chapter;
			}

			public void setChapter(Cchapter chapter) {
				this.chapter = chapter;
			}

			public String getTip() {
				return tip;
			}

			public void setTip(String tip) {
				this.tip = tip;
			}
			
			public String getChapterId() {
				return chapterId;
			}

			public void setChapterId(String chapterId) {
				this.chapterId = chapterId;
			}

			public int getTotalPage() {
				return totalPage;
			}

			public void setTotalPage(int totalPage) {
				this.totalPage = totalPage;
			}

			

			public int getCurrentPage() {
				return currentPage;
			}

			public void setCurrentPage(int currentPage) {
				this.currentPage = currentPage;
			}

			public List<Cchapter> getChapters() {
				return chapters;
			}

			public void setChapters(List<Cchapter> chapters) {
				this.chapters = chapters;
			}
			

			public String main(){
				return "main";
			}
			public String Hmain(){
				return "Hmain";
			}
			
			

			public String Hquery(){
				if(currentPage == 0 ) {setCurrentPage(1);}
				if(totalPage == 0){setTotalPage(1);}
				String chapterId = chapter.getChapterId();
				String chapterName = chapter.getChapterName();
				setTotalPage(chapterService.getMaxPage(chapterId, chapterName));
				List<Cchapter> chapterlist=chapterService.findByChIdChN(chapterId, chapterName,currentPage);
				setChapters(chapterlist);
				return "Hquery_view";
			}
			
			public String query(){
				if(currentPage == 0 ) {setCurrentPage(1);}
				if(totalPage == 0){setTotalPage(1);}
				System.out.println("Chapter_query"+currentPage);
				System.out.println(totalPage);
				String chapterId = chapter.getChapterId();
				String chapterName = chapter.getChapterName();
				setTotalPage(chapterService.getMaxPage(chapterId,
							chapterName));
				List<Cchapter> chapterlist = chapterService.findByChIdChN(
							chapterId, chapterName, currentPage);
				setChapters(chapterlist);
				System.out.println("Chapter_query"+currentPage);
				System.out.println(totalPage);
				return "query_view";
			}
			
			public String addshow(){
				return "addshow_view";
			}
			
			public String add(){
				ActionContext ctx = ActionContext.getContext();
				String message = chapterService.addChapter(chapter);
				String[]	 s1 = message.split("\\|");
				if("message".equalsIgnoreCase(s1[0])){
					ctx.getSession().put(s1[0],s1[1]);
					return "message";
				}else{
					ctx.getSession().put(s1[0],s1[1]);
					return "error";
				}

			}
			
			public String modifyshow(){
				setChapter( chapterService.findByChId(chapterId));
				return "modifyshow_view";
			}
			
			public String modify(){
				ActionContext ctx = ActionContext.getContext();
				String message = chapterService.modifyChapter(chapter);
				String[]	 s1 = message.split("\\|");
				if("message".equalsIgnoreCase(s1[0])){
					ctx.getSession().put(s1[0],s1[1]);
					return "message";
				}else{
					ctx.getSession().put(s1[0],s1[1]);
					return "error";
				}
			}
			
			public String delete(){
				ActionContext ctx = ActionContext.getContext();
				Cchapter cchapter = chapterService.findByChId(chapterId);
				String message = chapterService.deleteChapter(cchapter);
				String[]	 s1 = message.split("\\|");
				if("message".equalsIgnoreCase(s1[0])){
					ctx.getSession().put(s1[0],s1[1]);
					return "message";
				}else{
					ctx.getSession().put(s1[0],s1[1]);
					return "error";
				}
			}
			
}
