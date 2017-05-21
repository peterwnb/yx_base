package com.geek.yx.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.geek.yx.common.core.base.BaseModel;

@TableName("aas_user")
@SuppressWarnings("serial")
public class User extends BaseModel {
	@TableField("user_id")
	private Long userId;

	@TableField("user_name")
	private String userName;

	@TableField("phone")
	private String phone;

	@TableField("email")
	private String email;

	@TableField("address")
	private String address;

	@TableField("avatar")
	private String avatar;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

}