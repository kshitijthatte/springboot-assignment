package com.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.demo.dao.UserEntity;
import com.demo.service.UserService;
@Service
public class DetailService implements UserDetailsService {

	@Autowired
	private UserService userService;
	//THIS METHOD WOULD BE CALLED BY SRPING SEC
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity= userService.findByUsername(username);
		if(userEntity==null) {
			throw new UsernameNotFoundException("user not found ");
		}
		//somehow i need to convert my UserEntity into the user that spring sec can understand
		return new SecUser(userEntity);
	}
}
