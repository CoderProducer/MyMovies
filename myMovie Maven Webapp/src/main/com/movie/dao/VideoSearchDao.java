package com.movie.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.movie.pojo.Video;
import com.movie.pojo.VideoActor;

public interface VideoSearchDao {
	/**
	 * 根据videoId获取视频
	 * @param video_Id
	 * @return
	 */
	Video getVideoList(@Param("video_Id") Integer video_Id);
	/**
	 * @param video_Country
	 * @param video_SmallType
	 * @param video_AgeTime
	 * 根据搜索条件获取电影总数目	 * 
	 */
	int getmovieCount(@Param("video_Country") String video_Country,
			@Param("video_SmallType") String video_SmallType,
			@Param("video_AgeTime") String video_AgeTime);
	/**
	 * @param video_Country
	 * @param video_SmallType
	 * @param video_AgeTime
	 * 根据搜索条件获取综艺总数目	 * 
	 */
	int getvarietyCount(@Param("video_Country") String video_Country,
			@Param("video_SmallType") String video_SmallType,
			@Param("video_AgeTime") String video_AgeTime);
	/**
	 * @param video_Country
	 * @param video_SmallType
	 * @param video_AgeTime
	 * 根据搜索条件获取电视剧总数目	 * 
	 */
	int gettvCount(@Param("video_Country") String video_Country,
			@Param("video_SmallType") String video_SmallType,
			@Param("video_AgeTime") String video_AgeTime);
	/**
	 * @param video_Country
	 * @param video_SmallType
	 * @param video_AgeTime
	 * 根据搜索条件获取动漫总数目	 * 
	 */
	int getcomicCount(@Param("video_Country") String video_Country,
			@Param("video_SmallType") String video_SmallType,
			@Param("video_AgeTime") String video_AgeTime);
	/**
	 * 分页获取movie
	 * @param video_Country
	 * @param video_SmallType
	 * @param video_AgeTime
	 * @param currentPageNo
	 * @param pageSize
	 * @return
	 */
	List<Video> getmovieByType(@Param("video_Country") String video_Country,
			@Param("video_SmallType") String video_SmallType,
			@Param("video_AgeTime") String video_AgeTime,
			@Param(value = "currentPageNo") Integer currentPageNo,
            @Param(value = "pageSize") Integer pageSize);
	/**
	 * 分页获取variety
	 * @param video_Country
	 * @param video_SmallType
	 * @param video_AgeTime
	 * @param currentPageNo
	 * @param pageSize
	 * @return
	 */
	List<Video> getvarietyByType(@Param("video_Country") String video_Country,
			@Param("video_SmallType") String video_SmallType,
			@Param("video_AgeTime") String video_AgeTime,
			@Param(value = "currentPageNo") Integer currentPageNo,
            @Param(value = "pageSize") Integer pageSize);
	/**
	 * 分页获取tv
	 * @param video_Country
	 * @param video_SmallType
	 * @param video_AgeTime
	 * @param currentPageNo
	 * @param pageSize
	 * @return
	 */
	List<Video> gettvByType(@Param("video_Country") String video_Country,
			@Param("video_SmallType") String video_SmallType,
			@Param("video_AgeTime") String video_AgeTime,
			@Param(value = "currentPageNo") Integer currentPageNo,
            @Param(value = "pageSize") Integer pageSize);
	/**
	 * 分页获取comic
	 * @param video_Country
	 * @param video_SmallType
	 * @param video_AgeTime
	 * @param currentPageNo
	 * @param pageSize
	 * @return
	 */
	List<Video> getcomicByType(@Param("video_Country") String video_Country,
			@Param("video_SmallType") String video_SmallType,
			@Param("video_AgeTime") String video_AgeTime,
			@Param(value = "currentPageNo") Integer currentPageNo,
            @Param(value = "pageSize") Integer pageSize);
	/**
	 * 按评分获取12部电影放到首页
	 * @return video集合
	 */
	List<Video> getMovieByPoints();
	/**
	 * 按热点获取12部电影放到首页
	 * @return video集合
	 */
	List<Video> getMovieByHotPoints();
	/**
	 * 按时间先后获取12部电影放到首页
	 * @return video集合
	 */
	List<Video> getMovieByTime();
	/**
	 * 随机获取5部电影放到首页轮播处
	 * @return video集合
	 */
	List<Video> getMovieRandom();
	/**
	 * 随机获取9部电影放到首页
	 * @return video集合
	 */	
	List<Video> getMovieRandom2();
	/**
	 * 
	 * @param videoId
	 * @return video
	 */
	Video findDetailByVideoId(@Param("videoId") Integer videoId);	
//	/**
//	 * @param videoId
//	 * @return videoactor
//	 */
//	VideoActor findDetailByVideoId(@Param("videoId") Integer videoId);	
	/**
	 * 管理员管理分页视频
	 * @param startPos
	 * @param pageSize
	 * @return video集合
	 */
	List<Video> selectVideoWithAdmin(@Param(value = "startPos") Integer startPos,
	         @Param(value = "pageSize") Integer pageSize);	
	/**
	 * 管理员界面管理的视频数目 
	 * @return video数目
	 */
	int selectVideoCountWithAdmin();	
	/**
	 * 管理员批量删除视频
	 * @param video_IdArrayAdmin
	 * @return
	 */
	int delVideoByvideoIdArrayWithAdmin(@Param(value = "video_IdArrayAdmin") Integer[] video_IdArrayAdmin);

}
