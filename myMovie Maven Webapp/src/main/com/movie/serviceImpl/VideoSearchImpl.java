package com.movie.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.dao.VideoSearchDao;
import com.movie.pojo.Video;
import com.movie.pojo.VideoActor;
import com.movie.pojo.View;
import com.movie.service.VideoSearch;
import com.movie.utils.LimitPageList;
import com.movie.utils.Page;

@Service
public class VideoSearchImpl implements VideoSearch {
	
	@Autowired
	private VideoSearchDao vSD;
	
	/**
	 * ����video_Id��ȡvideo
	 * @param video_Id
	 */
	@Override
	public Video getVideoList(Integer video_Id) {		
		return vSD.getVideoList(video_Id);
	}

	//��������������ȡmovie��Ŀ
	@Override
	public int getmovieCount(String video_Country, String video_SmallType, String video_AgeTime) {
		return vSD.getmovieCount(video_Country, video_SmallType, video_AgeTime);
	}
	//��������������ȡvariety��Ŀ
	@Override
	public int getvarietyCount(String video_Country, String video_SmallType, String video_AgeTime) {
		return vSD.getvarietyCount(video_Country, video_SmallType, video_AgeTime);
	}
	//��������������ȡtv��Ŀ
	@Override
	public int gettvCount(String video_Country, String video_SmallType, String video_AgeTime) {
		return vSD.gettvCount(video_Country, video_SmallType, video_AgeTime);
	}
	//��������������ȡcomic��Ŀ
	@Override
	public int getcomicCount(String video_Country, String video_SmallType, String video_AgeTime) {
		return vSD.getcomicCount(video_Country, video_SmallType, video_AgeTime);
	}

	//��ҳ��ȡmovie
	@Override
	public List<Video> getmovieByType(String video_Country, String video_SmallType, String video_AgeTime,
			Integer currentPageNo, Integer pageSize) {		
		return vSD.getmovieByType(video_Country, video_SmallType, video_AgeTime, currentPageNo, pageSize);
	}
	//��ҳ��ȡvariety
	@Override
	public List<Video> getvarietyByType(String video_Country, String video_SmallType, String video_AgeTime,
			Integer currentPageNo, Integer pageSize) {
		return vSD.getvarietyByType(video_Country, video_SmallType, video_AgeTime, currentPageNo, pageSize);
	}
	//��ҳ��ȡtv
	@Override
	public List<Video> gettvByType(String video_Country, String video_SmallType, String video_AgeTime,
			Integer currentPageNo, Integer pageSize) {
		return vSD.gettvByType(video_Country, video_SmallType, video_AgeTime, currentPageNo, pageSize);
	}
	//��ҳ��ȡcomic
	@Override
	public List<Video> getcomicByType(String video_Country, String video_SmallType, String video_AgeTime,
			Integer currentPageNo, Integer pageSize) {
		return vSD.getcomicByType(video_Country, video_SmallType, video_AgeTime, currentPageNo, pageSize);
	}
	// �����ֻ�ȡ12����Ӱ�ŵ���ҳ	 
	@Override
	public List<Video> getMovieByPoints() {		
		return vSD.getMovieByHotPoints();
	}
	// ���ȵ��ȡ12����Ӱ�ŵ���ҳ
	@Override
	public List<Video> getMovieByHotPoints() {		
		return vSD.getMovieByHotPoints();
	}
	// ��ʱ���Ⱥ��ȡ12����Ӱ�ŵ���ҳ	
	@Override
	public List<Video> getMovieByTime() {		
		return vSD.getMovieByTime();
	}
	// �����ȡ5����Ӱ�ŵ���ҳ�ֲ���
	@Override
	public List<Video> getMovieRandom() {		
		return vSD.getMovieRandom();
	}
	// �����ȡ9����Ӱ�ŵ���ҳ
	@Override
	public List<Video> getMovieRandom2() {		
		return vSD.getMovieRandom2();
	}
	//����videoId��ȡvideo����
	@Override
	public Video findDetailByVideoId(Integer videoId) {		
		return vSD.findDetailByVideoId(videoId);
	}
	
	 //����Ա��ҳ��ȡ��Ƶ
	@Override
	public LimitPageList selectVideoWithAdmin(Integer pageNow) {
		LimitPageList videoAdminList=new LimitPageList();
		//���ڻ�ȡ�û����������� 
		int videoCountAdmin=vSD.selectVideoCountWithAdmin();
		List<Video> videoListAdmin=new ArrayList<Video>();
		Page page=null;
		if (pageNow!=null) {
			page=new Page(videoCountAdmin, pageNow);
			page.setPageSize(10);
			videoListAdmin=vSD.selectVideoWithAdmin(page.getStartPos(), page.getPageSize());//��startPos��ʼ����ȡpageSize������
		System.out.println("�б��С"+videoListAdmin.size());
		}else{
			page=new Page(videoCountAdmin,1);//��ʼ��pageNowΪ1
			page.setPageSize(10);
			videoListAdmin=vSD.selectVideoWithAdmin(page.getStartPos(), page.getPageSize());//��startPos��ʼ����ȡpageSize������ 
			System.out.println("�б��С"+videoListAdmin.size());
		}
		videoAdminList.setPage(page);
		videoAdminList.setList(videoListAdmin);
		return videoAdminList;
	}
	//���ڹ���Ա��ȡ��Ƶ����
	@Override
	public int selectVideoCountWithAdmin() {		
		return vSD.selectVideoCountWithAdmin();
	}
	//����Ա����ɾ������
	@Override
	public int delVideoByvideoIdArrayWithAdmin(Integer[] video_IdArrayAdmin) {		
		return vSD.delVideoByvideoIdArrayWithAdmin(video_IdArrayAdmin);
	}

}
