package com.et.lesson04.annotation;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.et.lesson04.xml.Student;


/**
 * @author Administrator
 *
 */
public interface StudentMapper {
	/**
	 * 通过编号查询学生
	 * @SelectProvider提供sql语句有一个类中的方法提供类的方法于接口中的方法名相同
	 * type=类名.class
	 * method="类中的方法名"
	 * @param 
	 * @return
	 */
	@SelectProvider(type=StudentProvier.class,method="queryStudentBySql")
	public List<Student> queryStudentById(@Param("stu")Student student);
	/**
	 * 通过学生的性别查询
	 * 参数中传入sex  就根据条件查  没有传值就查所有的女生
	 * ${}在注解中会失效
	 * @param sex
	 * @return
	 */
	@Select("<script>select * from student where 1=1" +
			"<choose>"+
 			" <when test=\"sex!=null\">"+
 			" and sex=#{sex}"+
 			" </when>"+
 			" <otherwise>"+
 			" and sex=1"+
 			" </otherwise>"+
 			" </choose></script>")
	public List<Student> queryBySex(@Param("sex")Integer sex);
	/**
	 * 修改学生信息
	 * @param 
	 * @return
	 */

	@UpdateProvider(type=StudentProvier.class,method="updateStudentSql")
	public void updateStudent(@Param("stud")Student student);
	
	/**
	 * 通过传入的班级查询所有的学生
	 * @Param("取别名")
	 */
	@SelectProvider(type=StudentProvier.class,method="queryStudentAndGradeBySql")
	public List<Student> queryStudentAndGrade(@Param("gradeList")List<String> gradeList);

}
