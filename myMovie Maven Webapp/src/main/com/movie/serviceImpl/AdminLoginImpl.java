package com.movie.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.dao.AdminLoginDao;
import com.movie.pojo.Admin;
import com.movie.service.AdminLogin;

@Service
public class AdminLoginImpl implements AdminLogin {
	
	@Autowired
	AdminLoginDao adminLoginDao;

	@Override
	public boolean adminLogin(String admin_Name, String admin_Password) {
		boolean flag=false;
		Admin admin=adminLoginDao.adminLogin(admin_Name);
		if (admin.getAdmin_Password().equals(admin_Password)) {
			flag=true;
		}else{
			flag=false;
		}
		return flag;
	}

	@Override
	public List<Admin> getAdminList() {
		List<Admin> aList=adminLoginDao.getAdminList();
		for (Admin admin : aList) {
			System.out.println("管理员名字是："+admin.getAdmin_Name());
		}
		return aList;
	}

}
