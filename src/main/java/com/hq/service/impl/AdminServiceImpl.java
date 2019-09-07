package com.hq.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hq.mapper.AdminMapper;
import com.hq.pojo.Admin;
import com.hq.pojo.AdminExample;
import com.hq.pojo.AdminExample.Criteria;
import com.hq.pojo.AdminLoginLog;
import com.hq.service.AdminService;
import com.hq.service.LoginLogService;

import Mytils.LoginStatus;
@Service
public class AdminServiceImpl implements AdminService{
	@Autowired
	AdminMapper adminMapper;
	@Autowired
	LoginLogService LoginLogServiceimpl;

	public LoginStatus login(Admin admin,HttpSession session) {
		Admin u = adminMapper.selectByPrimaryKey(admin.getId());
		if(u!=null) {
			if(admin.getPassword().equals(u.getPassword())) {
				LoginStatus status = new LoginStatus(2);
				AdminLoginLog log = LoginLogServiceimpl.selByAdminId(admin.getId());
				session.setAttribute("admin", u);
				session.setAttribute("loginLog", log);
				
				return status;
			}else {
				LoginStatus status = new LoginStatus(1);
				return status;
				}
		}
		LoginStatus status = new LoginStatus(0);
		return status;	
		
	}

}
