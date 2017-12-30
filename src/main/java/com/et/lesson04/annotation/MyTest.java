package com.et.lesson04.annotation;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.et.lesson04.xml.Student;



public class MyTest {
	public static SqlSession getSession() throws IOException{
		String resource = "com/et/lesson04/annotation/mybatis.xml";
		//��ȡ�ļ���
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//������
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//session ��������ִ��sql����һ��Ψһ��ʶ��
		SqlSession session=sqlSessionFactory.openSession();
		return  session;
	}
	
	/**
	 * ͨ��ѧ��id��ѯ
	 * @throws IOException
	 */
	//@Test
	public void queryStudentById() throws IOException{
		SqlSession session=getSession();
		//��ȡ�ӿ�
		StudentMapper sm=session.getMapper(StudentMapper.class);
		Student st=new Student();
		st.setSname("��");
		st.setAddress("����");
		List<Student>  list=sm.queryStudentById(st);
		for (Student stu : list) {
			System.out.println(stu.getSname());
		}
	}
	/**
	 * ͨ��ѧ���Ա��ѯ
	 * @throws IOException
	 */
	//@Test
	public void queryBySexChoose() throws IOException{
		SqlSession session=getSession();
		//��ȡ�ӿ�
		StudentMapper sm=session.getMapper(StudentMapper.class);
		Integer sex=null;
		List<Student>  list=sm.queryBySex(sex);
		for (Student stu : list) {
			System.out.println(stu.getSname());
		}
	}
	
	/**
	 * �޸�ѧ����Ϣ
	 */

	//@Test
	public void updateStudent() throws IOException{
		SqlSession session=getSession();
		//��ȡ�ӿ�
		StudentMapper sm=session.getMapper(StudentMapper.class);
		Student st=new Student();
		st.setSid("1");
		st.setSname("����");
		sm.updateStudent(st);
		session.commit();
		
	}
	
	/**
	 * ͨ������İ༶��ѯ���е�ѧ��
	 */
	@Test
	public void queryStudentAndGradeForEach() throws IOException{
		SqlSession session=getSession();
		//��ȡ�ӿ�
		StudentMapper sm=session.getMapper(StudentMapper.class);
		List list=new ArrayList();
		list.add("1");
		list.add("2");
		list.add("3");
		List<Student> lt=sm.queryStudentAndGrade(list);
		for (Student student : lt) {
			System.out.println(student.getSname());
			
		}
	}
}
