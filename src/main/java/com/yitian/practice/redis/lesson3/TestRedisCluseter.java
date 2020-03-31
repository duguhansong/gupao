package com.yitian.practice.redis.lesson3;

import com.yitian.practice.redis.JedisClientFactory;

public class TestRedisCluseter {

	public static void main(String[] args) {
		while (true) {
			int i = 0;
			try {
				for (; i < 100000; i++) {
					JedisClientFactory.Ins().set("key_" + i, "value_" + i);
					if (i % 100 == 0) {
						System.out.println("»¹»î×Å....");
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
