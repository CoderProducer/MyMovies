package com.movie.pojo;

import java.util.List;

public class VideoActor {
	
	private int videoId;//�����ƵID
	private int actorId;//�����ԱID
	private Video video;//��Ƶ����
	private Actor actor;//��Ա����
	
	public Video getVideo() {
		return video;
	}
	public void setVideo(Video video) {
		this.video = video;
	}
	public Actor getActor() {
		return actor;
	}
	public void setActor(Actor actor) {
		this.actor = actor;
	}
	public int getVideoId() {
		return videoId;
	}
	public void setVideoId(int videoId) {
		this.videoId = videoId;
	}
	public int getActorId() {
		return actorId;
	}
	public void setActorId(int actorId) {
		this.actorId = actorId;
	}
	

}
