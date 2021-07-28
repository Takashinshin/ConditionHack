package com.example.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.form.UserListForm;
import com.example.model.MUser;
import com.example.service.UserService;

@Controller
@RequestMapping("/admin")
public class TopController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	//top画面を表示
	@GetMapping("/top")
	public String getUserData(@ModelAttribute UserListForm form, Model model) {
		//formをMUserクラスに変換
		MUser user = modelMapper.map(form, MUser.class);
		
		//ユーザー検索
		List<MUser> userList = userService.getUsers(user);
		
		model.addAttribute("userList", userList);
		
		//ユーザー一覧画面を表示
		return "admin/top";
	}
	
	//ユーザー検索処理
	@PostMapping("/top")
	public String postUserData(@ModelAttribute UserListForm form, Model model) {
		//formをMUserクラスに変換
		MUser user = modelMapper.map(form, MUser.class);
		
		//ユーザー検索
		List<MUser> userList = userService.getUsers(user);
		
		//Modelに格納
		model.addAttribute("userList", userList);
		
		return "admin/top";
	}

}
