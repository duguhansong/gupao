package com.yitian.practice.netty.coder.vo;

import java.io.Serializable;

import org.msgpack.annotation.Message;

@Message
public class UserInfo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6977216130137788172L;
	private String userName;
	private String userId;
	private int age;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "UserInfo [userName=" + userName + ", userId=" + userId + ", age=" + age + "]";
	}
	
}
