package com.demo.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dao.UserEntity;
import com.demo.dao.UserRepo;
@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private UserRepo userRepo;
	
	@Override
	public UserEntity findByUsername(String username) {
		return userRepo.findByUsername(username);
	}

	@Override
	public void addUserEntity(UserEntity userEntity) {
		System.out.println("---------------");
		System.out.println(userEntity);
		userEntity.setPassword(encoder.encode(userEntity.getPassword()));
		userRepo.save(userEntity);
	}
}
