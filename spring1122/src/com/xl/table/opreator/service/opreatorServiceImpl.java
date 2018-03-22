package com.xl.table.opreator.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xl.table.entity.User;
import com.xl.table.entity.UserLogin;
import com.xl.table.entity.power;
import com.xl.table.entity.role;
import com.xl.table.opreator.dao.*;

@Service
@Transactional(readOnly=true)
public class opreatorServiceImpl {
	
	@Resource
	private opreatorDaoImpl opreatorDaoImpl;
	 
	public List<UserLogin> listall(){
		return opreatorDaoImpl.findAll();
	}
	public List<User> listall1(){
		return opreatorDaoImpl.findAll1();
	}
	public List<power> listall2(){
		return opreatorDaoImpl.findAll2();
	}
}
