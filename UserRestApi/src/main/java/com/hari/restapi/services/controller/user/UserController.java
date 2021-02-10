package com.hari.restapi.services.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hari.restapi.services.biz.service.user.UserService;
import com.hari.restapi.services.biz.service.user.domain.ResponseStatus;
import com.hari.restapi.services.biz.service.user.domain.UserDTO;
import com.hari.restapi.services.biz.service.user.domain.UserResponse;
import com.hari.restapi.services.biz.service.user.domain.mapper.UserMapper;
import com.hari.restapi.services.exception.CustomError;
import com.hari.restapi.services.repository.user.domain.User;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private UserMapper userMapper;

	@RequestMapping(value = "/login", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE }, method = RequestMethod.POST)
	public ResponseEntity<?> authenticateUser(@RequestBody User user) {

		log.info("incoming request : "+user);
		HttpHeaders headers = new HttpHeaders();
		User resultUser = userService.authenticate(user);
		
		UserResponse response = new UserResponse();
		ResponseStatus responseStatus = new ResponseStatus();
		
		if (resultUser != null) {
			UserDTO domainUser = userMapper.map(resultUser, UserDTO.class);
			
			response.setUserDTO(domainUser);
			responseStatus.setStatusCode("200");
			responseStatus.setDescription("Success");
			response.setResponseStatus(responseStatus);
			log.info("response : " + response);
			return new ResponseEntity<>(response, headers, HttpStatus.OK);
		} else {
			responseStatus.setStatusCode("410");
			responseStatus.setDescription("Invalid Credentials");
			return new ResponseEntity<>(responseStatus, headers, HttpStatus.UNAUTHORIZED);
		}
	}

}
