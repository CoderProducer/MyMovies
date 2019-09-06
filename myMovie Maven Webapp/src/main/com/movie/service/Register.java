package com.movie.service;

import java.util.List;

import com.movie.pojo.User;

public interface Register {
	
	//注册时检测用户名是否可用
	User checkUserName(String user_Name);
	/**判断是否添加成功
	 *@param user
	 * @return boolean类型
	 */
	
	public boolean addUser(User user);
	
	public List<User> getUserList();

}
