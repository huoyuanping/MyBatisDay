package com.et.lesson01.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test {
	public static void main(String[] args) throws IOException {
		String resource = "com/et/lesson01/mybatis.xml";
		//��ȡ�ļ���
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//������
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//session ��������ִ��sql����һ��Ψһ��ʶ��
		SqlSession session=sqlSessionFactory.openSession();
		List list=session.selectList("selectFood");
		System.out.println(list);
		//ͨ��id����
		Map  map=(Map)session.selectOne("selectFoodById");
		System.out.println(map);
		
	
	/*	//���
		Map map1=new HashMap();
		map1.put("foodid", "5");
		map1.put("foodname", "��������˿");
		map1.put("price", "155");
		session.insert("insertFood", map1);
		System.out.println(map1);
		//ɾ��
		session.delete("deleteFood");
		session.commit();
		
		//�޸�
		session.update("a.updateFood");
		session.commit();*/
		
		//ɾ��
		/*Map map1=new HashMap();
		map1.put("foodid", "4");
		session.delete("deleteFood", map1);
		session.commit();
		System.out.println(map1);*/
		//�޸�
		Map map1=new HashMap();
		map1.put("foodid", "1");
		map1.put("foodname", "��������˿");
		map1.put("price", "20");
		session.update("updateFood", map1);
		session.commit();
		System.out.println(map1);
	}
}
