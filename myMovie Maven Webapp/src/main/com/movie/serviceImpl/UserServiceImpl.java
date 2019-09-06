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
	 * ��ȡ�����û�
	 * @param 
	 */	
	@Override
	public List<User> getUserList() {
		
		return userDao.getUserList();
	}
	/**
	 * ��ȡ�û�����Ŀ
	 * 
	 */
	@Override
	public int getUserCount() {
		
		return userDao.getUserCount();
	}
	/**
	 * ����userId��ȡ�û���Ϣ
	 * @param userId
	 */
	@Override
	public User getUserByuserId(Integer user_Id) {
		
		return userDao.getUserByuserId(user_Id);
	}
	/**
	 * �����û�
	 * @param user
	 */
	@Override
	public int updateUser(User user) {
		
		return userDao.updateUser(user);
	}

	/**
	 * ����user_Name��ȡ�û���Ϣ
	 * @param user_Name
	 */
	@Override
	public User getUserByuserName(String user_Name) {
		
		return userDao.getUserByuserName(user_Name);
	}
	//����Ա��ҳ��ȡ�û��б�
	@Override
	public LimitPageList getLimitPageList(Integer pageNow) {
	 LimitPageList LimitPageStuList = new LimitPageList();
	      int totalCount=userDao.getUserCount();//��ȡ�ܵļ�¼��
	      List<User> uList=new ArrayList<User>();
	      Page page=null;
	      if(pageNow!=null){
	          page=new Page(totalCount, pageNow);
	          page.setPageSize(10);
	          uList=userDao.selectUserByPage(page.getStartPos(), page.getPageSize());//��startPos��ʼ����ȡpageSize������
	      }else{
	          page=new Page(totalCount, 1);//��ʼ��pageNowΪ1
	          page.setPageSize(10);
	          uList=userDao.selectUserByPage(page.getStartPos(), page.getPageSize());//��startPos��ʼ����ȡpageSize������		      
	      }
	      LimitPageStuList.setPage(page);
	      LimitPageStuList.setList(uList);
		  return LimitPageStuList;
	}
	/**
	 * ɾ���û�
	 * @param user_Id
	 */
	@Override
	public int deleteUserByUserId(Integer user_Id) {
	
		return userDao.deleteUserByUserId(user_Id);
	}
	/**
	 * ����video���ֻ�ȡ�û�����Ŀ	 * 
	 */
	@Override
	public int getVideoCount(String video_Name) {
		
		return userDao.getVideoCount(video_Name);
	}
	/**
	  * ��ҳ����video
	  * @param user_Name
	  */
	@Override
	public List<Video> selectVideoPageByName(String video_Name,Integer currentPageNo, Integer pageSize) {
		
		return userDao.selectVideoPageByName(video_Name, currentPageNo, pageSize);
	}
	/**
	  * �����û��ۿ���ʷ��¼
	  * @param user_Id
	  */
	@Override
	public List<History> findAllByuserId(Integer userId) {
		
		return userDao.findAllByuserId(userId);
	}
	/**
	 * ����userId��ȡ�û��ۿ�����Ŀ	 * 
	 */
	@Override
	public int getHistoryCount(Integer userId) {
		
		return userDao.getHistoryCount(userId);
	}
	/**
	  * �����û��ۿ����ؼ�¼
	  * @param user_Id
	  */
	@Override
	public List<Download> findDownloadByuserId(Integer user_Id) {		
		return userDao.findDownloadByuserId(user_Id);
	}
	 /**
	  * ����userId��ȡ�û���������Ŀ * 
	  */
	@Override
	public int getDownloadCount(Integer userId) {		
		return userDao.getDownloadCount(userId);
	}
	/**
	 * ��������
	 * @param userId
	 * @param userPassword
	 * @returnӰ�������
	 */
	@Override
	public int updateUserPassword(Integer userId, String userPassword) {		
		return userDao.updateUserPassword(userId, userPassword);
	}
}
