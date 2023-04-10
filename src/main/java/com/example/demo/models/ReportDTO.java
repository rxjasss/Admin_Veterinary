package com.example.demo.models;

public class ReportDTO {
	private int id, id_user;
	private String description;
	
	public ReportDTO() {
		super();
	}

	public ReportDTO(int id, int id_user, String description) {
		super();
		this.id = id;
		this.id_user = id_user;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "ReportDTO [id=" + id + ", id_user=" + id_user + ", description=" + description + "]";
	}
}
