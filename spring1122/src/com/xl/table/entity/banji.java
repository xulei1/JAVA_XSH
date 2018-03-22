package com.xl.table.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

@Entity
@Table(name="class")
public class banji {
	private int id;
	private String name;
	private Set orderSet = new HashSet<student>();

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
	@OneToMany(mappedBy="banji", targetEntity=student.class, 
	        cascade=CascadeType.ALL)
	@OrderColumn(name="id") 
	public Set getOrderSet() {
		return orderSet;
	}

	public void setOrderSet(Set orderSet) {
		this.orderSet = orderSet;
	}
}
