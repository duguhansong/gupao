package com.yitian.practice.redis;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

public class JedisClientFactory {
	private static final JedisClientFactory ins = new JedisClientFactory();
	private final JedisCluster cluster ;
	
	private JedisClientFactory() {
		JedisPoolConfig config = new JedisPoolConfig();
		config.setMaxTotal(1024);
        config.setMaxIdle(100);
        config.setMaxWaitMillis(100);
        config.setTestOnBorrow(false);//jedis ��һ������ʱ���ᱨ��
        config.setTestOnReturn(true);
        
        HostAndPort server = new HostAndPort("192.168.0.121", 7001);
        // ��ʼ��JedisPool
        cluster = new JedisCluster(server);
	}

	public static JedisClientFactory Ins() {
		return ins;
	}
	
	public  String set(String key,String value) {
		return cluster.set(key, value);
	}
}
