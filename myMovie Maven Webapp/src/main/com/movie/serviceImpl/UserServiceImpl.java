package com.movie.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.dao.UserDao;
import com.movie.pojo.Download;
import com.movie.pojo.History;
import com.movie.pojo.User;
import com.movie.pojo.Video;
import com.movie.service.UserService;
import com.movie.utils.LimitPageList;
import com.movie.utils.Page;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;	
	/**
	 * 获取所有用户
	 * @param 
	 */	
	@Override
	public List<User> getUserList() {
		
		return userDao.getUserList();
	}
	/**
	 * 获取用户总数目
	 * 
	 */
	@Override
	public int getUserCount() {
		
		return userDao.getUserCount();
	}
	/**
	 * 根据userId获取用户信息
	 * @param userId
	 */
	@Override
	public User getUserByuserId(Integer user_Id) {
		
		return userDao.getUserByuserId(user_Id);
	}
	/**
	 * 更新用户
	 * @param user
	 */
	@Override
	public int updateUser(User user) {
		
		return userDao.updateUser(user);
	}

	/**
	 * 根据user_Name获取用户信息
	 * @param user_Name
	 */
	@Override
	public User getUserByuserName(String user_Name) {
		
		return userDao.getUserByuserName(user_Name);
	}
	//管理员分页获取用户列表
	@Override
	public LimitPageList getLimitPageList(Integer pageNow) {
	 LimitPageList LimitPageStuList = new LimitPageList();
	      int totalCount=userDao.getUserCount();//获取总的记录数
	      List<User> uList=new ArrayList<User>();
	      Page page=null;
	      if(pageNow!=null){
	          page=new Page(totalCount, pageNow);
	          page.setPageSize(10);
	          uList=userDao.selectUserByPage(page.getStartPos(), page.getPageSize());//从startPos开始，获取pageSize条数据
	      }else{
	          page=new Page(totalCount, 1);//初始化pageNow为1
	          page.setPageSize(10);
	          uList=userDao.selectUserByPage(page.getStartPos(), page.getPageSize());//从startPos开始，获取pageSize条数据		      
	      }
	      LimitPageStuList.setPage(page);
	      LimitPageStuList.setList(uList);
		  return LimitPageStuList;
	}
	/**
	 * 删除用户
	 * @param user_Id
	 */
	@Override
	public int deleteUserByUserId(Integer user_Id) {
	
		return userDao.deleteUserByUserId(user_Id);
	}
	/**
	 * 根据video名字获取用户总数目	 * 
	 */
	@Override
	public int getVideoCount(String video_Name) {
		
		return userDao.getVideoCount(video_Name);
	}
	/**
	  * 分页搜索video
	  * @param user_Name
	  */
	@Override
	public List<Video> selectVideoPageByName(String video_Name,Integer currentPageNo, Integer pageSize) {
		
		return userDao.selectVideoPageByName(video_Name, currentPageNo, pageSize);
	}
	/**
	  * 搜索用户观看历史记录
	  * @param user_Id
	  */
	@Override
	public List<History> findAllByuserId(Integer userId) {
		
		return userDao.findAllByuserId(userId);
	}
	/**
	 * 根据userId获取用户观看总数目	 * 
	 */
	@Override
	public int getHistoryCount(Integer userId) {
		
		return userDao.getHistoryCount(userId);
	}
	/**
	  * 搜索用户观看下载记录
	  * @param user_Id
	  */
	@Override
	public List<Download> findDownloadByuserId(Integer user_Id) {		
		return userDao.findDownloadByuserId(user_Id);
	}
	 /**
	  * 根据userId获取用户总下载数目 * 
	  */
	@Override
	public int getDownloadCount(Integer userId) {		
		return userDao.getDownloadCount(userId);
	}
	/**
	 * 更新密码
	 * @param userId
	 * @param userPassword
	 * @return影响的行数
	 */
	@Override
	public int updateUserPassword(Integer userId, String userPassword) {		
		return userDao.updateUserPassword(userId, userPassword);
	}
}
