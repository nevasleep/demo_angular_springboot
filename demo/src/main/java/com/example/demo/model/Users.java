package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USERS")
public class Users {

	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int ID;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="USERNAME")
	private String username;
	
	
	
	
	public Users() {
	}


	public Users(String name, String password, String username) {
		super();
		this.name = name;
		this.password = password;
		this.username = username;
	}


	public Users(int iD, String name, String password, String username) {
		super();
		ID = iD;
		this.name = name;
		this.password = password;
		this.username = username;
	}


	public int getID() {
		return ID;
	}


	public void setID(int iD) {
		ID = iD;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}
	
}
