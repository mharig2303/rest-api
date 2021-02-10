package com.hari.restapi.services.repository.user;

import java.util.List;
import java.util.Optional;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hari.restapi.services.repository.user.domain.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer>{
	
	@Cacheable
    Optional<User> findByUserId(String userId);
	
	@Query("select u from User u where userId = ?1 and password = ?2")
	Optional<User> authUser(String userName,String password);
	
	@Query("select u from User u where u.status = ?1")
	List<User> findUsersByStatus(String status);
}
