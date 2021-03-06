package com.geek.yx.common.core.vo;

import java.io.Serializable;

public class ServerToken implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6599611489603632785L;
	private String accountId; // 账号ID
	private String mobile; // 手机号
	private Integer clientType; // 1:ios 2:android 3:pc
	private long createTime; // 生成时间戳

	public ServerToken() {
	}

	public ServerToken(String accountId, String mobile, Integer clientType, long createTime) {
		this.accountId = accountId;
		this.mobile = mobile;
		this.createTime = createTime;
		this.clientType = clientType;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Integer getClientType() {
		return clientType;
	}

	public void setClientType(Integer clientType) {
		this.clientType = clientType;
	}

	public long getCreateTime() {
		return createTime;
	}

	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "ServerToken [createTime=" + createTime + ", phoneNum=" + mobile + ", accountId=" + accountId
				+ ", clientType=" + clientType + "]";
	}

}
