package com.movie.service;

import java.util.List;

import com.movie.pojo.User;

public interface Register {
	
	//ע��ʱ����û����Ƿ����
	User checkUserName(String user_Name);
	/**�ж��Ƿ���ӳɹ�
	 *@param user
	 * @return boolean����
	 */
	
	public boolean addUser(User user);
	
	public List<User> getUserList();

}
