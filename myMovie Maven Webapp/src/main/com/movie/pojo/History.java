package com.movie.pojo;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class History {
	
	private Integer history_Id;//�ۿ���ʷID
	@DateTimeFormat(pattern="yyyy-MM-ddHH:mm:ss") 
	private Date history_LastTime;//�ϴιۿ�ʱ��
	private Integer userId;//�û�ID
	private Integer videoId;//��ƵID
	
	private User user;//�û�����
	private List<Video> vList;//һ����ʷ��¼�����ж����Ƶ
	
	
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

	public History(Integer history_Id,Date history_LastTime,Integer userId,Integer videoId) {

		this.history_Id = history_Id;
        this.history_LastTime = history_LastTime;
        this.userId = userId;
        this.videoId = videoId;        
    }

    public History() {
        super();
    }
	public Integer getHistory_Id() {
		return history_Id;
	}
	public void setHistory_Id(Integer history_Id) {
		this.history_Id = history_Id;
	}
	public Date getHistory_LastTime() {
		return history_LastTime;
	}
	public void setHistory_LastTime(Date history_LastTime) {
		this.history_LastTime = history_LastTime;
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

	@Override
	public String toString() {
		return "History [history_Id=" + history_Id + ", history_LastTime=" + history_LastTime + ", userId=" + userId
				+ ", videoId=" + videoId + ", user=" + user + ", vList=" + vList + "]";
	}
	
}
