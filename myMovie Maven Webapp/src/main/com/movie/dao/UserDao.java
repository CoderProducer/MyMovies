package com.movie.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.movie.pojo.Download;
import com.movie.pojo.History;
import com.movie.pojo.User;
import com.movie.pojo.Video;

public interface UserDao {
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
	public int getVideoCount(@Param("video_Name") String video_Name);
	/**
	 * ����userId��ȡ�û���Ϣ
	 * @param userId
	 */
	public User getUserByuserId(@Param("user_Id") Integer user_Id);
	/**
	 * ����user_Name��ȡ�û���Ϣ
	 * @param user_Name
	 */
	public User getUserByuserName(String user_Name);
	/**
	/**
	 * �����û�
	 * @param user_Id
	 */
	public int updateUser(User user);
	/**
	 * ɾ���û�
	 * @param user_Id
	 */
	public int deleteUserByUserId(@Param(value = "user_Id") Integer user_Id);
	 /**
	 3      * ��ȡ��ҳ��¼
	 4      * @param startPos:�����ݿ��еڼ��п�ʼ��ȡ
	 5      * @param pageSize:��ȡ������
	 6      * @return ����pageSize�����ݵļ��ϣ������㹻��
	 7      */
	 public List<User> selectUserByPage(@Param(value = "startPos") Integer startPos,
	              @Param(value = "pageSize") Integer pageSize);
	 /**
	  * ��ҳ����video
	  * @param user_Name
	  */
	 public List<Video> selectVideoPageByName(@Param(value = "video_Name") String video_Name,
			 @Param(value = "currentPageNo") Integer currentPageNo,
             @Param(value = "pageSize") Integer pageSize);
	 
	 /**
	  * �����û��ۿ���ʷ��¼
	  * @param user_Id
	  */
	 List<History> findAllByuserId(@Param(value="userId") Integer userId);
	 /**
		 * ����userId��ȡ�û�����ʷ��Ŀ	 * 
		 */
	int getHistoryCount(@Param("userId") Integer userId);
	
	 /**
	  * �����û��ۿ����ؼ�¼
	  * @param user_Id
	  */
	 List<Download> findDownloadByuserId(@Param(value="user_Id") Integer user_Id);
	 /**
		 * ����userId��ȡ�û���������Ŀ * 
		 */
	int getDownloadCount(@Param("userId") Integer userId);
	/**
	 * ��������
	 * @param userId
	 * @param userPassword
	 * @returnӰ�������
	 */
	int updateUserPassword(@Param("userId") Integer userId,@Param("userPassword") String userPassword);
}
