package com.movie.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.movie.pojo.User;

public interface LoginDao {
	
	//�û���¼
			public User login(@Param("user_Name") String user_Name);
			//��ȡ�����û�
			public List<User> getUserList();
}
