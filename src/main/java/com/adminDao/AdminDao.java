package com.adminDao;

import com.adminVo.AdminVo;

public interface AdminDao {

	String getTest(AdminVo adminVo);

	String getlogin(String emailId, String password);

}
