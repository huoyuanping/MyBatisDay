package com.et.lesson03.resultMap.xml;







/**
 *多对一
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
