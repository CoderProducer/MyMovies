package com.movie.pojo;

import java.util.List;

public class Download {
	
	private Integer download_Id;//����ID
	private Integer userId;//�û�ID
	private Integer videoId;//��ƵID
	
	private User user;//�û�����
	private List<Video> vList;//һ�����ؼ�¼�����ж����Ƶ
	
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
