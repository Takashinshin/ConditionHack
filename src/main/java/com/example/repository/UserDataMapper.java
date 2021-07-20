package com.example.repository;


import org.apache.ibatis.annotations.Mapper;

import com.example.model.UData;

@Mapper
public interface UserDataMapper {
	
	//各ユーザーデータ取得
	public UData findAllData(String userId);

}
