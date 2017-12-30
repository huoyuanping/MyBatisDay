package com.et.lesson05.xml;
/**
 * �ֲ�ʽ����
 */
import java.io.IOException;
import java.util.concurrent.locks.ReadWriteLock;

import org.apache.ibatis.cache.Cache;

import redis.clients.jedis.Jedis;

public class RedisCache implements Cache {
	/**
	 * ����redis����
	 */
	Jedis jedis=new Jedis("localhost",6379);
	private String cacheId;
	public RedisCache(String cacheId){
		this.cacheId=cacheId;
		
	}
	@Override
	public void clear() {
		//��ջ���
		//jedis.flushDB();
	}

	@Override
	public String getId() {
		return cacheId;
	}

	/**
	 * mybatis�Զ�����getObject����Ƿ��ڻ����д���
	 */
	@Override
	public Object getObject(Object key) {
		try {
			byte[] bt=jedis.get(JavaReadis.objectToByteArrat(key));
			if(bt==null){
				return null;
			}
			return JavaReadis.byteArrayToObject(bt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ReadWriteLock getReadWriteLock() {
		return null;
	}

	@Override
	public int getSize() {
		return 0;
	}

	/**
	 * mybatis��ȡ�����ǽ����ݿ��ж�ȡ������ͨ��putObject���õ�������
	 */
	@Override
	public void putObject(Object key, Object value) {
		//д��redis
		try {
			jedis.set(JavaReadis.objectToByteArrat(key), JavaReadis.objectToByteArrat(value));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	/**
	 * mybatis������� �Զ��ж��ڴ�Ĵ�С �����Ƿ�ɾ��ĳЩ���� ��Զ������
	 */
	@Override
	public Object removeObject(Object key) {
		Object obj=getObject(key);
		try {
			jedis.del(JavaReadis.objectToByteArrat(key));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return obj;
	}

}
