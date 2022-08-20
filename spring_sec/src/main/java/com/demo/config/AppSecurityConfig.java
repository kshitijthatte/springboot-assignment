package com.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;

/*
 * if u want to customized spring sec ==> then u need the ref of AuthenticationManger ==> how u get AM==>AuthenticationMgt
Builder ==> by writing a custom class that extends WebSecurityConfigAdaptor
 */
@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

	//Authentication
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("raj").password("raj123").roles("ADMIN")
		.and()
		.withUser("ekta").password("ekta123").roles("MGR")
		.and()
		.withUser("gun").password("gun123").roles("CLERK");
	}
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	//Authorization
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers("/admin/**").hasAnyRole("ADMIN")
		.antMatchers("/mgr/**").hasAnyRole("ADMIN","MGR")
		.antMatchers("/clerk/**").hasAnyRole("ADMIN","MGR","CLERK")
		.antMatchers("/home/**").permitAll()
		.and().httpBasic()
		.and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
	}
	
	

}





