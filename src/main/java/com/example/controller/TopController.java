package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.MUser;
import com.example.service.UserService;

@Controller
@RequestMapping("/user")
public class TopController {
	
	@Autowired
	private UserService useService;
	
	
	//top画面を表示
	@GetMapping("/top")
	public String getUserData(Model model) {
		
		//ユーザー一覧取得
		List<MUser> userList = useService.getUsers();
		model.addAttribute("userList", userList);
		
		return "user/top";
	}

}
