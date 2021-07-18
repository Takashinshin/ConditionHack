package com.example.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.application.service.ApplicationService;

@Controller
@RequestMapping("/user")
public class SignupController {
	
	@Autowired
	private ApplicationService applicationService;
	
	//ユーザー登録画面表示
	@GetMapping("/signup")
	public String getSignup(Model model) {
		//性別Mapを取得
		Map<String, Integer> genderMap =applicationService.getGenderMap();
		model.addAttribute("genderMap", genderMap);	//Modelに格納
		
		//画面遷移
		return "user/signup";
	}
	
	//ユーザー登録処理
	@PostMapping("/signup")
	public String postSignup() {
		
		return "redirect:/login";
	}
	
	
	
	

}
