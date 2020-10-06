package com.guipernicone.pbs.Security.Controller;

import javax.naming.AuthenticationException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guipernicone.pbs.Form.UserLoginForm;
import com.guipernicone.pbs.Security.Service.TokenService;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private TokenService tokenService;

	@PostMapping("/user")
	public ResponseEntity<String> userAuthentication(@RequestBody @Valid UserLoginForm userLoginForm){
		System.out.println(userLoginForm.toString());
		
		UsernamePasswordAuthenticationToken logingToken = userLoginForm.toUsernamePasswordAuthenticationToken();
		System.out.println("indo");
		Authentication authentication = authManager.authenticate(logingToken);
		System.out.println("passo");
		String token = tokenService.generateToken(authentication);
		return ResponseEntity.ok(token);
	}
}
