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
		//��ȡ�ļ���
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//������
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//session ��������ִ��sql����һ��Ψһ��ʶ��
		SqlSession session=sqlSessionFactory.openSession();
		return  session;
	}
	
	@Test
	public void QueryFood() throws IOException{
		SqlSession session=getSession();
		//��ȡ�ӿ�
		FoodMapper fm=session.getMapper(FoodMapper.class);
		List  list=fm.queryFood("���̼�", "60");
		
		System.out.println(list);
	}

	
}
