package com.et.lesson05.xml;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import redis.clients.jedis.Jedis;

public class JavaReadis {
	
	/**
	 * 将对象转成byte数组
	 * 序列化
	 * 写入数据到redis时调用
	 * jedis.set("myname", "张三");
	 * 默认mybatis是没有继承redis需要自己实现
	 * @param obj
	 * @return
	 * @throws IOException 
	 */
	
	public static byte[] objectToByteArrat(Object obj) throws IOException{
		//内存流
		ByteOutputStream bos=new ByteOutputStream();
		ObjectOutputStream oos=new ObjectOutputStream(bos);
		oos.writeObject(obj);
		return bos.getBytes();
	}
	
	/**
	 * 将byte数组转成对象
	 * 反序列化
	 * @param bt
	 * @return
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public static Object byteArrayToObject(byte[] bt) throws IOException, ClassNotFoundException{
		//内存流
		ByteInputStream bis=new ByteInputStream(bt,bt.length);
		// 反序列化
		ObjectInputStream ois=new ObjectInputStream(bis);
		return ois.readObject();
	}
	
	public static void main(String[] args) {
		Jedis jedis=new Jedis("localhost",6379);
		//键值对
		jedis.set("myname", "张三");
		System.out.println(jedis.get("myname"));
	}
}	
