package com.example.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.model.MUser;
import com.example.model.UData;

@Mapper
public interface UserMapper {
	
	//ユーザー登録
	public int insertOne(MUser user);
	
	//ユーザー複数検索
	public List<MUser> findMany(MUser user);
	
	//ユーザー1件取得
	public MUser findOne(String userId);
	
	//ユーザー更新
	public void updateOne(@Param("userId")String userId,
						  //@Param("password")String password,
						  @Param("userName")String userName,
						  @Param("role")String role
						  );
	
	//ユーザー消去
	public int deleteOne(@Param("userId")String userId);
	
	//ログインユーザー取得
	public MUser findLoginUser(String userId);
	
	//各自データー登録
	public UData insertData(String userId);

}
