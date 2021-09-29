/* package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.model.UserProfile;


public class TestController {
	
	@Autowired
	private TestService testService;
	
	
	@GetMapping(path="/test")
	public List<Map<String, Object>> getTestList() {
		return testService.testsql("test");
	}
	
	@GetMapping(path="/test2")
	public String getTestList2() {
		String test = "test";
		return test;
	}
}*/
