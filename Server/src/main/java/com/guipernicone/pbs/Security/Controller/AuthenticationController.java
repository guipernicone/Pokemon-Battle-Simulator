package com.guipernicone.pbs.Security.Controller;

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
import com.guipernicone.pbs.Security.Controller.Dto.TokenDto;
import com.guipernicone.pbs.Security.Service.TokenService;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private TokenService tokenService;

	@PostMapping("/user")
	public ResponseEntity<TokenDto> userAuthentication(@RequestBody @Valid UserLoginForm userLoginForm){

		UsernamePasswordAuthenticationToken logingToken = userLoginForm.toUsernamePasswordAuthenticationToken();
		Authentication authentication = authManager.authenticate(logingToken);
		String token = tokenService.generateToken(authentication);
		
		return ResponseEntity.ok(new TokenDto(token, "Bearer"));
	}
}
