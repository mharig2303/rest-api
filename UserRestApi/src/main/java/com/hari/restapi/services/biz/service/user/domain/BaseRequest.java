package com.hari.restapi.services.biz.service.user.domain;

import java.io.Serializable;

import lombok.Data;

@Data
public class BaseRequest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private RequestHeader requestHeader;
}
