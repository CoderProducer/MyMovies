package com.movie.pojo;

import java.util.List;

public class Download {
	
	private Integer download_Id;//下载ID
	private Integer userId;//用户ID
	private Integer videoId;//视频ID
	
	private User user;//用户对象
	private List<Video> vList;//一个下载记录可以有多个视频
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<Video> getvList() {
		return vList;
	}
	public void setvList(List<Video> vList) {
		this.vList = vList;
	}
	public Integer getDownload_Id() {
		return download_Id;
	}
	public void setDownload_Id(Integer download_Id) {
		this.download_Id = download_Id;
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
