package com.movie.pojo;

import java.util.Date;
import java.util.List;


public class Video {

		private Integer video_Id;//��ƵID
		private String video_Name;//��Ƶ����		
		private String video_BigType;//��Ƶ����
		private String video_SmallType;//��Ƶ����
		private Integer video_Season;//��Ƶ��/����
		private String video_PictureAddress;//��ƵͼƬ��ַ
		private String video_Introduce;//��Ƶ���
		private String video_Director;//��Ƶ����
		private Integer video_Duration;//��ƵƬ��
		private String video_Address;//��Ƶ��ַ
		private Date video_Published;//��Ƶ��ӳ����
		private Double video_Point;//��Ƶ����
		private Integer video_HotPoint;//��Ƶ�ȵ�
		private String video_KeyWords;//��Ƶ�ؼ���
		private String video_AgeTime;//��Ƶ�������
		private String video_Country;//��Ƶ���й���
		private List<Actor> actorList;//��Ա�б�
		
		
		public List<Actor> getActorList() {
			return actorList;
		}

		public void setActorList(List<Actor> actorList) {
			this.actorList = actorList;
		}

		public Video(Integer video_Id, String video_Name, String video_BigType, 
				String video_SmallType, Integer video_Season,String video_PictureAddress, String video_Introduce, 
				String video_Director,Integer video_Duration,String video_Address,Date video_Published,
				Double video_Point,Integer video_HotPoint,String video_KeyWords,String video_AgeTime,String video_Country) {

			this.video_Id = video_Id;
	        this.video_Name = video_Name;
	        this.video_BigType = video_BigType;
	        this.video_SmallType = video_SmallType;
	        this.video_Season = video_Season;
	        this.video_PictureAddress = video_PictureAddress;
	        this.video_Introduce = video_Introduce;
	        this.video_Director = video_Director;
	        this.video_Duration = video_Duration;
	        this.video_Address = video_Address;
	        this.video_Published = video_Published;
	        this.video_Point = video_Point;
	        this.video_HotPoint = video_HotPoint;
	        this.video_KeyWords = video_KeyWords;
	        this.video_AgeTime = video_AgeTime;
	        this.video_Country = video_Country;
	    }

	    public Video() {
	        super();
	    }
	    
		public Integer getVideo_Id() {
			return video_Id;
		}
		public void setVideo_Id(Integer video_Id) {
			this.video_Id = video_Id;
		}
		public String getVideo_Name() {
			return video_Name;
		}
		public void setVideo_Name(String video_Name) {
			this.video_Name = video_Name;
		}
		public String getVideo_BigType() {
			return video_BigType;
		}
		public void setVideo_BigType(String video_BigType) {
			this.video_BigType = video_BigType;
		}
		public String getVideo_SmallType() {
			return video_SmallType;
		}
		public void setVideo_SmallType(String video_SmallType) {
			this.video_SmallType = video_SmallType;
		}
		public Integer getVideo_Season() {
			return video_Season;
		}
		public void setVideo_Season(Integer video_Season) {
			this.video_Season = video_Season;
		}
		public String getVideo_PictureAddress() {
			return video_PictureAddress;
		}
		public void setVideo_PictureAddress(String video_PictureAddress) {
			this.video_PictureAddress = video_PictureAddress;
		}
		public String getVideo_Introduce() {
			return video_Introduce;
		}
		public void setVideo_Introduce(String video_Introduce) {
			this.video_Introduce = video_Introduce;
		}
		public String getVideo_Director() {
			return video_Director;
		}
		public void setVideo_Director(String video_Director) {
			this.video_Director = video_Director;
		}
		public Integer getVideo_Duration() {
			return video_Duration;
		}
		public void setVideo_Duration(Integer video_Duration) {
			this.video_Duration = video_Duration;
		}
		public String getVideo_Address() {
			return video_Address;
		}
		public void setVideo_Address(String video_Address) {
			this.video_Address = video_Address;
		}
		public Date getVideo_Published() {
			return video_Published;
		}
		public void setVideo_Published(Date video_Published) {
			this.video_Published = video_Published;
		}
		public Double getVideo_Point() {
			return video_Point;
		}
		public void setVideo_Point(Double video_Point) {
			this.video_Point = video_Point;
		}
		public Integer getVideo_HotPoint() {
			return video_HotPoint;
		}
		public void setVideo_HotPoint(Integer video_HotPoint) {
			this.video_HotPoint = video_HotPoint;
		}
		public String getVideo_KeyWords() {
			return video_KeyWords;
		}
		public void setVideo_KeyWords(String video_KeyWords) {
			this.video_KeyWords = video_KeyWords;
		}

		public String getVideo_AgeTime() {
			return video_AgeTime;
		}

		public void setVideo_AgeTime(String video_AgeTime) {
			this.video_AgeTime = video_AgeTime;
		}

		public String getVideo_Country() {
			return video_Country;
		}

		public void setVideo_Country(String video_Country) {
			this.video_Country = video_Country;
		}
		
		/**
		 * @Override
	    public String toString() {
	        return "videoInfo [video_Id=" + video_Id + ", video_BigType=" + video_BigType
	                + ", video_SmallType=" + video_SmallType + ", video_Season="
	                + video_Season + ", video_PictureAddress=" + video_PictureAddress + ", video_Introduce="
	                + video_Introduce + ", video_Address=" + video_Address + ", video_Published="
	                + video_Published + ", video_Point=" + video_Point + ", video_HotPoint="
	                + video_HotPoint + ",video_KeyWords=" + video_KeyWords+", video_Director=" + video_Director + ",video_Duration=" + video_Duration + "]";
	    }
		 * 
		 * 
		 * 
		 */		
	
}
