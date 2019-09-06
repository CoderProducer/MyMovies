package com.movie.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.movie.pojo.View;

public interface ViewDao {
	
	/**
	 3      * 获取用户评论分页记录
	 4      * @param startPos:从数据库中第几行开始获取
	 5      * @param userId:用户Id
	 6		* @param pageSize:获取的条数
	 7      * @return 返回pageSize条数据的集合，数据足够多
	 8      */
	 List<View> selectViewByPage(@Param(value = "userId") Integer userId,
			 @Param(value = "startPos") Integer startPos,
	         @Param(value = "pageSize") Integer pageSize);
	 //用于获取用户评论总数（用户个人中心）
	 int getViewCountByuserId(@Param(value = "userId") Integer userId);
	 /**
	 3      * 获取用户评论分页记录
	 4      * @param startPos:从数据库中第几行开始获取
	 5		* @param pageSize:获取的条数
	 6      * @return 返回pageSize条数据的集合，数据足够多
	 7      */
	 List<View> selectViewsWithAdmin(@Param(value = "startPos") Integer startPos,
	         @Param(value = "pageSize") Integer pageSize);
	 //用于获取用户评论总数(管理页面)
	 int getViewCountWithAdmin();
	 //用户批量删除评论
	 int delViewByviewIdArray(@Param(value = "view_IdArray") Integer[] view_IdArray);
	 //管理员批量删除评论
	 int delViewByviewIdArrayWithAdmin(@Param(value = "view_IdArrayAdmin") Integer[] view_IdArrayAdmin);
	 //用户进行评论
	 int addViewByuserId(View view);
	 /**
	 3      * 在视频详情页获取用户评论分页记录
	 4      * @param startPos:从数据库中第几行开始获取
	 5      * @param videoId:视频Id
	 6		* @param pageSize:获取的条数
	 7      * @return 返回pageSize条数据的集合，数据足够多
	 8      */
	 List<View> getViewByvideoId(@Param(value = "videoId") Integer videoId,
			 @Param(value = "startPos") Integer startPos,
	         @Param(value = "pageSize") Integer pageSize);
	 //用于获取用户评论总数（视频详情页）
	 int getViewCountByvideoId(@Param(value = "videoId") Integer videoId);
}
