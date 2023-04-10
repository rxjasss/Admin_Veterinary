package com.example.demo.models;

import java.util.Date;

public class AppointmentDTO {
	private int id, id_pet;
	private String hour;
	private Date date;

	public AppointmentDTO() {
		super();
	}

	public AppointmentDTO(int id, int id_pet, String hour, Date date) {
		super();
		this.id = id;
		this.id_pet = id_pet;
		this.hour = hour;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_pet() {
		return id_pet;
	}

	public void setId_pet(int id_pet) {
		this.id_pet = id_pet;
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "AppointmentDTO [id=" + id + ", id_pet=" + id_pet + ", hour=" + hour + ", date=" + date + "]";
	}
}
