package com.movie.service;

import java.util.List;

import com.movie.pojo.Admin;

public interface AdminLogin {
	
	//����Ա��¼
	public boolean adminLogin(String admin_Name,String admin_Password);
	
	public List<Admin> getAdminList();

}
