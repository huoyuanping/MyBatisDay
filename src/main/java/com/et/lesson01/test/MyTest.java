package com.et.lesson01.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import oracle.net.aso.f;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Test;

public class MyTest {
	public static SqlSession getSession() throws IOException{
		String resource = "com/et/lesson01/test/mybatis.xml";
		//获取文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//工厂类
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//session 操作的是执行sql语句的一个唯一标识符
		SqlSession session=sqlSessionFactory.openSession();
		return  session;
	}
	//自定义log日志
	Logger logger=Logger.getLogger(MyTest.class);
	//@Test
	public void QueryFood() throws IOException{
		SqlSession session=getSession();
		Map map=new HashMap();
		map.put("price", 60);
		map.put("foodname", "大盘鸡");
		List  list = session.selectList("a.selectFoodByParam", map);
		logger.info(list);
		System.out.println(list);
	}
	
	/**
	 *通过对象传值（面向对象）
	 * @throws IOException
	 */
	//@Test
	public void FoodAll() throws IOException{
		SqlSession session=getSession();
		Food food=new Food();
		food.setPrice("60");
		food.setFoodname("大盘鸡");
		List  list = session.selectList("a.selectFoodByParam", food);
		System.out.println(list);
	}
	
	@Test
	public void saveFood() throws IOException{
		SqlSession session=getSession();
		Food food=new Food();
		food.setPrice("100");
		food.setFoodname("回锅肉");
		session.insert("a.saveFood", food);
		session.commit();
		
	}
	
}
