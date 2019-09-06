package com.movie.pojo;

import java.util.Date;
import java.util.List;

public class View {
	
	private Integer view_Id;//评论ID
	private Date view_Date;//评论时间
	private String view_Detail;//评论内容
	private Integer userId;//用户ID
	private Integer videoId;//视频ID
	
	private User user;//评论者
	private List<Video> viewList;//评论相关的视频集合
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Video> getViewList() {
		return viewList;
	}
	public void setViewList(List<Video> viewList) {
		this.viewList = viewList;
	}
	public Integer getView_Id() {
		return view_Id;
	}
	public void setView_Id(Integer view_Id) {
		this.view_Id = view_Id;
	}
	public Date getView_Date() {
		return view_Date;
	}
	public void setView_Date(Date view_Date) {
		this.view_Date = view_Date;
	}
	public String getView_Detail() {
		return view_Detail;
	}
	public void setView_Detail(String view_Detail) {
		this.view_Detail = view_Detail;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getVideoId() {
		return videoId;
	}
	public void setVideoId(Integer videoId) {
		this.videoId = videoId;
	}
	
	
}
