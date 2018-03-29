package com.ldyp.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import com.ldyp.entity.Usr;
@Repository
public class UsrDaoImpl implements UsrDao {

	@Resource
	private SessionFactory sessionFactory;
	
	@Override
	public void addUsr(Usr usr) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().save(usr);
	}

	@Override
	public void delUsr(Usr usr) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().delete(usr);
	}

	@Override
	public void UpdateUsr(Usr usr) {
		// TODO Auto-generated method stub
		this.sessionFactory.getCurrentSession().update(usr);
	}

	@Override
	public List<Usr> list() {
		// TODO Auto-generated method stub
		List<Usr> userList = (List<Usr>) this.sessionFactory.getCurrentSession().createQuery("from Usr").list();
		return userList;
	}

}
