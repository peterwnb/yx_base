package com.farsunset.cim.model;

import java.io.Serializable;

public class Friend implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6955022073143991820L;
	private String account;
	private int status;
	private String host;
	private String channel;
	private String avatar;//用户头像地址
	private int gender; //性别
	
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	
}
