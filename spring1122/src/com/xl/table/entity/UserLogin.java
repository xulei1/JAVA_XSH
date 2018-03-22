package com.xl.table.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="UserLogin")
public class UserLogin {
	private int id;
	private String zhanghao;
	private String mima;
	private User user;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getZhanghao() {
		return zhanghao;
	}
	public void setZhanghao(String zhanghao) {
		this.zhanghao = zhanghao;
	}
	public String getMima() {
		return mima;
	}
	public void setMima(String mima) {
		this.mima = mima;
	}
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="UserID")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
