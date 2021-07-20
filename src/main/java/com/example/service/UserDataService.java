package com.example.service;

import com.example.model.UData;

public interface UserDataService {
	
	//1件データ取得
	public UData getUserData(String userId);
}
