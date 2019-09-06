package com.movie.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.movie.pojo.Video;
import com.movie.pojo.VideoActor;
import com.movie.utils.LimitPageList;

public interface VideoSearch {
	//����videoId��ȡ��Ƶ
	Video getVideoList(Integer video_Id);
	//��������������ȡmovie��Ŀ
	int getmovieCount(String video_Country,String video_SmallType,String video_AgeTime);
	//��������������ȡvariety��Ŀ
	int getvarietyCount(String video_Country,String video_SmallType,String video_AgeTime);
	//��������������ȡtv��Ŀ
	int gettvCount(String video_Country,String video_SmallType,String video_AgeTime);
	//��������������ȡcomic��Ŀ
	int getcomicCount(String video_Country,String video_SmallType,String video_AgeTime);
	//��ҳ��ȡmovie
	List<Video> getmovieByType(String video_Country,String video_SmallType,String video_AgeTime,
			Integer currentPageNo,Integer pageSize);
	//��ҳ��ȡvariety
	List<Video> getvarietyByType(String video_Country,String video_SmallType,String video_AgeTime,
			Integer currentPageNo,Integer pageSize);
	//��ҳ��ȡtv
	List<Video> gettvByType(String video_Country,String video_SmallType,String video_AgeTime,
			Integer currentPageNo,Integer pageSize);
	//��ҳ��ȡcomic
	List<Video> getcomicByType(String video_Country,String video_SmallType,String video_AgeTime,
			Integer currentPageNo,Integer pageSize);
	
	
	// �����ֻ�ȡ12����Ӱ�ŵ���ҳ	 
	List<Video> getMovieByPoints();	
	// ���ȵ��ȡ12����Ӱ�ŵ���ҳ
	List<Video> getMovieByHotPoints();	
	// ��ʱ���Ⱥ��ȡ12����Ӱ�ŵ���ҳ	
	List<Video> getMovieByTime();	
	// �����ȡ5����Ӱ�ŵ���ҳ�ֲ���
	List<Video> getMovieRandom();
	// �����ȡ9����Ӱ�ŵ���ҳ
	List<Video> getMovieRandom2();
//	//����videoId��ȡvideoactor
//	VideoActor findDetailByVideoId(Integer videoId);
	//����videoID��ȡvideo��������Ƶ����
	Video findDetailByVideoId(Integer videoId);	
	/**
	   * ����Ա�����ҳ��Ƶ   
	   * @param pageNow:��ǰҳ�룬��Ϊnullֵ����Ϊ1
	   * @return ����page��list����
	   */
	LimitPageList selectVideoWithAdmin(Integer pageNow);
	//����Ա����������Ƶ��Ŀ 
	int selectVideoCountWithAdmin();	
	//����Ա����ɾ������
	int delVideoByvideoIdArrayWithAdmin(Integer[] video_IdArrayAdmin);
}
