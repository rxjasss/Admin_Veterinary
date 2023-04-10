package com.example.demo.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class User {
	@Id
	@GeneratedValue
	private int id;
	@Column(name = "username", unique = true, nullable = false)
	private String username;
	private String name;
	private String surname;
	@Column(name = "password", nullable = false)
	private String password;
	private boolean enabled;
	private String role;
	private String token;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "id_user")
	private List<Pet> petList;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "id_user")
	private List<Report> reportList;

	public User() {
		super();
	}

	public User(int id, String username, String name, String surname, String password, boolean enabled, String role,
			String token, List<Pet> petList) {
		super();
		this.id = id;
		this.username = username;
		this.name = name;
		this.surname = surname;
		this.password = password;
		this.enabled = enabled;
		this.role = role;
		this.token = token;
		this.petList = petList;
	}

	public User(int id, String username, String name, String surname, String password, boolean enabled, String role,
			String token, List<Pet> petList, List<Report> reportList) {
		super();
		this.id = id;
		this.username = username;
		this.name = name;
		this.surname = surname;
		this.password = password;
		this.enabled = enabled;
		this.role = role;
		this.token = token;
		this.petList = petList;
		this.reportList = reportList;
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

	public List<Pet> getPetList() {
		return petList;
	}

	public void setPetList(List<Pet> petList) {
		this.petList = petList;
	}

	public List<Report> getReportList() {
		return reportList;
	}

	public void setReportList(List<Report> reportList) {
		this.reportList = reportList;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", name=" + name + ", surname=" + surname + ", password="
				+ password + ", enabled=" + enabled + ", role=" + role + ", token=" + token + ", petList=" + petList
				+ ", reportList=" + reportList + "]";
	}

}