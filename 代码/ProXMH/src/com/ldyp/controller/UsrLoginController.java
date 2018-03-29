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
	/**
	 * @author ZChi
	 * @version 1.0
	 * show ���û�������ֻ��ŷ�����֤��
	 * @param phoneId �ֻ���
	 * @return �����Ѿ����ͣ���ע�����
	 */
	@RequestMapping("/sendCode")
	@ResponseBody
	public Map<String,String> sendCode(@RequestParam String phoneId) {
		VerCode verCode = new VerCode();
		String yzcode = verCode.getCode();
		String code = "��У���á���֤��:"+yzcode+"����֤��10������Ч"+"��ɱ��˲���������Ա�����";
		Map<String,String> map = new HashMap();
		
		try {
			int appid = 1400078692;
			String appkey = "012b65900c25c5f049d27b0a4fb77787";
			
			//��ʼ������
            SmsSingleSender singleSender = new SmsSingleSender(appid, appkey);
            SmsSingleSenderResult singleSenderResult;
		    
            //��ͨ����
            singleSenderResult = singleSender.send(0, "86",phoneId , code, "", "");
		    System.out.print(singleSenderResult);
		    		    
		    String sign = "�����Ծ�����,��ע�����";
		    map.put("sign", sign);
		   
		    
		    //���� ֪ͨ����
		    
		    
			} catch (Exception e) {
				e.printStackTrace();
		}
		 return map;
	}
	
	@RequestMapping("/testCode")
	@ResponseBody
	public Map<String,String> testCode(@RequestParam String code,@RequestParam String phoneId){
		
		Usr usr = this.usrServiceImpl.getUsrByPhone(phoneId);
		if(usr.getPhone() == null) {  //�����ھͰ���û�����һ�����ֻ��˺�
			usr.setPhone(phoneId);
			this.usrServiceImpl.addUsr(usr);
		}else {   //��֤code
			
		}
		
	}
	
}
