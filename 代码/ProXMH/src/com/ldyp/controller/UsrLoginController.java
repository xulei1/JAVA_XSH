package com.ldyp.controller;
import com.github.qcloudsms.*;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.annotations.Source;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ldyp.entity.Usr;
import com.ldyp.service.UsrServiceImpl;
import com.ldyp.util.VerCode;

@Controller
public class UsrLoginController {
	@Source
	private UsrServiceImpl usrServiceImpl;
	
	
	/**
	 * 
	 * 	@author ZChi
	 * 	@version 1.0
	 * 	show ������ͨ��½���ֻ�����Ϊ�˺ţ������½����½�ɹ���usr�������session
	 * 	@param usr ǰ�˴���usr����
	 *  @return sign����½��ʾ��
	 *  
	 */
	@RequestMapping("/ordinaryLogin")
	@ResponseBody
	public Map<String,String> ordinaryLogin(@ModelAttribute Usr usr,HttpServletRequest request) throws UnsupportedEncodingException {
		HttpSession session = request.getSession();
		Map<String, String> map = new HashMap<String, String>();
		String sign = null;
		Usr uuser = this.usrServiceImpl.getUsr(usr);
		if(uuser==null) {
			sign="�û���������";
			map.put("sign", sign);
			return map;
		}
		boolean bool = this.usrServiceImpl.isNull(usr, uuser);
		if(bool==true) {
			sign="�ɹ���½";
		}else {
			sign="���벻��ȷ";
		}
		map.put("sign", sign);
		session.setAttribute("user", usr);
		return map;
	}
	@RequestMapping("/phoneLogin")
	@ResponseBody
	public Map<String,String> phoneLogin(@RequestParam int phoneId) {
		VerCode verCode = new VerCode();
		String code = verCode.getCode();
		try {
		    SmsSingleSender sender = new   SmsSingleSender(appid, "replace with key");
		    SmsSingleSenderResult result = sender.send(0, "86", "18326693192", "����Ѷ����֤�����1234", "", "123");
		    System.out.print(result);
			} catch (Exception e) {
				e.printStackTrace();
		}
	}
	
}
