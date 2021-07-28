package com.example.service;

import java.util.List;


import com.example.model.MUser;

public interface UserService {
	
	//ユーザー登録
	public void Signup(MUser user);
	
	//ユーザー検索
	public List<MUser> getUsers(MUser user);
	
	//ユーザー1件検索
	public MUser getUserOne(String userId);
	
	//ユーザー更新
	public void updateUserOne(String userId, String password, String userName, String role);
	
	//ユーザー消去
	public void deleteUserOne(String userId);
	
	//ログインユーザー取得
	public MUser getLoginUser(String userId);
	
}
