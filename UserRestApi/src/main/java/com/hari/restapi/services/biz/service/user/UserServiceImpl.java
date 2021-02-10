package com.hari.restapi.services.biz.service.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hari.restapi.services.repository.user.UserDao;
import com.hari.restapi.services.repository.user.domain.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public User authenticate(User user) {
		Optional<User> result = userDao.authUser(user.getUserId(),user.getPassword());
		return result.isPresent() ? result.get() : null;
	}
	
	@Override
	public List<User> getAllUsers(){
		return userDao.findAll();
	}
	
	@Override
	public User addUser(User user) {
		return userDao.saveAndFlush(user);
	}
	
	@Override
	public User updateUser(User user) {
		return addUser(user);
	}
	 
	@Override
	public Boolean deleteUser(Integer id) {
		userDao.deleteById(id);
		return true;
	}
}
