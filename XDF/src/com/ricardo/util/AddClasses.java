/**
 *
 * file_name   : AddClasses.java
 * @date       : 2016年12月22日
 * @author     : Ricardo Shaw
 * @email      : ricardoshaw@qq.com
 * @changedate : 下午4:48:01
 * 
 **/
package com.ricardo.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

import com.ricardo.dao.IClDAO;
import com.ricardo.dao.impl.ClDAO;
import com.ricardo.entity.Cl;

/**
 * @author : Ricardo Shaw
 * @date   : 2016年12月22日 下午4:48:01
 */
public class AddClasses {
		public static String add(String path) {
			IClDAO iclDao = new ClDAO();
			try {
				Scanner in = new Scanner(new FileInputStream(path));
				while(in.hasNextLine()){
					String cl = in.nextLine();
					System.out.println(cl);
					String[] clinfo = cl.split("\\|");
					Cl acl = new Cl();
					acl.setClassId(clinfo[0]);
					acl.setClassName(clinfo[1]);
					acl.setClassDate(clinfo[2]);
					acl.setClassPlace(clinfo[3]);
					acl.setClassStartDate(clinfo[4]);
					acl.setClassEndDate(clinfo[5]);
					iclDao.attachDirty(acl);
				}
				return "message|批量添加成功";
			} catch (Exception e) {
				return "error|批量添加班级失败,文件没有找到";
			}
		}
}
