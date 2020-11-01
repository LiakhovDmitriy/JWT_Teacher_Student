package com.gmail.dimaliahov.security;

import com.gmail.dimaliahov.model.User;
import com.gmail.dimaliahov.security.jwt.JwtUser;
import com.gmail.dimaliahov.security.jwt.JwtUserFactory;
import com.gmail.dimaliahov.service.serviceForClass.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JwtUserDetailsService implements UserDetailsService
{

	private final UserService userService;

	@Autowired
	public JwtUserDetailsService (UserService userService)
	{
		this.userService = userService;
	}

	@Override
	public UserDetails loadUserByUsername (String username) throws UsernameNotFoundException
	{
		User user = userService.findByUsername(username);

		if (user == null)
		{
			throw new UsernameNotFoundException("User with userName: " + username + " not found");
		}

		JwtUser jwtUser = JwtUserFactory.create(user);
		log.info("IN loadUserByUserName - user with username: {} successfully loaded", username);
		return jwtUser;
	}

}
