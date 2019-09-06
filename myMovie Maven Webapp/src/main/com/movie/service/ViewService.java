package com.movie.service;

import org.apache.ibatis.annotations.Param;

import com.movie.pojo.View;
import com.movie.utils.LimitPageList;

public interface ViewService {
	 //用于获取用户评论总数
	 int getViewCountByuserId(Integer userId);
	 /**
	   * 获取分页记录
	   * @param userId:用户id
	   * @param pageNow:当前页码，若为null值，则为1
	   * @return 返回page和list集合
	   */
	LimitPageList getViewPageList(Integer userId, Integer pageNow);
	/**
	   * 获取分页记录	   
	   * @param pageNow:当前页码，若为null值，则为1
	   * @return 返回page和list集合
	   */
	LimitPageList selectViewsWithAdmin(Integer pageNow);
	//用于获取用户评论总数
	int getViewCountWithAdmin();
	//用户批量删除评论
	int delViewByviewIdArray(Integer[] view_IdArray);
	//管理员批量删除评论
	int delViewByviewIdArrayWithAdmin(Integer[] view_IdArrayAdmin);
	//用户进行评论
	int addViewByuserId(View view);	 
	 /**
	   * 获取分页记录
	   * @param videoId:视频id
	   * @param pageNow:当前页码，若为null值，则为1
	   * @return 返回page和list集合
	   */
	LimitPageList getViewPageListByvideoId(Integer videoId, Integer pageNow);
	//用于视频详情页获取用户评论总数
	int getViewCountByvideoId(Integer videoId);
}
