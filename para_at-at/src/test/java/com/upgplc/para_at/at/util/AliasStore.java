package com.upgplc.para_at.at.util;

import java.util.HashMap;
import java.util.Map;

public class AliasStore<T> {

	private ThreadLocal<Map<String, T>> values = new ThreadLocal<>();
	
	private long autoIdSequence = 1;
	
	public void clear() {
		map().clear();
	}
	
	public T get(String key) {
		return map().get(key);
	}

	public Iterable<T> getAll() {
		return map().values();
	}
	
	public void put(String key, T value) {
		if (map().put(key, value) != null) {
			throw new IllegalStateException("Duplicate storage for key " + key);
		}
	}
	
	public void put(T value) {
		put("_unnamed" + autoIdSequence++, value);
	}

	private Map<String, T> map() {
		Map<String, T> store = values.get();
		if (store == null) {
			store = new HashMap<>();
			values.set(store);
		}
		return store;
	}
}
