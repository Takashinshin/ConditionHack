package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class LoginController {
	
	//ログイン画面の表示
	@GetMapping("/")
	public String getLogin() {
		return "login/login";
	}
	
	//ユーザーtop画面にリダイレクト
	@PostMapping("/login")
	public String postLogin() {
		//ユーザーID取得して、各ユーザー用のがめn
		
		return "user/top";
	}

}
