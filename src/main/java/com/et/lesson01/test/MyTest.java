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
		//��ȡ�ļ���
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//������
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//session ��������ִ��sql����һ��Ψһ��ʶ��
		SqlSession session=sqlSessionFactory.openSession();
		return  session;
	}
	//�Զ���log��־
	Logger logger=Logger.getLogger(MyTest.class);
	//@Test
	public void QueryFood() throws IOException{
		SqlSession session=getSession();
		Map map=new HashMap();
		map.put("price", 60);
		map.put("foodname", "���̼�");
		List  list = session.selectList("a.selectFoodByParam", map);
		logger.info(list);
		System.out.println(list);
	}
	
	/**
	 *ͨ������ֵ���������
	 * @throws IOException
	 */
	//@Test
	public void FoodAll() throws IOException{
		SqlSession session=getSession();
		Food food=new Food();
		food.setPrice("60");
		food.setFoodname("���̼�");
		List  list = session.selectList("a.selectFoodByParam", food);
		System.out.println(list);
	}
	
	@Test
	public void saveFood() throws IOException{
		SqlSession session=getSession();
		Food food=new Food();
		food.setPrice("100");
		food.setFoodname("�ع���");
		session.insert("a.saveFood", food);
		session.commit();
		
	}
	
}
