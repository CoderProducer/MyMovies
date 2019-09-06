package com.movie.dao;


import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.movie.pojo.Video;
import com.movie.pojo.VideoActor;

public interface VideoSearchDao {
	/**
	 * ����videoId��ȡ��Ƶ
	 * @param video_Id
	 * @return
	 */
	Video getVideoList(@Param("video_Id") Integer video_Id);
	/**
	 * @param video_Country
	 * @param video_SmallType
	 * @param video_AgeTime
	 * ��������������ȡ��Ӱ����Ŀ	 * 
	 */
	int getmovieCount(@Param("video_Country") String video_Country,
			@Param("video_SmallType") String video_SmallType,
			@Param("video_AgeTime") String video_AgeTime);
	/**
	 * @param video_Country
	 * @param video_SmallType
	 * @param video_AgeTime
	 * ��������������ȡ��������Ŀ	 * 
	 */
	int getvarietyCount(@Param("video_Country") String video_Country,
			@Param("video_SmallType") String video_SmallType,
			@Param("video_AgeTime") String video_AgeTime);
	/**
	 * @param video_Country
	 * @param video_SmallType
	 * @param video_AgeTime
	 * ��������������ȡ���Ӿ�����Ŀ	 * 
	 */
	int gettvCount(@Param("video_Country") String video_Country,
			@Param("video_SmallType") String video_SmallType,
			@Param("video_AgeTime") String video_AgeTime);
	/**
	 * @param video_Country
	 * @param video_SmallType
	 * @param video_AgeTime
	 * ��������������ȡ��������Ŀ	 * 
	 */
	int getcomicCount(@Param("video_Country") String video_Country,
			@Param("video_SmallType") String video_SmallType,
			@Param("video_AgeTime") String video_AgeTime);
	/**
	 * ��ҳ��ȡmovie
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
	 * ��ҳ��ȡvariety
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
	 * ��ҳ��ȡtv
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
	 * ��ҳ��ȡcomic
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
	 * �����ֻ�ȡ12����Ӱ�ŵ���ҳ
	 * @return video����
	 */
	List<Video> getMovieByPoints();
	/**
	 * ���ȵ��ȡ12����Ӱ�ŵ���ҳ
	 * @return video����
	 */
	List<Video> getMovieByHotPoints();
	/**
	 * ��ʱ���Ⱥ��ȡ12����Ӱ�ŵ���ҳ
	 * @return video����
	 */
	List<Video> getMovieByTime();
	/**
	 * �����ȡ5����Ӱ�ŵ���ҳ�ֲ���
	 * @return video����
	 */
	List<Video> getMovieRandom();
	/**
	 * �����ȡ9����Ӱ�ŵ���ҳ
	 * @return video����
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
	 * ����Ա�����ҳ��Ƶ
	 * @param startPos
	 * @param pageSize
	 * @return video����
	 */
	List<Video> selectVideoWithAdmin(@Param(value = "startPos") Integer startPos,
	         @Param(value = "pageSize") Integer pageSize);	
	/**
	 * ����Ա����������Ƶ��Ŀ 
	 * @return video��Ŀ
	 */
	int selectVideoCountWithAdmin();	
	/**
	 * ����Ա����ɾ����Ƶ
	 * @param video_IdArrayAdmin
	 * @return
	 */
	int delVideoByvideoIdArrayWithAdmin(@Param(value = "video_IdArrayAdmin") Integer[] video_IdArrayAdmin);

}
