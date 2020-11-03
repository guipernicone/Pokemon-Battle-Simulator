package com.guipernicone.pbs.Security.Controller.Form;

import javax.validation.constraints.NotNull;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class UserLoginForm {

	@NotNull
	private String email;
	
	@NotNull
	private String password;
	
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "UserLoginForm [email=" + email + ", password=" + password + "]";
	}

	public UsernamePasswordAuthenticationToken toUsernamePasswordAuthenticationToken() {
		// TODO Auto-generated method stub
		return new UsernamePasswordAuthenticationToken(this.email, this.password);
	}
	
	
}
