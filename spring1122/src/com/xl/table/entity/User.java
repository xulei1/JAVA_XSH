package com.xl.table.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.criteria.Order;

@Entity
@Table(name="User")
public class User {
	private int id;
	private String name;
	private int age;
	private String sex;
	private String address;
	private UserLogin userlogin;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@OneToOne(mappedBy="user")

	public UserLogin getUserlogin() {
		return userlogin;
	}
	public void setUserlogin(UserLogin userlogin) {
		this.userlogin = userlogin;
	}
	
	

	
}
