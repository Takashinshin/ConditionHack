package com.example.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.model.MUser;

@Mapper
public interface UserMapper {
	
	//ユーザー登録
	public int insertOne(MUser user);
	
	//ユーザー複数検索
	public List<MUser> findMany();
	
	//ユーザー1件取得
	public MUser findOne(String userId);
	
	//ユーザー更新
	public void updateOne(@Param("userId")String userId,
						  @Param("passwoed")String password,
						  @Param("userName")String userName
						  );
	
	//ユーザー消去
	public int deleteOne(@Param("userId")String userId);

}
