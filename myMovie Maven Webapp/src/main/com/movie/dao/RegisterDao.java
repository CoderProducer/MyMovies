package com.movie.dao;

import java.util.List;

import com.movie.pojo.User;

public interface RegisterDao {
	
	//ע��ʱ����û����Ƿ����
	User checkUserName(String user_Name);
	//ע�����ӷ���
	public int addUser(User user);
	
	//��ȡ�����û�
	public List<User> getUserList();

}
