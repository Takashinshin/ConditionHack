package com.example.controller;

import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.application.service.ApplicationService;
import com.example.form.UserDetailForm;
import com.example.model.MUser;
import com.example.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminDetailController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private ApplicationService applicationService;
	
	
	//ユーザー詳細画面遷移
	@GetMapping("/detail/{userId:.+}")
	public String getUserDetail(UserDetailForm form, Model model, @PathVariable("userId")String userId) {
		//ユーザー1件検索
		MUser user = userService.getUserOne(userId);
		
		//体調Mapを取得
		Map<String, Integer> conditionMaoMap = applicationService.getConditionMap();
		model.addAttribute("conditionMap", conditionMaoMap);
		
		//u_dataとu_goalをformにセット
		form.setDataList(user.getDataList());
		form.setUserGoal(user.getUserGoal());
		
		//Modelに格納
		model.addAttribute("userDetailForm", form);
		
		return "admin/detail";
	}
	
	//ユーザー更新処理
	@PostMapping(value = "/detail", params = "update")
	public String updateUser(UserDetailForm form) {
		//ユーザー更新処理
		userService.updateUserOne(form.getUserId(), form.getUserName(), form.getRole());
		
		return "redirect:/admin/admin";
	}
	
	//ユーザー消去処理
	@PostMapping(value = "/detail", params = "delete")
	public String deleteUser(UserDetailForm form) {
		userService.deleteUserOne(form.getUserId());
		
		return "redirect:/admin/admin";
	}
	
	

}
