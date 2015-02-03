package com.perceptivesoftware.mule.connector.client.util;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QueryParmeters implements Iterable<QueryParmeters.Item> {
	@SuppressWarnings("serial")
	public class Item extends SimpleEntry<String, String> {
		public Item(String key, String value) {
			super(key, value);
		}
	}
	
	private List<Item> headers;
	
	public static QueryParmeters create() {
		return new QueryParmeters();
	}
	
	private QueryParmeters() {
		headers = new ArrayList<Item>();
	}
	
	public QueryParmeters add(String name, String data) {
		headers.add(new Item(name, data));
		
		return this;
	}

	@Override
	public Iterator<Item> iterator() {
		return headers.iterator();
	}	
}
