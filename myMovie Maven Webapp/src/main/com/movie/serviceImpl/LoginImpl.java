package com.movie.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.pojo.User;
import com.movie.dao.LoginDao;
import com.movie.service.Login;

@Service
public class LoginImpl implements Login {
	
	@Autowired
	LoginDao loginDao;

	@Override
	public boolean login(String user_Name, String user_Password) {
		boolean flag=false;
		User user=loginDao.login(user_Name);
		if(user.getUser_Password().equals(user_Password)){
			flag=true;
		}else{
			flag=false;
		}
		return flag;
	}

	@Override
	public List<User> getUserList() {
		List<User> ulist=loginDao.getUserList();
		for (User user : ulist) {
			System.out.println("用户名字是："+user.getUser_Name());
		}
		return ulist;
	}

}
