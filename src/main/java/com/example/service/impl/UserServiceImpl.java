package com.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.MUser;
import com.example.repository.UserMapper;
import com.example.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;
	
	//ユーザー登録
	@Override
	public void Signup(MUser user) {
		userMapper.insertOne(user);
	}
	
	//ユーザー検索
	@Override
	public List<MUser> getUsers() {
		 return userMapper.findMany();
	}
	
	//ユーザー1件検索
	@Override
	public MUser getUserOne(String userId) {
		return userMapper.findOne(userId);
		
	}
	

}
