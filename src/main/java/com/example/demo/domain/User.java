package com.example.demo.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "User")
public class User implements Serializable {
	@Id
	private String id;

	@Column(name = "name")
	private String name;

	@Column(name = "password")
	private Integer password;

	public User() {
	}

	public User(String id, String name, Integer password) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPassword() {
		return password;
	}

	public void setPassword(Integer password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "UserBase [id=" + id + ", name=" + name + ", password=" + password + "]";
	}

}
