package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "category")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
//	@Column(name = "categoryid")
	private Integer categoryID ;
	@Column(name = "name")
	private String name;
	public Integer getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(Integer categoryID) {
		this.categoryID = categoryID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Category(Integer categoryID, String name) {
		super();
		this.categoryID = categoryID;
		this.name = name;
	}
	public Category() {
		super();
	}

}
