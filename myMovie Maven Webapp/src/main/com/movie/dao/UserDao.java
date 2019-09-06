package com.movie.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.movie.pojo.Download;
import com.movie.pojo.History;
import com.movie.pojo.User;
import com.movie.pojo.Video;

public interface UserDao {
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
	public int getVideoCount(@Param("video_Name") String video_Name);
	/**
	 * 根据userId获取用户信息
	 * @param userId
	 */
	public User getUserByuserId(@Param("user_Id") Integer user_Id);
	/**
	 * 根据user_Name获取用户信息
	 * @param user_Name
	 */
	public User getUserByuserName(String user_Name);
	/**
	/**
	 * 更新用户
	 * @param user_Id
	 */
	public int updateUser(User user);
	/**
	 * 删除用户
	 * @param user_Id
	 */
	public int deleteUserByUserId(@Param(value = "user_Id") Integer user_Id);
	 /**
	 3      * 获取分页记录
	 4      * @param startPos:从数据库中第几行开始获取
	 5      * @param pageSize:获取的条数
	 6      * @return 返回pageSize条数据的集合，数据足够多
	 7      */
	 public List<User> selectUserByPage(@Param(value = "startPos") Integer startPos,
	              @Param(value = "pageSize") Integer pageSize);
	 /**
	  * 分页搜索video
	  * @param user_Name
	  */
	 public List<Video> selectVideoPageByName(@Param(value = "video_Name") String video_Name,
			 @Param(value = "currentPageNo") Integer currentPageNo,
             @Param(value = "pageSize") Integer pageSize);
	 
	 /**
	  * 搜索用户观看历史记录
	  * @param user_Id
	  */
	 List<History> findAllByuserId(@Param(value="userId") Integer userId);
	 /**
		 * 根据userId获取用户总历史数目	 * 
		 */
	int getHistoryCount(@Param("userId") Integer userId);
	
	 /**
	  * 搜索用户观看下载记录
	  * @param user_Id
	  */
	 List<Download> findDownloadByuserId(@Param(value="user_Id") Integer user_Id);
	 /**
		 * 根据userId获取用户总下载数目 * 
		 */
	int getDownloadCount(@Param("userId") Integer userId);
	/**
	 * 更新密码
	 * @param userId
	 * @param userPassword
	 * @return影响的行数
	 */
	int updateUserPassword(@Param("userId") Integer userId,@Param("userPassword") String userPassword);
}
