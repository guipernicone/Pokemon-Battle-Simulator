package com.guipernicone.pbs.User.Controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guipernicone.pbs.User.User;
import com.guipernicone.pbs.User.UserRepository;
import com.guipernicone.pbs.User.Controller.Form.CreateUserForm;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserRepository userRepository;
	
	@PostMapping("/{id}")
	public ResponseEntity<?> createUser(@PathVariable String id, @RequestBody @Valid CreateUserForm createUserForm) {
		
		Optional<User> optionalUser = userRepository.findById(id);
		System.out.println("create user");
		System.out.println(id);
		System.out.println(optionalUser.isPresent());
		if (optionalUser.isPresent())
		{
			User requestUser = optionalUser.get();
			
			if (requestUser.getRole().equals("ADMIN")) {
				
				Optional<User> usersIdenticalEmail = userRepository.findByEmail(createUserForm.getEmail());
				
				if (usersIdenticalEmail.isEmpty()) {
					BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
					User user = new User();
					user.setEmail(createUserForm.getEmail());
					user.setName(createUserForm.getName());
					user.setUsername(createUserForm.getUsername());
					user.setPassword(encoder.encode(createUserForm.getPassword()));
					user.setRole("USER");
					
					userRepository.save(user);
					
					return ResponseEntity.status(HttpStatus.CREATED).build();
				}
				
				return ResponseEntity.status(HttpStatus.CONFLICT).body("Email already registered");
			}
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Only admins can create users");
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Request User not found");
	}
	
	@GetMapping
	public ResponseEntity<?> getUser() {
		
		return ResponseEntity.ok("ok");
	}
	
	@DeleteMapping
	public ResponseEntity<?> deleteUser() {
		
		return ResponseEntity.ok("ok");
	}
	
	@PutMapping
	public ResponseEntity<?> updateUser() {
		
		return ResponseEntity.ok("ok");
	}
}
