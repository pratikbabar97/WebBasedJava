package com.reserve.dto;

import java.time.LocalDateTime;

public class ApiResponse {
	private String messg;
	private LocalDateTime stmp;
	public ApiResponse(String messg) {
		super();
		this.messg = messg;
		this.stmp = LocalDateTime.now();
	}
	

}
