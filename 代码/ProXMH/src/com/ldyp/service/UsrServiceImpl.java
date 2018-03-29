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
	 * @show �ж����ݿ����Ƿ��ж�Ӧ��usr����yes�������ݿ����no����null
	 * @param usr ǰ̨����Ķ���
	 * @return ���ݿ��е�usr����û�з���null 
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
	 * 	show �ж��û������Ƿ���ȷ
	 *  @param usrǰ̨����
	 *  @param dbUsr���ݿ����
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
