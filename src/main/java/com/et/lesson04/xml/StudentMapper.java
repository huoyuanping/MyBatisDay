package com.et.lesson04.xml;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * @author Administrator
 *
 */
public interface StudentMapper {
	/**
	 * ͨ����Ų�ѯѧ��
	 * @param 
	 * @return
	 */
	public List<Student> queryStudentById(Student student);
	/**
	 * ͨ��ѧ�����Ա��ѯ
	 * �����д���sex  �͸���������  û�д�ֵ�Ͳ����е�Ů��
	 * @param sex
	 * @return
	 */
	public List<Student> queryBySex(@Param("sex")Integer sex);
	/**
	 * �޸�ѧ����Ϣ
	 * @param 
	 * @return
	 */
	public void updateStudent(Student student);
	
	/**
	 * ͨ������İ༶��ѯ���е�ѧ��
	 * @Param("ȡ����")
	 */
	public List<Student> queryStudentAndGrade(@Param("gradeList")List<String> gradeList);

}
