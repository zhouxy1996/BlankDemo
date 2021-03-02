package com.spring.entity;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class AnyStatus {

	private String title;
	private Map<String, List<String>> map;
	@SuppressWarnings("unused")
	private int imgLength = 1000;

	public AnyStatus() {
		super();
	}

	public AnyStatus(String title, Map<String, List<String>> map) {
		super();
		this.title = title;
		this.map = map;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Map<String, List<String>> getMap() {
		return map;
	}

	public void setMap(Map<String, List<String>> map) {
		this.map = map;
	}

	public int getImgLength() {
		int i = 0;
		for (Entry<String, List<String>> entry : map.entrySet()) {
			List<String> value = entry.getValue();
			i = i + value.size();
		}
		
		return 85+ map.size() * 30 + i * 30;
	}

}
