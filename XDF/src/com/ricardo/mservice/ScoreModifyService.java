/**
 *
 * file_name   : ScoreModifyService.java
 * @date       : 2016��11��28��
 * @author     : Ricardo Shaw
 * @email      : ricardoshaw@qq.com
 * @changedate : ����3:53:15
 * 
 **/
package com.ricardo.mservice;

import com.ricardo.entity.Score;


/**
 * @author : Ricardo Shaw
 * @date   : 2016��11��28�� ����3:53:15
 */
public interface ScoreModifyService {
	
		public String addScore(Score score);
		
		public String modifyScore(Score score);
		
		public String deleteScore(Score score);
}
