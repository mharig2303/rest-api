package com.hari.restapi.services.biz.service.user.domain.mapper;

import org.springframework.stereotype.Component;

import com.hari.restapi.services.biz.service.user.domain.UserDTO;
import com.hari.restapi.services.repository.user.domain.User;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;

@Component
public class UserMapper extends ConfigurableMapper {
	
	@Override
	protected void configure(MapperFactory factory) {
		factory.classMap(User.class, UserDTO.class).byDefault().register();
	}

}
