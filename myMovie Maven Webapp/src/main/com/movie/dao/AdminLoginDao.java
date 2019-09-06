package com.movie.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.movie.pojo.Admin;

public interface AdminLoginDao {
	
	//管理员登录
	public Admin adminLogin(@Param("admin_Name") String admin_Name);
	//获取管理员信息
	public List<Admin> getAdminList();

}
