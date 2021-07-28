package com.example.model;




import java.util.Date;
import java.util.List;

import groovy.transform.ToString;
import lombok.Data;


@Data
@ToString(includes = {"dataList"})
public class MUser {
	private String userId;
	
	private String password;
	
	private String userName;
	
	private Date birthday;
	
	private Integer age;
	
	private Integer gender;
	
	private String role;
	
	private Region regionId;
	
	private List<UData> dataList;
	
	private UGoal userGoal;
	

}
