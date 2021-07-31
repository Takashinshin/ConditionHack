package com.example.form;

import java.util.List;

import com.example.model.UData;
import com.example.model.UGoal;

import lombok.Data;

@Data
public class UserTopForm {
	
	private String userId;
	
	private String userName;
	
	private List<UData> dataList;
	
	private UGoal userGoal;

}
