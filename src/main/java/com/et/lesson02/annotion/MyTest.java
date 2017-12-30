package com.et.lesson02.annotion;

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

import com.et.lesson02.Food;
import com.et.lesson02.annotion.FoodMap;

public class MyTest {
	public static SqlSession getSession() throws IOException{
		String resource = "com/et/lesson02/annotion/mybatis.xml";
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
	public void QueryAnnotionFood() throws IOException{
		SqlSession session=getSession();
		//获取接口
		FoodMap fm=session.getMapper(FoodMap.class);
		List  list=fm.queryFood("大盘鸡", "60");
		
		System.out.println(list);
	}
	//@Test
	public void deleteAnnotionFood() throws IOException{
		SqlSession session=getSession();
		//获取接口
		FoodMap fm=session.getMapper(FoodMap.class);
		fm.deleteFood("4");
		session.commit();
	}
	
	/**
	 * 通菜品名模糊查找
	 * @throws IOException
	 */
	//@Test
	public void QueryFoodByName() throws IOException{
		SqlSession session=getSession();
		//获取接口
		FoodMap fm=session.getMapper(FoodMap.class);
		List<Food>  list=fm.queryFoodByName("鸡");
		
		System.out.println(list);
	}
	
	/**
	 * 插入food 在程序中获取主键
	 * @throws IOException
	 */
	@Test
	public void QueryFoodSelectKey() throws IOException{
		SqlSession session=getSession();
		//获取接口
		FoodMap fm=session.getMapper(FoodMap.class);
		Food food=new Food();
		food.setFoodName("烧鹅");
		food.setPrice("100");
		fm.saveFood(food);
		session.commit();
		System.out.println(food.getFoodId());
		
	}
	
	
}
