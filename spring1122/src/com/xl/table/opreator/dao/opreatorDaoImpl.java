package com.xl.table.opreator.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.xl.table.entity.User;
import com.xl.table.entity.UserLogin;
import com.xl.table.entity.power;
import com.xl.table.entity.role;

@Repository
public class opreatorDaoImpl {
	@Resource
	private SessionFactory sessionfactory;
	
	public List<UserLogin> findAll(){
		Query q = this.sessionfactory.getCurrentSession().createQuery(" from UserLogin");
		return  q.list();
	}
	public List<User> findAll1(){
		Query q = this.sessionfactory.getCurrentSession().createQuery(" from User");
		return  q.list();
	}
	public List<power> findAll2(){
		Query q = this.sessionfactory.getCurrentSession().createQuery(" from power");
		return  q.list();
	}
}
