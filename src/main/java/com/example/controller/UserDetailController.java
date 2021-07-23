package com.example.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.form.UserDetailForm;
import com.example.model.MUser;
import com.example.service.UserService;

@RequestMapping("/user")
@Controller
public class UserDetailController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	//ユーザー詳細画面遷移
	@GetMapping("/detail/{userId:.+}")
	public String getUserDetail(UserDetailForm form, Model model, @PathVariable("userId")String userId) {
		
		MUser user = userService.getUserOne(userId);
		user.setPassword(null);
		
		form = modelMapper.map(user, UserDetailForm.class);
		
		model.addAttribute("userDetailForm", form);
		
		//画面遷移
		return "user/detail";
	}
	
	//ユーザー更新処理
	@PostMapping(value = "/detail", params = "update")
	public String updateUser(UserDetailForm form, Model model) {
		//ユーザー更新
		userService.updateUserOne(form.getUserId(), 
								  form.getPassword(),
								  form.getUserName()
								  );
		
		return "redirect:/user/top";
	}
	
	//ユーザー消去処理
	@PostMapping(value = "/detail", params = "delete")
	public String deleteUser(UserDetailForm form, Model model) {
		//ユーザー消去処理
		userService.deleteUserOne(form.getUserId());
		
		return "redirect:/user/top";
	}
	

}
