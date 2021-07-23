package com.example.form;

import java.util.Date;
import java.util.List;

import com.example.model.Region;
import com.example.model.UData;

import lombok.Data;

@Data
public class UserDetailForm {
	private String userId;
	
	private String password;
	
	private String userName;
	
	private  Date birthday;
	
	private Integer age;
	
	private Integer gender;
	
	private Integer role;
	
	private Region region;
	
}
