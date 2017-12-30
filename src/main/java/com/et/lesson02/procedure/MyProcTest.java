package com.et.lesson02.procedure;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;



public class MyProcTest {
	public static SqlSession getSession() throws IOException{
		String resource = "com/et/lesson02/procedure/mybatis.xml";
		//��ȡ�ļ���
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//������
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//session ��������ִ��sql����һ��Ψһ��ʶ��
		SqlSession session=sqlSessionFactory.openSession();
		return  session;
	}
	
	/**
	 * �洢����
	 * @throws IOException
	 */
	//@Test
	public void testProcFood() throws IOException{
		SqlSession session=getSession();
		Map map=new HashMap();
		map.put("p1",100);
		map.put("p2",200);
		map.put("result",0);
		String result=session.selectOne("call_prg_add",map);
		System.out.println(map.get("result"));
	}
	/**
	 * ����
	 * @throws IOException
	 */
	@Test
	public void testFunFood() throws IOException{
		SqlSession session=getSession();
		Map map=new HashMap();
		map.put("p1",100);
		map.put("p2",200);
		map.put("result",0);
		String result=session.selectOne("call_fun_add",map);
		System.out.println(map.get("result"));
	}
}
