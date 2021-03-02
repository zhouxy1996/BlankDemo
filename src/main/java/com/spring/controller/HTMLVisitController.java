package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HTMLVisitController {
	
	@RequestMapping("/")
	public String visitIndex(){
		
		return "index";
	}
	
	
	@RequestMapping("/otherPage")
	public String visitOtherPage(){
		System.out.println("other.html");
		return "other";
	}
	

}
