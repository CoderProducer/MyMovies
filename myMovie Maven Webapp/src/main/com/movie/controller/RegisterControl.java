package com.movie.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.movie.pojo.User;
import com.movie.service.Register;

import ch.qos.logback.classic.Logger;

@Controller
@RequestMapping("/RegisterControl")
public class RegisterControl {
	private final static Logger log=(Logger) LoggerFactory.getLogger(RegisterControl.class);
	@Resource
	private Register register;
	
	
	@RequestMapping(value="/checkUserName.do",
			method=RequestMethod.POST,produces="application/json;charset=UTF-8")
	@ResponseBody
	public User checkUserName(String Username){
		System.out.println(Username);
		User user=null;
		user=register.checkUserName(Username);
		return user;
	}	
	
	@RequestMapping(value="/reg.do",method=RequestMethod.POST)
	public String doReg(@RequestParam String Username,@RequestParam String Password,
			@RequestParam String Repassword,@RequestParam String Phone,@RequestParam String Email,
			HttpServletRequest request){
		System.out.println(Username);
		System.out.println(Password);
		System.out.println(Repassword);
		System.out.println(Phone);
		System.out.println(Email);
		User user=new User();
		user.setUser_Name(Username);
		user.setUser_Password(Password);
		user.setUser_Tel(Phone);
		user.setUser_Email(Email);
		List<User> userList=null;
		userList=register.getUserList();
		String userName=null;
		for (User users : userList) {
			userName=users.getUser_Name();
		}
		if (userName.equals(Username)) {
			log.debug("用户名已存在！");			
		}else{
			if (Password.equals(Repassword)) {
				log.debug("用户名可用！");
				register.addUser(user);
				return "UserLogin";
			}
			
		}
		return "reg";
	}	

}
