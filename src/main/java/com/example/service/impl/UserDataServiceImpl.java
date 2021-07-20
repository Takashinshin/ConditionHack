package com.example.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.UData;
import com.example.repository.UserDataMapper;
import com.example.service.UserDataService;


@Service
public class UserDataServiceImpl implements UserDataService{
	
	@Autowired
	private UserDataMapper userDataMapper;
	
	
	//1件ユーザーデーター取得
	@Override
	public UData getUserData(String userId) {
		return userDataMapper.findAllData(userId);
	}	

}
