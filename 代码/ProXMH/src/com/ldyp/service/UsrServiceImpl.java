package com.ldyp.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ldyp.dao.UsrDao;
import com.ldyp.entity.Usr;
import com.ldyp.util.Base64Util;

@Service
public class UsrServiceImpl {
	@Resource
	private UsrDao usrDao;
	
	public boolean addUsr(Usr Usr) {
		this.usrDao.addUsr(Usr);
		return true;
	}
	public boolean delUsr(Usr Usr) {
		this.usrDao.delUsr(Usr);
		return true;
	}
	public boolean updateUsr(Usr Usr) {
		this.usrDao.UpdateUsr(Usr);
		return true;
	}
	public List<Usr> list(){
		return this.usrDao.list();
	}
	/**
	 * 
	 * @author ZChi
	 * @version 1.0
	 * @show 判断数据库中是否有对应的usr对象，yes返回数据库对象，no返回null
	 * @param usr 前台传入的对象
	 * @return 数据库中的usr对象，没有返回null 
	 * 
	 */
	public Usr getUsr(Usr usr) {
		String usrPhone = usr.getPhone();
		List<Usr> list = this.usrDao.list();
		for(int i = 0;i < list.size();i++) {
			if(list.get(i).getPhone().equals(usrPhone)) {
				return list.get(i);
			}
		}
		return null;
	}
	/**
	 * 
	 * 	@author ZChi
	 * 	@version 1.0
	 * 	show 判断用户密码是否正确
	 *  @param usr前台对象
	 *  @param dbUsr数据库对象
	 *  @return true/false
	 *  
	 */
	public Boolean isNull(Usr usr,Usr dbUsr) throws UnsupportedEncodingException {
		Base64Util base64Util = new Base64Util();
		String password = base64Util.decode(usr.getPassword());
		if(password.equals(dbUsr.getPassword())) {
			return true;
		}
		return false;
	}
	
	
}
