package com.xl.table.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="power")
public class power {
	private int id;
	private String powername;
	private role role;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPowername() {
		return powername;
	}
	public void setPowername(String powername) {
		this.powername = powername;
	}
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="roleID")
	public role getRole() {
		return role;
	}
	public void setRole(role role) {
		this.role = role;
	}
	
}
