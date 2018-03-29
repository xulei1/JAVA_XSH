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
	/**
	 * @author ZChi
	 * @version 1.0
	 * show 向用户输入的手机号发送验证码
	 * @param phoneId 手机号
	 * @return 短信已经发送，请注意查收
	 */
	@RequestMapping("/sendCode")
	@ResponseBody
	public Map<String,String> sendCode(@RequestParam String phoneId) {
		VerCode verCode = new VerCode();
		String yzcode = verCode.getCode();
		String code = "【校美好】验证码:"+yzcode+"此验证码10分钟有效"+"如飞本人操作，请忽略本短信";
		Map<String,String> map = new HashMap();
		
		try {
			int appid = 1400078692;
			String appkey = "012b65900c25c5f049d27b0a4fb77787";
			
			//初始化单发
            SmsSingleSender singleSender = new SmsSingleSender(appid, appkey);
            SmsSingleSenderResult singleSenderResult;
		    
            //普通发单
            singleSenderResult = singleSender.send(0, "86",phoneId , code, "", "");
		    System.out.print(singleSenderResult);
		    		    
		    String sign = "短信以经发送,请注意查收";
		    map.put("sign", sign);
		   
		    
		    //发送 通知内容
		    
		    
			} catch (Exception e) {
				e.printStackTrace();
		}
		 return map;
	}
	
	@RequestMapping("/testCode")
	@ResponseBody
	public Map<String,String> testCode(@RequestParam String code,@RequestParam String phoneId){
		
		Usr usr = this.usrServiceImpl.getUsrByPhone(phoneId);
		if(usr.getPhone() == null) {  //不存在就帮该用户创建一个此手机账号
			usr.setPhone(phoneId);
			this.usrServiceImpl.addUsr(usr);
		}else {   //验证code
			
		}
		
	}
	
}
