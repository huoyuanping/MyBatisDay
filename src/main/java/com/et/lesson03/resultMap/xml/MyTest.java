package com.et.lesson03.resultMap.xml;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;



public class MyTest {
	public static SqlSession getSession() throws IOException{
		String resource = "com/et/lesson03/resultMap/xml/mybatis.xml";
		//��ȡ�ļ���
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//������
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//session ��������ִ��sql����һ��Ψһ��ʶ��
		SqlSession session=sqlSessionFactory.openSession();
		return  session;
	}
	
	/**
	 * ��ѯ���еİ༶
	 * @throws IOException
	 */
	
	//@Test
	public void QueryAllGrade() throws IOException{
		SqlSession session=getSession();
		//��ȡ�ӿ�
		GradeMapper gm=session.getMapper(GradeMapper.class);
		List<Grade> list=gm.queryAllGrade();
		for (Grade g : list) {
			System.out.println(g.getGid()+"-----"+g.getGname());
		}
		System.out.println(list.size());
	}
	
	/**
	 * ���һ�Ĳ�ѯ
	 * @throws IOException
	 */
	
	@Test
	public void QueryManyToOne() throws IOException{
		SqlSession session=getSession();
		//��ȡ�ӿ�
		StudentMapper gm=session.getMapper(StudentMapper.class);
		Student st=gm.queryStudentById("2");
		System.out.println(st.getSname());
		System.out.println(st.getGrade().getGname());
		//System.out.println(st.getSname()+"---"+st.getGrade().getGname());
		
	}
	
	/**
	 * һ�Զ�Ĳ�ѯ
	 * @throws IOException
	 */
	
	//@Test
	public void QueryOneToMany() throws IOException{
		SqlSession session=getSession();
		//��ȡ�ӿ�
		GradeMapper gm=session.getMapper(GradeMapper.class);
		Grade ge=gm.queryGrade("1");
		for (Student s:ge.getStudentList()) {
			System.out.println(ge.getGname()+"==="+s.getSid()+"---"+s.getSname());
		}
		System.out.println(ge.getStudentList().size());
		
	}
	
}
