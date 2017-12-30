package com.et.lesson03.sql;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import org.junit.Test;

import com.et.lesson02.Food;


public class MyTest {
	public static SqlSession getSession() throws IOException{
		String resource = "com/et/lesson03/sql/mybatis.xml";
		//获取文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//工厂类
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//session 操作的是执行sql语句的一个唯一标识符
		SqlSession session=sqlSessionFactory.openSession();
		return  session;
	}
	
	@Test
	public void QueryFood() throws IOException{
		SqlSession session=getSession();
		//获取接口
		FoodMapper fm=session.getMapper(FoodMapper.class);
		List  list=fm.queryFood("大盘鸡", "60");
		
		System.out.println(list);
	}

	
}
