package com.example.form;



import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class SignupForm {
	
	
	private String userId;
	
	private String password;
	
	private String userName;
	
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private String birthday;
	
	private Integer age;
	
	private Integer gender;
	
	private Integer role;

}
