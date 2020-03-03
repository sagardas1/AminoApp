package com.adminDaoImpli;

import org.jongo.Jongo;
import org.springframework.stereotype.Repository;

import com.MongoUtill.MongoDBUtil;
import com.adminDao.AdminDao;
import com.adminVo.AdminVo;

@Repository
public class AdminDaoImplimentation implements AdminDao{

	@Override
	public String getTest(AdminVo adminVo) {
		
			AdminVo adminVo1=new Jongo(MongoDBUtil.getDB()).getCollection("registration").
					findOne("{emailId:#}",adminVo.getEmailId()).as(AdminVo.class);
			if(adminVo1==null) {
		
			new Jongo(MongoDBUtil.getDB()).getCollection("registration").insert(adminVo);
			new Jongo(MongoDBUtil.getDB()).getCollection("login").insert("{emailId:#,password:#}",adminVo.getEmailId(),adminVo.getPassword());
			}
		return "SUCCESS";
	}

	@Override
	public String getlogin(String emailId, String password) {
		String status;
		AdminVo adminVo1=new Jongo(MongoDBUtil.getDB()).getCollection("login").
				findOne("{emailId:#,password:#}",emailId,password).as(AdminVo.class);
		if(adminVo1!=null) {
			status="WellCome";
		}else {status="Failed";}
		return status;
	}

}
