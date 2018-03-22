package com.xl.table.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class student {
	@Column(insertable=false,updatable=false)
	private int id;
	private String name;
	private int grad;
	private banji banji;
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
	public int getGrad() {
		return grad;
	}
	public void setGrad(int grad) {
		this.grad = grad;
	}
	@ManyToOne
	@JoinColumn(name="id")
	public banji getBanji() {
		return banji;
	}
	public void setBanji(banji banji) {
		this.banji = banji;
	}
	
	
}
