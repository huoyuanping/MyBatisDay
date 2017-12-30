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
		//获取文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//工厂类
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//session 操作的是执行sql语句的一个唯一标识符
		SqlSession session=sqlSessionFactory.openSession();
		return  session;
	}
	
	/**
	 * 查询所有的班级
	 * @throws IOException
	 */
	
	//@Test
	public void QueryAllGrade() throws IOException{
		SqlSession session=getSession();
		//获取接口
		GradeMapper gm=session.getMapper(GradeMapper.class);
		List<Grade> list=gm.queryAllGrade();
		for (Grade g : list) {
			System.out.println(g.getGid()+"-----"+g.getGname());
		}
		System.out.println(list.size());
	}
	
	/**
	 * 多对一的查询
	 * @throws IOException
	 */
	
	@Test
	public void QueryManyToOne() throws IOException{
		SqlSession session=getSession();
		//获取接口
		StudentMapper gm=session.getMapper(StudentMapper.class);
		Student st=gm.queryStudentById("2");
		System.out.println(st.getSname());
		System.out.println(st.getGrade().getGname());
		//System.out.println(st.getSname()+"---"+st.getGrade().getGname());
		
	}
	
	/**
	 * 一对多的查询
	 * @throws IOException
	 */
	
	//@Test
	public void QueryOneToMany() throws IOException{
		SqlSession session=getSession();
		//获取接口
		GradeMapper gm=session.getMapper(GradeMapper.class);
		Grade ge=gm.queryGrade("1");
		for (Student s:ge.getStudentList()) {
			System.out.println(ge.getGname()+"==="+s.getSid()+"---"+s.getSname());
		}
		System.out.println(ge.getStudentList().size());
		
	}
	
}
