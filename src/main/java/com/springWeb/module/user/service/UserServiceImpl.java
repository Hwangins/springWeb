package com.springWeb.module.user.service;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.springWeb.module.user.repository.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Resource(name = "userRepository")
	private UserRepository userRepository;
	
	@Override
	public void join() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void login() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void logout() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertAuthCode(Map<String, Object> param) throws Exception{
		userRepository.insertAuthCode(param);
	}

}
