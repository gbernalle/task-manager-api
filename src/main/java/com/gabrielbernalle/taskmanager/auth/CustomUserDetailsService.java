package com.gabrielbernalle.taskmanager.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.gabrielbernalle.taskmanager.entities.User;
import com.gabrielbernalle.taskmanager.repository.UserRepository;

public class CustomUserDetailsService implements UserDetailsService{
	private final UserRepository userRepository;

	public CustomUserDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(username)
				.orElseThrow(()->
				new UsernameNotFoundException("User not found")
				);
		return new CustomUserDetails(user);	
	}
}
