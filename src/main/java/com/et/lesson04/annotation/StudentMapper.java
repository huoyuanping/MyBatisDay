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
	 * ͨ����Ų�ѯѧ��
	 * @SelectProvider�ṩsql�����һ�����еķ����ṩ��ķ����ڽӿ��еķ�������ͬ
	 * type=����.class
	 * method="���еķ�����"
	 * @param 
	 * @return
	 */
	@SelectProvider(type=StudentProvier.class,method="queryStudentBySql")
	public List<Student> queryStudentById(@Param("stu")Student student);
	/**
	 * ͨ��ѧ�����Ա��ѯ
	 * �����д���sex  �͸���������  û�д�ֵ�Ͳ����е�Ů��
	 * ${}��ע���л�ʧЧ
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
	 * �޸�ѧ����Ϣ
	 * @param 
	 * @return
	 */

	@UpdateProvider(type=StudentProvier.class,method="updateStudentSql")
	public void updateStudent(@Param("stud")Student student);
	
	/**
	 * ͨ������İ༶��ѯ���е�ѧ��
	 * @Param("ȡ����")
	 */
	@SelectProvider(type=StudentProvier.class,method="queryStudentAndGradeBySql")
	public List<Student> queryStudentAndGrade(@Param("gradeList")List<String> gradeList);

}
