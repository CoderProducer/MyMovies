package com.movie.pojo;

import java.util.List;

public class Actor {
	
	private int actor_Id;//��ԱID
	private String actor_Name;//��Ա����
	private List<Video> videoList;//��Ա���ݵ���Ƶ����
	
	public List<Video> getVideoList() {
		return videoList;
	}
	public void setVideoList(List<Video> videoList) {
		this.videoList = videoList;
	}
	public int getActor_Id() {
		return actor_Id;
	}
	public void setActor_Id(int actor_Id) {
		this.actor_Id = actor_Id;
	}
	public String getActor_Name() {
		return actor_Name;
	}
	public void setActor_Name(String actor_Name) {
		this.actor_Name = actor_Name;
	}
	

}
