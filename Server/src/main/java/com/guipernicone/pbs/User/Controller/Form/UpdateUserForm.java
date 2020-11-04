package com.guipernicone.pbs.User.Controller.Form;

import javax.validation.constraints.NotNull;

public class UpdateUserForm {

	@NotNull
	private String name;
	@NotNull
	private String username;
	
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
		return "CreateUserForm [name=" + name + ", username=" + username + "]";
	}
	
	
}
