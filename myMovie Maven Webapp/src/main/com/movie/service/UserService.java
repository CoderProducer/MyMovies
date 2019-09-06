package com.movie.service;

import java.util.List;

import com.movie.pojo.Download;
import com.movie.pojo.History;
import com.movie.pojo.User;
import com.movie.pojo.Video;
import com.movie.utils.LimitPageList;

public interface UserService {
	
	/**
	 * 获取所有用户
	 * @param 
	 */
	
	public List<User> getUserList();
	/**
	 * 获取用户总数目
	 * 
	 */
	public int getUserCount();
	/**
	 * 根据video名字获取用户总数目	 * 
	 */
	public int getVideoCount(String video_Name);
	/**
	 * 根据userId获取用户信息
	 * @param userId
	 */
	public User getUserByuserId(Integer user_Id);
	/**
	 * 根据user_Name获取用户信息
	 * @param user_Name
	 */
	public User getUserByuserName(String user_Name);
	/**
	 * 更新用户
	 * @param user
	 */
	public int updateUser(User user);
	/**
	 * 删除用户
	 * @param user_Id
	 */
	public int deleteUserByUserId(Integer user_Id);
	/**
	   * 获取分页记录
	   * @param pageNow:当前页码，若为null值，则为1
	   * @return 返回page和list集合
	   */
	public LimitPageList getLimitPageList(Integer pageNow);
	 /**
	  * 分页搜索video
	  * @param user_Name
	  */
	public List<Video> selectVideoPageByName(String video_Name,Integer currentPageNo,Integer pageSize);
	/**
	  * 搜索用户观看历史记录
	  * @param user_Id
	  */
	List<History> findAllByuserId(Integer userId);
	 /**
	 * 根据userId获取用户观看总数目	 * 
	 */
	int getHistoryCount(Integer userId);
	 /**
	  * 搜索用户观看下载记录
	  * @param user_Id
	  */
	 List<Download> findDownloadByuserId(Integer user_Id);
	 /**
	 * 根据userId获取用户总下载数目 * 
	 */
	int getDownloadCount(Integer userId);
	/**
	 * 更新密码
	 * @param userId
	 * @param userPassword
	 * @return影响的行数
	 */
	int updateUserPassword(Integer userId,String userPassword);

}
