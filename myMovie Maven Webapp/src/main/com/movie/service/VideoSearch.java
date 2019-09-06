package com.movie.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.movie.pojo.Video;
import com.movie.pojo.VideoActor;
import com.movie.utils.LimitPageList;

public interface VideoSearch {
	//根据videoId获取视频
	Video getVideoList(Integer video_Id);
	//根据搜索条件获取movie数目
	int getmovieCount(String video_Country,String video_SmallType,String video_AgeTime);
	//根据搜索条件获取variety数目
	int getvarietyCount(String video_Country,String video_SmallType,String video_AgeTime);
	//根据搜索条件获取tv数目
	int gettvCount(String video_Country,String video_SmallType,String video_AgeTime);
	//根据搜索条件获取comic数目
	int getcomicCount(String video_Country,String video_SmallType,String video_AgeTime);
	//分页获取movie
	List<Video> getmovieByType(String video_Country,String video_SmallType,String video_AgeTime,
			Integer currentPageNo,Integer pageSize);
	//分页获取variety
	List<Video> getvarietyByType(String video_Country,String video_SmallType,String video_AgeTime,
			Integer currentPageNo,Integer pageSize);
	//分页获取tv
	List<Video> gettvByType(String video_Country,String video_SmallType,String video_AgeTime,
			Integer currentPageNo,Integer pageSize);
	//分页获取comic
	List<Video> getcomicByType(String video_Country,String video_SmallType,String video_AgeTime,
			Integer currentPageNo,Integer pageSize);
	
	
	// 按评分获取12部电影放到首页	 
	List<Video> getMovieByPoints();	
	// 按热点获取12部电影放到首页
	List<Video> getMovieByHotPoints();	
	// 按时间先后获取12部电影放到首页	
	List<Video> getMovieByTime();	
	// 随机获取5部电影放到首页轮播处
	List<Video> getMovieRandom();
	// 随机获取9部电影放到首页
	List<Video> getMovieRandom2();
//	//根据videoId获取videoactor
//	VideoActor findDetailByVideoId(Integer videoId);
	//根据videoID获取video对象及其视频详情
	Video findDetailByVideoId(Integer videoId);	
	/**
	   * 管理员管理分页视频   
	   * @param pageNow:当前页码，若为null值，则为1
	   * @return 返回page和list集合
	   */
	LimitPageList selectVideoWithAdmin(Integer pageNow);
	//管理员界面管理的视频数目 
	int selectVideoCountWithAdmin();	
	//管理员批量删除评论
	int delVideoByvideoIdArrayWithAdmin(Integer[] video_IdArrayAdmin);
}
