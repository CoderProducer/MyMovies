package com.movie.pojo;

public class User {
	
	private Integer user_Id;//用户ID
	private String user_Name;//用户账号名
	private String user_Password;//用户密码
	private String user_Tel;//用户电话号码
	private String user_Email;//用户邮箱号
	private String user_QQ;//用户QQ号
	
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
