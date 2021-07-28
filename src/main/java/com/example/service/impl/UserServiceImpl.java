package com.example.service.impl;

import java.security.KeyStore.PrivateKeyEntry;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.MUser;
import com.example.repository.UserMapper;
import com.example.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private PasswordEncoder encoder;
	
	//ユーザー登録
	@Override
	public void Signup(MUser user) {
		user.setRole("ROLE_GENERAL");
		
		String rawPassword = user.getPassword();
		user.setPassword(encoder.encode(rawPassword));
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
	//ユーザー1件更新
	@Transactional
	@Override
	public void updateUserOne(String userId, String password, String userName, String role) {
		//パスワード暗号化
		String enctyptPassword = encoder.encode(password);
		
		userMapper.updateOne(userId, enctyptPassword, userName, role);
	}

	//ユーザー1件消去
	@Override
	public void deleteUserOne(String userId) {
		int count =  userMapper.deleteOne(userId);

	}
	
	//ログインユーザー取得
	@Override
	public MUser getLoginUser(String userId) {
		return userMapper.findLoginUser(userId);
	}
	
	
	
}
