package com.et.lesson05.xml;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import redis.clients.jedis.Jedis;

public class JavaReadis {
	
	/**
	 * ������ת��byte����
	 * ���л�
	 * д�����ݵ�redisʱ����
	 * jedis.set("myname", "����");
	 * Ĭ��mybatis��û�м̳�redis��Ҫ�Լ�ʵ��
	 * @param obj
	 * @return
	 * @throws IOException 
	 */
	
	public static byte[] objectToByteArrat(Object obj) throws IOException{
		//�ڴ���
		ByteOutputStream bos=new ByteOutputStream();
		ObjectOutputStream oos=new ObjectOutputStream(bos);
		oos.writeObject(obj);
		return bos.getBytes();
	}
	
	/**
	 * ��byte����ת�ɶ���
	 * �����л�
	 * @param bt
	 * @return
	 * @throws IOException 
	 * @throws ClassNotFoundException 
	 */
	public static Object byteArrayToObject(byte[] bt) throws IOException, ClassNotFoundException{
		//�ڴ���
		ByteInputStream bis=new ByteInputStream(bt,bt.length);
		// �����л�
		ObjectInputStream ois=new ObjectInputStream(bis);
		return ois.readObject();
	}
	
	public static void main(String[] args) {
		Jedis jedis=new Jedis("localhost",6379);
		//��ֵ��
		jedis.set("myname", "����");
		System.out.println(jedis.get("myname"));
	}
}	
