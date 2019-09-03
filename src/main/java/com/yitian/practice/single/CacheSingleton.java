package com.yitian.practice.single;

import java.util.HashMap;
/**
 * ÈÝÆ÷Ê½µ¥Àý
 */
public final class CacheSingleton {
	private final static HashMap< String, Object> cache = new HashMap<String,Object>();
	private CacheSingleton() {

	}
	@SuppressWarnings("unchecked")
	public static <T> T getIns(Class<T> clazz) throws InstantiationException, IllegalAccessException {
		String key = clazz.getName();
		if(cache.get(key) == null) {
			synchronized (CacheSingleton.class) {
				if(cache.get(key) == null) {
					cache.put(key, clazz.newInstance());
				}
			}
		}
		return (T)cache.get(key);
	}
}
