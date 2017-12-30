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
	 * 用于二级缓存
	 * @return
	 * @throws IOException
	 */
	public SqlSessionFactory getSessionFactory() throws IOException{
		String resource = "com/et/lesson05/xml/mybatis.xml";
		//获取文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//工厂类
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//session 操作的是执行sql语句的一个唯一标识符
		return  sqlSessionFactory;
	}
	
	/**
	 * 用于一级缓存
	 * @return
	 * @throws IOException
	 */
	public static SqlSession getSession() throws IOException{
		String resource = "com/et/lesson05/xml/mybatis.xml";
		//获取文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//工厂类
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//session 操作的是执行sql语句的一个唯一标识符
		SqlSession session=sqlSessionFactory.openSession();
		return  session;
	}
	
	/**
	 * 通过学生id查询
	 * 一级缓存 ：同一个session对象针对同一份数据的查询产生的缓存
	 * 第一次查询是调用数据 获取数据后
	 * 通过session设置到一级缓存中
	 * 第二次查询时 通过session一级缓存判断是否存在 相同的主键数据值 如果存在直接返回引用否则就查数据库
	 * @throws IOException
	 */
	//@Test
	public void queryStudentByIdToSqlSession() throws IOException{
		SqlSession session=getSession();
		//获取接口
		StudentMapper sm=session.getMapper(StudentMapper.class);
		Student st=sm.queryStudentById("1");
		//从缓存中查询
		Student st1=sm.queryStudentById("1");
		System.out.println(st==st1);
		
	}
	
	/***
	 * 二级缓存:同一个sessionFactory下的不同session可以共享数据(二级缓存默认是没有开启)
	 * @throws IOException
	 */
	@Test
	public void queryStudentByIdToSessionFactory() throws IOException{
		SqlSessionFactory sessionFactory=getSessionFactory();
		SqlSession session=sessionFactory.openSession();
		SqlSession session1=sessionFactory.openSession();
		//获取接口
		StudentMapper sm=session.getMapper(StudentMapper.class);
		Student st=sm.queryStudentById("1");
		session.close();
		//获取接口
		StudentMapper sm1=session1.getMapper(StudentMapper.class);
		//从缓存中查询
		Student st1=sm1.queryStudentById("1");
		System.out.println(st==st1);
	}
	
}
