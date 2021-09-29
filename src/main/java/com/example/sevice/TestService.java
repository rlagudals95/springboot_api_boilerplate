package com.example.sevice;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.dao.CommonDao;
import java.util.List;

@Service("testService")
public class TestService {
	
	
	@Autowired
	private CommonDao commonDao;
	
	
	// 테스트 서비스
	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> testsql(){
		return (List<Map<String, Object>>)commonDao.queryForList("test.testsql");
	}
}
