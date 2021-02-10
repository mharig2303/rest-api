package com.hari.restapi.services.biz.service.user;

import java.util.List;

import com.hari.restapi.services.repository.user.domain.User;

public interface UserService {

	User authenticate(User user);
	List<User> getAllUsers();
	User addUser(User user);
	User updateUser(User user);
	Boolean deleteUser(Integer id);
}
