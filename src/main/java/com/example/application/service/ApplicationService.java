package com.example.application.service;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;


@Service
public class ApplicationService {
	
	@Autowired
	private MessageSource messageSource;
	
	//性別のMapを生成する
	public Map<String, Integer> getGenderMap(){
		Map<String, Integer> genderMap = new LinkedHashMap<>();
		String male = messageSource.getMessage("male", null, Locale.JAPAN);
		String female = messageSource.getMessage("female", null, Locale.JAPAN);
		genderMap.put(male, 1);
		genderMap.put(female, 2);
		return genderMap;
	}
	
	//管理者のMapを生成する
	public Map<String, Integer> getRoleMap(){
		Map<String, Integer> roleMap = new LinkedHashMap<>();
		roleMap.put("管理者ユーザー", 1);
		roleMap.put("一般ユーザー", 2);
		
		return roleMap;
	}
	
	//regionのMapを生成する
	public Map<String, Integer> getRegionMap(){
		Map<String, Integer> regionMap = new LinkedHashMap<>();
		regionMap.put("北海道", 1);
		regionMap.put("東北", 2);
		regionMap.put("関東", 3);
		regionMap.put("北陸", 4);
		regionMap.put("中部", 5);
		regionMap.put("関西", 6);
		regionMap.put("中国", 7);
		regionMap.put("四国", 8);
		regionMap.put("九州", 9);
		
		return regionMap;
	}
	
	
	//体調のMapを生成する
	public Map<String, Integer> getConditionMap(){
		Map<String, Integer> conditionMap = new LinkedHashMap<>();
		conditionMap.put("良好", 1);
		conditionMap.put("普通", 2);
		conditionMap.put("悪い", 3);
		
		return conditionMap;
	}
	

}
