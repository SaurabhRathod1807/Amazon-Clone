package com.amazon.controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazon.entity.Admin;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/amazon/admin/")
public class AdminController {

	@Autowired
	SessionFactory sf;
	
	@PostMapping("check")
	public boolean checkAdmin(@RequestBody Admin adminformbrowers) {
		System.out.println("Admin for browers" + adminformbrowers);
		
		Session s = sf.openSession();
		Admin adminformdatabase = s.get(Admin.class, adminformbrowers.getName());
		
		boolean result = adminformbrowers.equals(adminformdatabase);
		
		System.out.println("the result form returlt" + result);
		
		return true;
	}
}
