package com.example.controller;

import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.application.service.ApplicationService;
import com.example.form.SignupForm;
import com.example.model.MUser;
import com.example.service.impl.UserServiceImpl;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/user")
@Slf4j
public class SignupController {
	
	@Autowired
	private ApplicationService applicationService;
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	//ユーザー登録画面表示
	@GetMapping("/signup")
	public String getSignup(Model model, @ModelAttribute SignupForm form) {
		//性別Mapを取得
		Map<String, Integer> genderMap =applicationService.getGenderMap();
		model.addAttribute("genderMap", genderMap);	
		
		//管理者Mapを取得
		Map<String, Integer> roleMap = applicationService.getRoleMap();
		model.addAttribute("roleMap", roleMap);
		
		//画面遷移
		return "user/signup";
	}
	
	//ユーザー登録処理
	@PostMapping("/signup")
	public String postSignup(@ModelAttribute SignupForm form, Model model, BindingResult bindingResult) {
		
		//model.addattribute("signupForm", form)があるイメージ
		//入力チェック
		if(bindingResult.hasErrors()) {
			return "/user/signup";
		}
		//ログ出力
		log.info(form.toString());
		
		MUser user = modelMapper.map(form, MUser.class);
		userServiceImpl.Signup(user);
		
		return "redirect:/";
	}
}
