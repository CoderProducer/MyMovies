package com.movie.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.movie.service.AdminLogin;

import ch.qos.logback.classic.Logger;

@Controller
@RequestMapping(value="AdminControl")
public class AdminControl {
	private final static Logger log=(Logger) LoggerFactory.getLogger(AdminControl.class);
	
	@Autowired
	private AdminLogin adminLogin;
	
	@RequestMapping(value="AdminLogin.do")
	public String adminLogin(HttpServletRequest request,HttpServletResponse response,HttpSession session,Model model){
		System.out.println("管理员要登录了！");
		String adminName=request.getParameter("AdminName");
		String adminPassword=request.getParameter("AdminPassword");
		System.out.println(adminName);
		System.out.println(adminPassword);
		if (adminLogin.adminLogin(adminName, adminPassword)) {
			session.setAttribute("adminName", adminName);
			session.setAttribute("adminPassword", adminPassword);
			session.setMaxInactiveInterval(10*60);
			return "admin";
		}else{
			return "AdminLogin";
		}		
	}

}
