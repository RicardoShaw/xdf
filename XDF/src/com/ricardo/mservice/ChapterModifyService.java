/**
 *
 * file_name   : ChapterModifyService.java
 * @date       : 2016��11��28��
 * @author     : Ricardo Shaw
 * @email      : ricardoshaw@qq.com
 * @changedate : ����3:45:38
 * 
 **/
package com.ricardo.mservice;

import com.ricardo.entity.Cchapter;


/**
 * @author : Ricardo Shaw
 * @date   : 2016��11��28�� ����3:45:38
 */
public interface ChapterModifyService {
		
	public String addChapter(Cchapter chapter);
	public String deleteChapter(Cchapter chapter);
	public String modifyChapter(Cchapter chapter);
}
