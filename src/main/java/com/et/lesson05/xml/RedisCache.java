package com.et.lesson05.xml;
/**
 * 分布式环境
 */
import java.io.IOException;
import java.util.concurrent.locks.ReadWriteLock;

import org.apache.ibatis.cache.Cache;

import redis.clients.jedis.Jedis;

public class RedisCache implements Cache {
	/**
	 * 操作redis对象
	 */
	Jedis jedis=new Jedis("localhost",6379);
	private String cacheId;
	public RedisCache(String cacheId){
		this.cacheId=cacheId;
		
	}
	@Override
	public void clear() {
		//清空缓存
		//jedis.flushDB();
	}

	@Override
	public String getId() {
		return cacheId;
	}

	/**
	 * mybatis自动调用getObject检测是否在缓存中存在
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
	 * mybatis读取数据是将数据库中读取的数据通过putObject设置到缓存中
	 */
	@Override
	public void putObject(Object key, Object value) {
		//写入redis
		try {
			jedis.set(JavaReadis.objectToByteArrat(key), JavaReadis.objectToByteArrat(value));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	/**
	 * mybatis缓存策略 自动判断内存的大小 决定是否删除某些过期 久远的数据
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
