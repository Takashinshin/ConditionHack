package com.example.service;

import java.util.List;

import com.example.model.MUser;

public interface UserService {
	
	//ユーザー登録
	public void Signup(MUser user);
	
	//ユーザー検索
	public List<MUser> getUsers();
	
	//ユーザー1件検索
	public MUser getUserOne(String userId);
}
