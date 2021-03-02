package com.spring.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CheckResult {
	
	private String title;
	private boolean isConn;
	private String desc;
	private Map<String, List<String>> map = new HashMap<>();
	private List<String> error = new ArrayList<String>();
}
