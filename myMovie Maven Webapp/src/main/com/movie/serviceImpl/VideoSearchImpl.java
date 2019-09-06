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
	 * 根据video_Id获取video
	 * @param video_Id
	 */
	@Override
	public Video getVideoList(Integer video_Id) {		
		return vSD.getVideoList(video_Id);
	}

	//根据搜索条件获取movie数目
	@Override
	public int getmovieCount(String video_Country, String video_SmallType, String video_AgeTime) {
		return vSD.getmovieCount(video_Country, video_SmallType, video_AgeTime);
	}
	//根据搜索条件获取variety数目
	@Override
	public int getvarietyCount(String video_Country, String video_SmallType, String video_AgeTime) {
		return vSD.getvarietyCount(video_Country, video_SmallType, video_AgeTime);
	}
	//根据搜索条件获取tv数目
	@Override
	public int gettvCount(String video_Country, String video_SmallType, String video_AgeTime) {
		return vSD.gettvCount(video_Country, video_SmallType, video_AgeTime);
	}
	//根据搜索条件获取comic数目
	@Override
	public int getcomicCount(String video_Country, String video_SmallType, String video_AgeTime) {
		return vSD.getcomicCount(video_Country, video_SmallType, video_AgeTime);
	}

	//分页获取movie
	@Override
	public List<Video> getmovieByType(String video_Country, String video_SmallType, String video_AgeTime,
			Integer currentPageNo, Integer pageSize) {		
		return vSD.getmovieByType(video_Country, video_SmallType, video_AgeTime, currentPageNo, pageSize);
	}
	//分页获取variety
	@Override
	public List<Video> getvarietyByType(String video_Country, String video_SmallType, String video_AgeTime,
			Integer currentPageNo, Integer pageSize) {
		return vSD.getvarietyByType(video_Country, video_SmallType, video_AgeTime, currentPageNo, pageSize);
	}
	//分页获取tv
	@Override
	public List<Video> gettvByType(String video_Country, String video_SmallType, String video_AgeTime,
			Integer currentPageNo, Integer pageSize) {
		return vSD.gettvByType(video_Country, video_SmallType, video_AgeTime, currentPageNo, pageSize);
	}
	//分页获取comic
	@Override
	public List<Video> getcomicByType(String video_Country, String video_SmallType, String video_AgeTime,
			Integer currentPageNo, Integer pageSize) {
		return vSD.getcomicByType(video_Country, video_SmallType, video_AgeTime, currentPageNo, pageSize);
	}
	// 按评分获取12部电影放到首页	 
	@Override
	public List<Video> getMovieByPoints() {		
		return vSD.getMovieByHotPoints();
	}
	// 按热点获取12部电影放到首页
	@Override
	public List<Video> getMovieByHotPoints() {		
		return vSD.getMovieByHotPoints();
	}
	// 按时间先后获取12部电影放到首页	
	@Override
	public List<Video> getMovieByTime() {		
		return vSD.getMovieByTime();
	}
	// 随机获取5部电影放到首页轮播处
	@Override
	public List<Video> getMovieRandom() {		
		return vSD.getMovieRandom();
	}
	// 随机获取9部电影放到首页
	@Override
	public List<Video> getMovieRandom2() {		
		return vSD.getMovieRandom2();
	}
	//根据videoId获取video详情
	@Override
	public Video findDetailByVideoId(Integer videoId) {		
		return vSD.findDetailByVideoId(videoId);
	}
	
	 //管理员分页获取视频
	@Override
	public LimitPageList selectVideoWithAdmin(Integer pageNow) {
		LimitPageList videoAdminList=new LimitPageList();
		//用于获取用户评论总数数 
		int videoCountAdmin=vSD.selectVideoCountWithAdmin();
		List<Video> videoListAdmin=new ArrayList<Video>();
		Page page=null;
		if (pageNow!=null) {
			page=new Page(videoCountAdmin, pageNow);
			page.setPageSize(10);
			videoListAdmin=vSD.selectVideoWithAdmin(page.getStartPos(), page.getPageSize());//从startPos开始，获取pageSize条数据
		System.out.println("列表大小"+videoListAdmin.size());
		}else{
			page=new Page(videoCountAdmin,1);//初始化pageNow为1
			page.setPageSize(10);
			videoListAdmin=vSD.selectVideoWithAdmin(page.getStartPos(), page.getPageSize());//从startPos开始，获取pageSize条数据 
			System.out.println("列表大小"+videoListAdmin.size());
		}
		videoAdminList.setPage(page);
		videoAdminList.setList(videoListAdmin);
		return videoAdminList;
	}
	//用于管理员获取视频总数
	@Override
	public int selectVideoCountWithAdmin() {		
		return vSD.selectVideoCountWithAdmin();
	}
	//管理员批量删除评论
	@Override
	public int delVideoByvideoIdArrayWithAdmin(Integer[] video_IdArrayAdmin) {		
		return vSD.delVideoByvideoIdArrayWithAdmin(video_IdArrayAdmin);
	}

}
