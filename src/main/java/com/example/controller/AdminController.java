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
public class AdminController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	//アドミン権限専用画面に遷移
	@GetMapping("/admin")
	public String getAdmin(@ModelAttribute UserListForm form, Model model) {
		
		//formをMUserクラスに変換
		MUser user = modelMapper.map(form, MUser.class);
		
		//ユーザー全件検索で表示
		List<MUser> userList = userService.getUsers(user);
		
		model.addAttribute("userList", userList);
		
		return "admin/admin";
	}
	
	//ユーザー検索機能
	@PostMapping("/admin")
	public String postUserData(@ModelAttribute UserListForm form, Model model) {
		
		//formをMuserクラスに変換
		MUser user = modelMapper.map(form, MUser.class);
		
		//検索処理（条件分岐で一致したユーザーの検索）
		List<MUser> userList = userService.getUsers(user);
		
		//Modelに格納
		model.addAttribute("userList", userList);
		
		return "admin/admin";
		
	}

}
