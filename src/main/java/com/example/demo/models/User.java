package com.example.demo.models;

public class User {
	private int id;
	private String username;
	private String name;
	private String surname;
	private String password;
	private boolean enabled;
	private String role;
	private String token;

	public User() {
		super();
	}

	public User(int id, String username, String name, String surname, String password, boolean enabled, String role,
			String token) {
		super();
		this.id = id;
		this.username = username;
		this.name = name;
		this.surname = surname;
		this.password = password;
		this.enabled = enabled;
		this.role = role;
		this.token = token;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", name=" + name + ", surname=" + surname + ", password="
				+ password + ", enabled=" + enabled + ", role=" + role + ", token=" + token + "]";
	}

}