package com.adminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adminDao.AdminDao;
import com.adminVo.AdminVo;

@Service
public class AdminService {
@Autowired
	AdminDao adminDao;
	public String getTest(AdminVo adminVo) {
		
		return adminDao.getTest(adminVo);
	}
	public String getlogin(String emailId, String password) {
		return adminDao.getlogin(emailId,  password);
	}

}
