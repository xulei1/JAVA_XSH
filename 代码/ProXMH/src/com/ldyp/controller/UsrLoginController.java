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
	 * 	show 控制普通登陆（手机号作为账号，密码登陆）登陆成功将usr对象存入session
	 * 	@param usr 前端传来usr对象
	 *  @return sign（登陆提示）
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
			sign="用户名不存在";
			map.put("sign", sign);
			return map;
		}
		boolean bool = this.usrServiceImpl.isNull(usr, uuser);
		if(bool==true) {
			sign="成功登陆";
		}else {
			sign="密码不正确";
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
		    SmsSingleSenderResult result = sender.send(0, "86", "18326693192", "【腾讯】验证码测试1234", "", "123");
		    System.out.print(result);
			} catch (Exception e) {
				e.printStackTrace();
		}
	}
	
}
