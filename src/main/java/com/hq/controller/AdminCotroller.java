package com.hq.controller;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hq.pojo.Admin;
import com.hq.service.AdminService;

import Mytils.LoginStatus;

@Controller
public class AdminCotroller {
	@Autowired
	AdminService adminServiceImpl;
	
	@RequestMapping("/api/loginCheck")
	@ResponseBody
	public int login(Admin admin,HttpSession session) {
		 LoginStatus status = adminServiceImpl.login(admin, session);
		 
		 return status.Status;
	}
	
	@RequestMapping("main")
	public String main() {
		return "main";
	}
	

}
