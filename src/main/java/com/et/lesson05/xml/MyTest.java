package com.et.lesson05.xml;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import oracle.net.aso.l;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;



public class MyTest {
	
	/**
	 * ���ڶ�������
	 * @return
	 * @throws IOException
	 */
	public SqlSessionFactory getSessionFactory() throws IOException{
		String resource = "com/et/lesson05/xml/mybatis.xml";
		//��ȡ�ļ���
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//������
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//session ��������ִ��sql����һ��Ψһ��ʶ��
		return  sqlSessionFactory;
	}
	
	/**
	 * ����һ������
	 * @return
	 * @throws IOException
	 */
	public static SqlSession getSession() throws IOException{
		String resource = "com/et/lesson05/xml/mybatis.xml";
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
	 * һ������ ��ͬһ��session�������ͬһ�����ݵĲ�ѯ�����Ļ���
	 * ��һ�β�ѯ�ǵ������� ��ȡ���ݺ�
	 * ͨ��session���õ�һ��������
	 * �ڶ��β�ѯʱ ͨ��sessionһ�������ж��Ƿ���� ��ͬ����������ֵ �������ֱ�ӷ������÷���Ͳ����ݿ�
	 * @throws IOException
	 */
	//@Test
	public void queryStudentByIdToSqlSession() throws IOException{
		SqlSession session=getSession();
		//��ȡ�ӿ�
		StudentMapper sm=session.getMapper(StudentMapper.class);
		Student st=sm.queryStudentById("1");
		//�ӻ����в�ѯ
		Student st1=sm.queryStudentById("1");
		System.out.println(st==st1);
		
	}
	
	/***
	 * ��������:ͬһ��sessionFactory�µĲ�ͬsession���Թ�������(��������Ĭ����û�п���)
	 * @throws IOException
	 */
	@Test
	public void queryStudentByIdToSessionFactory() throws IOException{
		SqlSessionFactory sessionFactory=getSessionFactory();
		SqlSession session=sessionFactory.openSession();
		SqlSession session1=sessionFactory.openSession();
		//��ȡ�ӿ�
		StudentMapper sm=session.getMapper(StudentMapper.class);
		Student st=sm.queryStudentById("1");
		session.close();
		//��ȡ�ӿ�
		StudentMapper sm1=session1.getMapper(StudentMapper.class);
		//�ӻ����в�ѯ
		Student st1=sm1.queryStudentById("1");
		System.out.println(st==st1);
	}
	
}
