package com.movie.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.movie.dao.RegisterDao;
import com.movie.pojo.User;
import com.movie.service.Register;

@Service
public class RegisterImpl implements Register {
	@Resource
	private RegisterDao registerDao;
	
	@Override
	public User checkUserName(String user_Name) {
		User user=null;
		user=registerDao.checkUserName(user_Name);
		return user;
	}

	@Override
	public boolean addUser(User user) {
		boolean flag=false;
		int addRows=registerDao.addUser(user);
		if (addRows>0) {
			flag=true;
			System.out.println("add success!");
		}else{
			System.out.println("add failed!");
		}
		return flag;
	}

	@Override
	public List<User> getUserList() {
		List<User> list=registerDao.getUserList();
		for (User user : list) {
			System.out.println("Ãû×ÖÊÇ£º"+user.getUser_Name());
		}
		return list;
	}

}
