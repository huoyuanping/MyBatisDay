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
	 * @throws IOException
	 */
	//@Test
	public void queryStudentById() throws IOException{
		SqlSession session=getSession();
		//获取接口
		StudentMapper sm=session.getMapper(StudentMapper.class);
		Student st=new Student();
		st.setSname("张");
		st.setAddress("深圳");
		List<Student>  list=sm.queryStudentById(st);
		for (Student stu : list) {
			System.out.println(stu.getSname());
		}
	}
	/**
	 * 通过学生性别查询
	 * @throws IOException
	 */
	//@Test
	public void queryBySexChoose() throws IOException{
		SqlSession session=getSession();
		//获取接口
		StudentMapper sm=session.getMapper(StudentMapper.class);
		Integer sex=null;
		List<Student>  list=sm.queryBySex(sex);
		for (Student stu : list) {
			System.out.println(stu.getSname());
		}
	}
	
	/**
	 * 修改学生信息
	 */

	//@Test
	public void updateStudent() throws IOException{
		SqlSession session=getSession();
		//获取接口
		StudentMapper sm=session.getMapper(StudentMapper.class);
		Student st=new Student();
		st.setSid("1");
		st.setSname("张三");
		sm.updateStudent(st);
		session.commit();
		
	}
	
	/**
	 * 通过传入的班级查询所有的学生
	 */
	@Test
	public void queryStudentAndGradeForEach() throws IOException{
		SqlSession session=getSession();
		//获取接口
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
