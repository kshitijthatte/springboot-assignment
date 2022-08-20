package com.demo.config;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import com.demo.dao.UserEntity;

//i will convert UserEntity to SecUser, this class is used for that purpose
public class SecUser implements UserDetails {

	private static final long serialVersionUID = -8219845201603178938L;
	private UserEntity userEntity;

	public SecUser(UserEntity userEntity) {
		this.userEntity=userEntity;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<String> roles = userEntity.getRoles();
		//arry to list
		String rolesNames[]=roles.toArray(new String[roles.size()]);
		
		return AuthorityUtils.createAuthorityList(rolesNames);
	}

	@Override
	public String getPassword() {
		return userEntity.getPassword();
	}

	@Override
	public String getUsername() {
		return userEntity.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
