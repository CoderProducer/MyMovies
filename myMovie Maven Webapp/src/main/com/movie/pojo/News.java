package com.movie.pojo;

import java.util.Date;

public class News {
	
	private Integer news_Id;//����ID
	private String news_PictureAddress;//����ͼƬ��ַ
	private String news_Title;//���ű���
	private String news_VideoTitle;//���ű�������Ƶ����
	private String news_Introduce;//��������
	private Date news_Date;//��������
	
	public Integer getNews_Id() {
		return news_Id;
	}
	public void setNews_Id(Integer news_Id) {
		this.news_Id = news_Id;
	}
	public String getNews_PictureAddress() {
		return news_PictureAddress;
	}
	public void setNews_PictureAddress(String news_PictureAddress) {
		this.news_PictureAddress = news_PictureAddress;
	}
	public String getNews_Title() {
		return news_Title;
	}
	public void setNews_Title(String news_Title) {
		this.news_Title = news_Title;
	}
	public String getNews_VideoTitle() {
		return news_VideoTitle;
	}
	public void setNews_VideoTitle(String news_VideoTitle) {
		this.news_VideoTitle = news_VideoTitle;
	}
	public String getNews_Introduce() {
		return news_Introduce;
	}
	public void setNews_Introduce(String news_Introduce) {
		this.news_Introduce = news_Introduce;
	}
	public Date getNews_Date() {
		return news_Date;
	}
	public void setNews_Date(Date news_Date) {
		this.news_Date = news_Date;
	}

	
	
}
