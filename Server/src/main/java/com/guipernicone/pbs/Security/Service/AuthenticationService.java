package com.guipernicone.pbs.Security.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.guipernicone.pbs.User.User;
import com.guipernicone.pbs.User.UserRepository;

@Service
public class AuthenticationService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	/**
	 * Validate if the email exist
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<User> user = userRepository.findByEmail(username);
		
		if (user.isPresent()) {
			return user.get();
		}
		
		throw new UsernameNotFoundException("Invalid e-mail");
	}
	
}
