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
	public List<MUser> getUsers(MUser user) {
		 return userMapper.findMany(user);
	}
	
	//ユーザー1件検索
	@Override
	public MUser getUserOne(String userId) {
		return userMapper.findOne(userId);
		
	}

	@Override
	public void updateUserOne(String userId, String password, String userName) {
		userMapper.updateOne(userId, password, userName);
	}

	@Override
	public void deleteUserOne(String userId) {
		int count =  userMapper.deleteOne(userId);

	}
}
