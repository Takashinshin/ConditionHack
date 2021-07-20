package com.example.application.service;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Service;


@Service
public class ApplicationService {
	//性別のMapを生成する
	public Map<String, Integer> getGenderMap(){
		Map<String, Integer> genderMap = new LinkedHashMap<>();
		genderMap.put("男性", 1);
		genderMap.put("女性", 2);
		
		return genderMap;
	}
	
	//管理者のMapを生成する
	public Map<String, Integer> getRoleMap(){
		Map<String, Integer> roleMap = new LinkedHashMap<>();
		
		roleMap.put("管理者ユーザー", 1);
		roleMap.put("一般ユーザー", 2);
		
		return roleMap;
	}

}
