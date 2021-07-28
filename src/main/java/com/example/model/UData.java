package com.example.model;

import java.sql.Time;
import java.util.Date;

import lombok.Data;


@Data
public class UData {
	
	 private String userId;
	 
	 private Date dataDate;
	 
	 private Integer condition;
	 
	 private Double weight;
	 
	 private Time sleepTime;
	 
	 private Integer kcal;
}
