package com.movie.pojo;

public class User {
	
	private Integer user_Id;//�û�ID
	private String user_Name;//�û��˺���
	private String user_Password;//�û�����
	private String user_Tel;//�û��绰����
	private String user_Email;//�û������
	private String user_QQ;//�û�QQ��
	
	public Integer getUser_Id() {
		return user_Id;
	}
	public void setUser_Id(Integer user_Id) {
		this.user_Id = user_Id;
	}
	public String getUser_Name() {
		return user_Name;
	}
	public void setUser_Name(String user_Name) {
		this.user_Name = user_Name;
	}
	public String getUser_Password() {
		return user_Password;
	}
	public void setUser_Password(String user_Password) {
		this.user_Password = user_Password;
	}
	public String getUser_Tel() {
		return user_Tel;
	}
	public void setUser_Tel(String user_Tel) {
		this.user_Tel = user_Tel;
	}
	public String getUser_Email() {
		return user_Email;
	}
	public void setUser_Email(String user_Email) {
		this.user_Email = user_Email;
	}
	public String getUser_QQ() {
		return user_QQ;
	}
	public void setUser_QQ(String user_QQ) {
		this.user_QQ = user_QQ;
	}
//	@Override
//    public String toString() {
//        return "User [user_Id=" + user_Id + ", user_Name=" + user_Name
//                + ", user_Password=" + user_Password + ", user_Tel="
//                + user_Tel + ", user_Email=" + user_Email + ", user_QQ=" + user_QQ+"]";
//    }
}
