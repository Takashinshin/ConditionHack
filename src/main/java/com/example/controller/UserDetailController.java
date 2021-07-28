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

@RequestMapping("/admin")
@Controller
public class UserDetailController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private ApplicationService applicationService;
	
	//ユーザー詳細画面遷移
	@GetMapping("/detail/{userId:.+}")
	public String getUserDetail(UserDetailForm form, Model model, @PathVariable("userId")String userId) {
		
		MUser user = userService.getUserOne(userId);
		user.setPassword(null);
		//管理者Mapを取得
//		Map<String, Integer> roleMap = applicationService.getRoleMap();
//		model.addAttribute("roleMap", roleMap);
		
		//体調Mapを取得
		Map<String, Integer> conditionMap = applicationService.getConditionMap();
		model.addAttribute("conditionMap", conditionMap);
		
		form = modelMapper.map(user, UserDetailForm.class);
		form.setDataList(user.getDataList());
		form.setUserGoal(user.getUserGoal());
	
		model.addAttribute("userDetailForm", form);
		
		//画面遷移
		return "admin/detail";
	}
	
	//ユーザー更新処理
	@PostMapping(value = "/detail", params = "update")
	public String updateUser(UserDetailForm form, Model model) {
		//ユーザー更新
		userService.updateUserOne(form.getUserId(), 
								  form.getPassword(),
								  form.getUserName(),
								  form.getRole()
								  );
		
		return "redirect:/admin/top";
	}
	
	//ユーザー消去処理
	@PostMapping(value = "/detail", params = "delete")
	public String deleteUser(UserDetailForm form, Model model) {
		//ユーザー消去処理
		userService.deleteUserOne(form.getUserId());
		
		return "redirect:/admin/top";
	}
	

}
