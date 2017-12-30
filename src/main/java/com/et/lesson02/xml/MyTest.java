package com.et.lesson02.xml;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Test;

import com.et.lesson02.Food;
import com.et.lesson02.xml.FoodMap;

public class MyTest {
	public static SqlSession getSession() throws IOException{
		String resource = "com/et/lesson02/xml/mybatis.xml";
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
		//��ȡ�ӿ�
		FoodMap fm=session.getMapper(FoodMap.class);
		List  list=fm.queryFood("���̼�", "60");
		
		System.out.println(list);
	}
	//@Test
	public void deleteFood() throws IOException{
		SqlSession session=getSession();
		//��ȡ�ӿ�
		FoodMap fm=session.getMapper(FoodMap.class);
		fm.deleteFood("4");
		session.commit();
	}
	
	/**
	 * ͨ��Ʒ��ģ������
	 * @throws IOException
	 */
	//@Test
	public void QueryFoodByName() throws IOException{
		SqlSession session=getSession();
		//��ȡ�ӿ�
		FoodMap fm=session.getMapper(FoodMap.class);
		List  list=fm.queryFoodByName("��");
		
		System.out.println(list);
	}

	/**
	 * ����food �ڳ����л�ȡ����
	 * @throws IOException
	 */
	@Test
	public void QueryFoodSelectKey() throws IOException{
		SqlSession session=getSession();
		//��ȡ�ӿ�
		FoodMap fm=session.getMapper(FoodMap.class);
		Food food=new Food();
		food.setFoodName("ţ����");
		food.setPrice("10");
		fm.saveFood(food);
		session.commit();
		System.out.println(food.getFoodId());
		
		
	}

	
}
