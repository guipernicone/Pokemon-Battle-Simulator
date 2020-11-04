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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.guipernicone.pbs.User.User;
import com.guipernicone.pbs.User.UserRepository;
import com.guipernicone.pbs.User.Controller.Dto.UserInfoDto;
import com.guipernicone.pbs.User.Controller.Form.CreateUserForm;
import com.guipernicone.pbs.User.Controller.Form.UpdateUserForm;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserRepository userRepository;
	
	@PostMapping("/{id}")
	public ResponseEntity<?> createUser(@PathVariable String id, @RequestBody @Valid CreateUserForm createUserForm) {
		
		Optional<User> optionalUser = userRepository.findById(id);

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
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getUser(@PathVariable String id) {
		
		Optional<User> optionalUser = userRepository.findById(id);

		if (optionalUser.isPresent())
		{
			User user = optionalUser.get();
			
			UserInfoDto userDto = new UserInfoDto();
			userDto.setId(user.getId());
			userDto.setName(user.getName());
			userDto.setEmail(user.getEmail());
			userDto.setUsername(user.getUsername());
			userDto.setRole(user.getRole());
			
			return ResponseEntity.ok(userDto);
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable String id, @RequestParam String delId) {
		
		Optional<User> optionalUser = userRepository.findById(id);

		if (optionalUser.isPresent())
		{
			User requestUser = optionalUser.get();
			
			if (requestUser.getRole().equals("ADMIN")) {
				userRepository.deleteById(delId);
				return ResponseEntity.ok("User deleted");
			}
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Only admins can delete users");
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Request User not found");
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateUser(@PathVariable String id, @RequestBody @Valid UpdateUserForm userForm) {
		
		Optional<User> optionalUser = userRepository.findById(id);

		if (optionalUser.isPresent())
		{
			User requestUser = optionalUser.get();
			User user = new User();
			user.setId(requestUser.getId());
			user.setEmail(requestUser.getEmail());
			user.setName(userForm.getName());
			user.setUsername(userForm.getUsername());
			user.setPassword(requestUser.getPassword());
			user.setRole(requestUser.getRole());
			
			userRepository.save(user);
			return ResponseEntity.ok("User Updated");
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
	}
}
