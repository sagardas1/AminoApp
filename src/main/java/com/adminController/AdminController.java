package com.adminController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adminService.AdminService;
import com.adminVo.AdminVo;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	AdminService accountService;

	@GetMapping(value = "/", headers = "Accept=application/json")
	public String welcome() {
		return "Wellcome";
	}
	
	@PostMapping(value = "/test", headers = "Accept=application/json")
	public String test(@RequestBody AdminVo adminVo) {
		return accountService.getTest(adminVo);
	}
	@GetMapping(value = "/login", headers = "Accept=application/json")
	public String test( String emailId,String password) {
		return accountService.getlogin(emailId,password);
	}
}
