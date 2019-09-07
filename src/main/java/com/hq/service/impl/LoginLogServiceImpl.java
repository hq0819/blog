package com.hq.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hq.mapper.AdminLoginLogMapper;
import com.hq.pojo.AdminLoginLog;
import com.hq.pojo.AdminLoginLogExample;
import com.hq.pojo.AdminLoginLogExample.Criteria;
import com.hq.service.LoginLogService;

@Service
public class LoginLogServiceImpl implements LoginLogService{
	@Autowired
	AdminLoginLogMapper adminLoginLogMapper;

	public AdminLoginLog selByAdminId(int id) {
		
		AdminLoginLogExample example = new AdminLoginLogExample();
		Criteria create = example.createCriteria();
		create.andAdminIdEqualTo(id);
		return adminLoginLogMapper.selectByExample(example).get(0);
	}
	
	

}
