package com.et.lesson03.resultMap.xml;

import java.util.List;

/**
 * 接口
 * @author Administrator
 *
 */
public interface GradeMapper {
	/**
	 * 查询所有的班级
	 * @param 
	 * @return
	 */
	public List queryAllGrade();
	
	/**
	 * 通过id查找所有的班级
	 * 一对多
	 * @param gid
	 * @return
	 */
	public Grade queryGrade(String gid);
	
}
