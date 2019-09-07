package com.hq.service;

import javax.servlet.http.HttpSession;

import com.hq.pojo.Admin;

import Mytils.LoginStatus;

public interface AdminService {
	
	LoginStatus login(Admin admin,HttpSession session);

}
