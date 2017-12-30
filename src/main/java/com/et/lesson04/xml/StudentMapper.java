package com.et.lesson04.xml;

import java.util.List;

import org.apache.ibatis.annotations.Param;

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
	public List<Student> queryStudentById(Student student);
	/**
	 * 通过学生的性别查询
	 * 参数中传入sex  就根据条件查  没有传值就查所有的女生
	 * @param sex
	 * @return
	 */
	public List<Student> queryBySex(@Param("sex")Integer sex);
	/**
	 * 修改学生信息
	 * @param 
	 * @return
	 */
	public void updateStudent(Student student);
	
	/**
	 * 通过传入的班级查询所有的学生
	 * @Param("取别名")
	 */
	public List<Student> queryStudentAndGrade(@Param("gradeList")List<String> gradeList);

}
