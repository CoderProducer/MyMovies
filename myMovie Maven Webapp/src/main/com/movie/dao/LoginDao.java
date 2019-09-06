package com.movie.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.movie.pojo.User;

public interface LoginDao {
	
	//用户登录
			public User login(@Param("user_Name") String user_Name);
			//获取所有用户
			public List<User> getUserList();
}
