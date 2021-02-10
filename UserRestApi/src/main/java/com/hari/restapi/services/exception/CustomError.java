package com.hari.restapi.services.exception;

import lombok.Data;

@Data
public class CustomError {
	
	private String errorCode;
	
	private String errorMessage;
	
	public CustomError(String errorCode,String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

}
