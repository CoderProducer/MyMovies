package com.movie.service;

import java.util.List;

import com.movie.pojo.Download;
import com.movie.pojo.History;
import com.movie.pojo.User;
import com.movie.pojo.Video;
import com.movie.utils.LimitPageList;

public interface UserService {
	
	/**
	 * ��ȡ�����û�
	 * @param 
	 */
	
	public List<User> getUserList();
	/**
	 * ��ȡ�û�����Ŀ
	 * 
	 */
	public int getUserCount();
	/**
	 * ����video���ֻ�ȡ�û�����Ŀ	 * 
	 */
	public int getVideoCount(String video_Name);
	/**
	 * ����userId��ȡ�û���Ϣ
	 * @param userId
	 */
	public User getUserByuserId(Integer user_Id);
	/**
	 * ����user_Name��ȡ�û���Ϣ
	 * @param user_Name
	 */
	public User getUserByuserName(String user_Name);
	/**
	 * �����û�
	 * @param user
	 */
	public int updateUser(User user);
	/**
	 * ɾ���û�
	 * @param user_Id
	 */
	public int deleteUserByUserId(Integer user_Id);
	/**
	   * ��ȡ��ҳ��¼
	   * @param pageNow:��ǰҳ�룬��Ϊnullֵ����Ϊ1
	   * @return ����page��list����
	   */
	public LimitPageList getLimitPageList(Integer pageNow);
	 /**
	  * ��ҳ����video
	  * @param user_Name
	  */
	public List<Video> selectVideoPageByName(String video_Name,Integer currentPageNo,Integer pageSize);
	/**
	  * �����û��ۿ���ʷ��¼
	  * @param user_Id
	  */
	List<History> findAllByuserId(Integer userId);
	 /**
	 * ����userId��ȡ�û��ۿ�����Ŀ	 * 
	 */
	int getHistoryCount(Integer userId);
	 /**
	  * �����û��ۿ����ؼ�¼
	  * @param user_Id
	  */
	 List<Download> findDownloadByuserId(Integer user_Id);
	 /**
	 * ����userId��ȡ�û���������Ŀ * 
	 */
	int getDownloadCount(Integer userId);
	/**
	 * ��������
	 * @param userId
	 * @param userPassword
	 * @returnӰ�������
	 */
	int updateUserPassword(Integer userId,String userPassword);

}
