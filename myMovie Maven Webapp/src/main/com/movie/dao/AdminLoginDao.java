package com.movie.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.movie.pojo.Admin;

public interface AdminLoginDao {
	
	//����Ա��¼
	public Admin adminLogin(@Param("admin_Name") String admin_Name);
	//��ȡ����Ա��Ϣ
	public List<Admin> getAdminList();

}
