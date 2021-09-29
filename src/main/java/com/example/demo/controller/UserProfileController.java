package com.example.demo.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.UserProfile;


@RestController // 이 클래스를 controller로 인식
public class UserProfileController {
	
	/*
	 * @Autowired private TestService testService;
	 */
	
	
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
	
	//@Autowired
	//private testService.testsql("test");
	
	/*
	 * @GetMapping("/user/test") public List<Map<String, Object>> test() { return
	 * testService.testsql("test"); }
	 */
	
	@PutMapping("/user/{id}")
	public void putUserProfile(
				@PathVariable("id") String id,
				@RequestParam("name") String name, 
				@RequestParam("phone") String phone,
				@RequestParam("address") String address) {
				
		UserProfile userProfile = new UserProfile(id, name, phone,address);
		userMap.put(id, userProfile);
	}
	
	@PostMapping("/user/{id}") // 수정
	public void postUserProfile(
			@PathVariable("id") String id,
			@RequestParam("name") String name, 
			@RequestParam("phone") String phone,
			@RequestParam("address") String address) {
		
		UserProfile userProfile = userMap.get(id); // 기존의 유저정보를 id를 통해 찾는다
		userProfile.setName(name);
		userProfile.setPhone(phone);
		userProfile.setAddress(address);
		
	}
	
	@DeleteMapping("/user/{id}")
	public void deleteUserProfile(
			@PathVariable("id") String id) {
		
		userMap.remove(id); // path를 통해 받은 id로 제거
	}
}
