package com.movie.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.movie.pojo.User;
import com.movie.service.Login;
import com.movie.service.UserService;
import com.movie.serviceImpl.LoginImpl;

import ch.qos.logback.classic.Logger;

@Controller
@RequestMapping(value="/LoginControl")
public class LoginControl {
	private final static Logger log=(Logger) LoggerFactory.getLogger(LoginControl.class);
	@Autowired
	 private Login login;
	@Autowired
	private UserService userService;
	 
	
	@RequestMapping(value="/index.do",method=RequestMethod.POST)
	public String find(Model model){
		System.out.println("过来了");
		
		List<User> list=login.getUserList();
		for (User user : list) {
			 model.addAttribute("user_Name",user.getUser_Name());
			 System.out.println(user.getUser_Name());
		}
		System.out.println("过来了啊");
		log.info("通了");
		return "b";
	}
	
	@RequestMapping(value="UserLogin.do")
	public String login(HttpServletRequest request,HttpServletResponse response,HttpSession session,Model model){
		System.out.println("用户要登录了！");
		String username=request.getParameter("Username");
		String password=request.getParameter("Password");
		System.out.println(username);
		System.out.println(password);		
		   if (login.login(username, password)) {
			   session.setAttribute("username", username);
			   session.setAttribute("password", password);
			   User user=null;
			   user=userService.getUserByuserName(username);
			   int userId=user.getUser_Id();
			   session.setAttribute("userId", userId);
			   session.setAttribute("user", user);
			   session.setMaxInactiveInterval(10*60);
			   return "redirect:/VideoControl/index.do";//登录成功前往主页
		}else {
			return "UserLogin";
		}		
	
	}
	

}
