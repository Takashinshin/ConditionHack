package com.example.controller;

import java.security.Principal;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.form.LoginForm;
import com.example.form.UserListForm;
import com.example.model.MUser;
import com.example.service.UserService;
import com.example.service.impl.UserDetailsServiceImple;

import lombok.extern.slf4j.Slf4j;


@Controller
@Slf4j
public class TopController {
	
	@Autowired
	private UserService userService;
	
	
	@Autowired
	private ModelMapper modelMapper;
	
	//user/top画面を表示
	@GetMapping("/user/top")
	public String getUserData(LoginForm form,Model model, @AuthenticationPrincipal User user) {
		//ログインユーザー情報の表示
		log.info(user.toString());
		
		MUser loginUser = userService.getUserOne(user.getUsername());
		
		model.addAttribute("loginUser", loginUser);
		
		
		return "user/top";
	}
	
	//ユーザー検索処理
	@PostMapping("/user/top")
	public String postUserData() {
		//@ModelAttribute UserListForm form, Model model
//		//formをMUserクラスに変換
//		MUser user = modelMapper.map(form, MUser.class);
//		
//		//ユーザー検索
//		List<MUser> userList = userService.getUsers(user);
//		
//		//Modelに格納
//		model.addAttribute("userList", userList);
		
		return "user/top";
	}

}
