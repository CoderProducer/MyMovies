package com.movie.dao;

import java.util.List;

import com.movie.pojo.User;

public interface RegisterDao {
	
	//注册时检测用户名是否可用
	User checkUserName(String user_Name);
	//注册的添加方法
	public int addUser(User user);
	
	//获取所有用户
	public List<User> getUserList();

}
