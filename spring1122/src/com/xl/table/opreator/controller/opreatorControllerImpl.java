package com.xl.table.opreator.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xl.table.entity.User;
import com.xl.table.entity.UserLogin;
import com.xl.table.entity.power;
import com.xl.table.entity.role;

@Controller
@RequestMapping("role")
public class opreatorControllerImpl {
	
	@Resource
	private com.xl.table.opreator.service.opreatorServiceImpl opreatorServiceImpl;
	@RequestMapping("/list")
	public String list1(Model model) {
		List<User> list = this.opreatorServiceImpl.listall1();
		model.addAttribute("list1", list);
		return "list1";
	}
	@RequestMapping("/list1")
	public String list(Model model) {
		List<UserLogin> list = this.opreatorServiceImpl.listall();
		model.addAttribute("list", list);
		return "list";
	}
	@RequestMapping("/list2")
	public String list2(Model model) {
		List<power> list = this.opreatorServiceImpl.listall2();
		model.addAttribute("list2", list);
		return "list2";
		
	}
}
