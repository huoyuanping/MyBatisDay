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
		//获取文件流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//工厂类
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//session 操作的是执行sql语句的一个唯一标识符
		SqlSession session=sqlSessionFactory.openSession();
		List list=session.selectList("selectFood");
		System.out.println(list);
		//通过id查找
		Map  map=(Map)session.selectOne("selectFoodById");
		System.out.println(map);
		
	
	/*	//添加
		Map map1=new HashMap();
		map1.put("foodid", "5");
		map1.put("foodname", "酸辣土豆丝");
		map1.put("price", "155");
		session.insert("insertFood", map1);
		System.out.println(map1);
		//删除
		session.delete("deleteFood");
		session.commit();
		
		//修改
		session.update("a.updateFood");
		session.commit();*/
		
		//删除
		/*Map map1=new HashMap();
		map1.put("foodid", "4");
		session.delete("deleteFood", map1);
		session.commit();
		System.out.println(map1);*/
		//修改
		Map map1=new HashMap();
		map1.put("foodid", "1");
		map1.put("foodname", "酸辣土豆丝");
		map1.put("price", "20");
		session.update("updateFood", map1);
		session.commit();
		System.out.println(map1);
	}
}
