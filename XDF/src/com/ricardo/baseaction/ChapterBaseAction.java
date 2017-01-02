/**
 *
 * file_name   : ChapterBaseAction.java
 * @date       : 2016年12月14日
 * @author     : Ricardo Shaw
 * @email      : ricardoshaw@qq.com
 * @changedate : 下午12:31:16
 * 
 **/
package com.ricardo.baseaction;

import com.opensymphony.xwork2.ActionSupport;
import com.ricardo.service.ChapterService;

/**
 * @author : Ricardo Shaw
 * @date   : 2016年12月14日 下午12:31:16
 */
public class ChapterBaseAction extends ActionSupport {
		protected ChapterService chapterService;

		public ChapterService getChapterService() {
			return chapterService;
		}

		public void setChapterService(ChapterService chapterService) {
			this.chapterService = chapterService;
		}
		
}
