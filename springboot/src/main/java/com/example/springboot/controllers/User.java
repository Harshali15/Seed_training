package com.example.springboot.controllers;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "bot_users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOOT_USER_SEQ")
	@SequenceGenerator(sequenceName = "customer_seq", allocationSize = 1, name = "BOOT_USER_SEQ")
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	private String name;
	private String email;

	@Column(name = "created_date")
	private Date creationDate;

	User(int id, String name, String email,Date creationDate) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.creationDate=creationDate;
	}

	User(){
		
	}
}
