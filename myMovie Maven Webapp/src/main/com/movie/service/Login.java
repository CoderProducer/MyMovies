package com.movie.service;

import java.util.List;

import com.movie.pojo.User;

public interface Login {
	
	//�û���¼
	public boolean login(String user_Name,String user_Password);
	
	public List<User> getUserList();

}
