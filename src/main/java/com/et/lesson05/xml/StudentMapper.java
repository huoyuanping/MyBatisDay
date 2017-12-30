package com.et.lesson05.xml;


/**
 * @author Administrator
 *
 */
public interface StudentMapper {
	/**
	 * 通过编号查询学生
	 * @param 
	 * @return
	 */
	public Student queryStudentById(String sid);

}
