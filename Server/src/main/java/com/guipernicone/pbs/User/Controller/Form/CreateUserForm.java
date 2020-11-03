package com.guipernicone.pbs.User.Controller.Form;

import javax.validation.constraints.NotNull;

public class CreateUserForm {

	@NotNull
	private String email;
	@NotNull
	private String password;
	@NotNull
	private String name;
	@NotNull
	private String username;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Override
	public String toString() {
		return "CreateUserForm [email=" + email + ", password=" + password + ", name=" + name + ", username=" + username
				+ "]";
	}
	
	
}
