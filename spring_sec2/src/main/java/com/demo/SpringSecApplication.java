package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.CommandLinePropertySource;

import com.demo.dao.UserEntity;
import com.demo.service.UserService;

@SpringBootApplication
public class SpringSecApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringSecApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		UserEntity userEntity=new UserEntity("raj", "raj123", "raj@gmail.com");
		userEntity.getRoles().add("ROLE_ADMIN");
		
		UserEntity userEntity2=new UserEntity("ekta", "ekta123", "ekta@gmail.com");
		userEntity2.getRoles().add("ROLE_MGR");
		
		UserEntity userEntity3=new UserEntity("gun", "gun123", "gun@gmail.com");
		userEntity3.getRoles().add("ROLE_CLERK");
		
		userService.addUserEntity(userEntity);
		userService.addUserEntity(userEntity2);
		userService.addUserEntity(userEntity3);
		
		
	}

}
