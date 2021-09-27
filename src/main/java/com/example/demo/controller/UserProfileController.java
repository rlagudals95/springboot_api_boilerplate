package com.example.demo.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.UserProfile;

@RestController // 이 클래스를 controller로 인식
public class UserProfileController {
	
	private Map<String, UserProfile> userMap;
	
	@PostConstruct
	public void init() {
		userMap = new HashMap<String, UserProfile>();
		userMap.put("1", new UserProfile("1", "홍길동", "111-1111", "서울시 강남구 대치1동"));
		userMap.put("2", new UserProfile("2", "홍길동2", "111-1111", "서울시 강남구 대치1동"));
		userMap.put("3", new UserProfile("3", "홍길동3", "111-1111", "서울시 강남구 대치1동"));
	}
	
	@GetMapping("/user/{id}") // JSON 형태로 mapping해 client에 전달
	public UserProfile getUserProfile(@PathVariable("id") String id) {
		
		return userMap.get(id);
	}
	
	@GetMapping("/user/all")
	public List<UserProfile> getUserProfileList() {
		return new ArrayList<UserProfile>(userMap.values());
	}
	
	@PutMapping("/user/{id}")
	public void putUserProfile(
				@RequestParam("name") String name, 
				@RequestParam("phone") String phone,
				@RequestParam("address") String address) {
		
	}
}
