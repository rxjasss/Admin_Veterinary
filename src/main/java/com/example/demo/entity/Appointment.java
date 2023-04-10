package com.example.demo.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Appointment {
	@Id
	@GeneratedValue
	private int id;
	
	@OneToOne
	@JoinColumn(name = "id_pet")
	private Pet id_pet; 

	private String hour;
	private Date date;
	
	public Appointment() {
		super();
	}

	public Appointment(int id, Pet id_pet, String hour, Date date) {
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

	public Pet getId_pet() {
		return id_pet;
	}

	public void setId_pet(Pet id_pet) {
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
		return "Appointment [id=" + id + ", id_pet=" + id_pet + ", hour=" + hour + ", date=" + date + "]";
	}

	
}
