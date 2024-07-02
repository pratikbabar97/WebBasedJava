package com.recipe.dto;

import java.time.LocalDateTime;

public class ApiResponse {
	private String msg;
	private LocalDateTime tsp;
	public ApiResponse(String msg) {
		super();
		this.msg = msg;
		this.tsp = LocalDateTime.now();
	}
	
	
}
