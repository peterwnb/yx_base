package com.geek.yx.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

@TableName("aas_account")
@SuppressWarnings("serial")
public class Account extends BaseModel {
	@TableField("account")
	private String account;
	
	@TableField("password")
	private String password;
	
	@TableField("phone")
	private String phone;
	
	@TableField("account_type")
	private Integer accountType;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getAccountType() {
		return accountType;
	}

	public void setAccountType(Integer accountType) {
		this.accountType = accountType;
	}

}
