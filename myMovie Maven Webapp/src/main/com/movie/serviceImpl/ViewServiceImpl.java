package com.movie.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.dao.UserDao;
import com.movie.dao.ViewDao;
import com.movie.pojo.View;
import com.movie.service.ViewService;
import com.movie.utils.LimitPageList;
import com.movie.utils.Page;

@Service
public class ViewServiceImpl implements ViewService {
	
	@Autowired
	private ViewDao viewDao;

	//用于获取用户评论总数
	@Override
	public int getViewCountByuserId(Integer userId) {		
		return viewDao.getViewCountByuserId(userId);
	}
	//用户分页获取自己的评论
	@Override
	public LimitPageList getViewPageList(Integer userId, Integer pageNow) {
		LimitPageList viewPageList=new LimitPageList();
		//用于获取用户评论总数数 
		int viewCount=viewDao.getViewCountByuserId(userId);
		List<View> viList=new ArrayList<View>();
		Page page=null;
		if (pageNow!=null) {
			page=new Page(viewCount, pageNow);
			page.setPageSize(10);
			viList=viewDao.selectViewByPage(userId, page.getStartPos(), page.getPageSize());//从startPos开始，获取pageSize条数据
		System.out.println("列表大小"+viList.size());
		}else{
			page=new Page(viewCount,1);//初始化pageNow为1
			page.setPageSize(10);
			viList=viewDao.selectViewByPage(userId, page.getStartPos(), page.getPageSize());//从startPos开始，获取pageSize条数据 
			System.out.println("列表大小"+viList.size());
		}
		viewPageList.setPage(page);
		viewPageList.setList(viList);
		return viewPageList;
	}
	//管理员分页用户评论
	@Override
	public LimitPageList selectViewsWithAdmin(Integer pageNow) {
		LimitPageList viewAdminList=new LimitPageList();
		//用于获取用户评论总数
		int viewCountAdmin=viewDao.getViewCountWithAdmin();
		List<View> viewListAdmin=new ArrayList<View>();
		Page page=null;
		if (pageNow!=null) {
			page=new Page(viewCountAdmin, pageNow);
			page.setPageSize(10);
			viewListAdmin=viewDao.selectViewsWithAdmin(page.getStartPos(), page.getPageSize());//从startPos开始，获取pageSize条数据
		System.out.println("列表大小"+viewListAdmin.size());
		}else{
			page=new Page(viewCountAdmin,1);//初始化pageNow为1
			page.setPageSize(10);
			viewListAdmin=viewDao.selectViewsWithAdmin(page.getStartPos(), page.getPageSize());//从startPos开始，获取pageSize条数据 
			System.out.println("列表大小"+viewListAdmin.size());
		}
		viewAdminList.setPage(page);
		viewAdminList.setList(viewListAdmin);
		return viewAdminList;
	}
	//用于管理员获取用户评论总数
	@Override
	public int getViewCountWithAdmin() {		
		return viewDao.getViewCountWithAdmin();
	}
	//用户批量删除评论
	@Override
	public int delViewByviewIdArray(Integer[] view_IdArray) {		
		return viewDao.delViewByviewIdArray(view_IdArray);
	}
	//管理员批量删除评论
	@Override
	public int delViewByviewIdArrayWithAdmin(Integer[] view_IdArrayAdmin) {		
		return viewDao.delViewByviewIdArrayWithAdmin(view_IdArrayAdmin);
	}
	//用户进行评论
	@Override
	public int addViewByuserId(View view) {		
		return viewDao.addViewByuserId(view);
	}
	//视频详情页用户评论分页展示
	@Override
	public LimitPageList getViewPageListByvideoId(Integer videoId, Integer pageNow) {
		LimitPageList viewPageList2=new LimitPageList();
		//用于获取视频详情页用户评论总数 
		int viewCount2=viewDao.getViewCountByvideoId(videoId);
		List<View> viList2=new ArrayList<View>();
		Page page=null;
		if (pageNow!=null) {
			page=new Page(viewCount2, pageNow);
			page.setPageSize(10);
			viList2=viewDao.getViewByvideoId(videoId, page.getStartPos(), page.getPageSize());//从startPos开始，获取pageSize条数据
		System.out.println("列表2大小"+viList2.size());
		}else{
			page=new Page(viewCount2,1);//初始化pageNow为1
			page.setPageSize(10);
			viList2=viewDao.getViewByvideoId(videoId, page.getStartPos(), page.getPageSize());//从startPos开始，获取pageSize条数据 
			System.out.println("列表2大小"+viList2.size());
		}
		viewPageList2.setPage(page);
		viewPageList2.setList(viList2);
		return viewPageList2;
	}
	//拥有视频详情页的评论数目
	@Override
	public int getViewCountByvideoId(Integer videoId) {		
		return viewDao.getViewCountByvideoId(videoId);
	}

}
