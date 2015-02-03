package com.perceptivesoftware.mule.connector.client.util;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Headers implements Iterable<Headers.Item> {
	@SuppressWarnings("serial")
	public class Item extends SimpleEntry<String, Object> {
		public Item(String key, Object value) {
			super(key, value);
		}
	}
	
	private List<Item> headers;
	
	public static Headers create() {
		return new Headers();
	}
	
	private Headers() {
		headers = new ArrayList<Item>();
	}
	
	public Headers add(String name, Object data) {
		headers.add(new Item(name, data));
		
		return this;
	}

	@Override
	public Iterator<Item> iterator() {
		return headers.iterator();
	}	
}
