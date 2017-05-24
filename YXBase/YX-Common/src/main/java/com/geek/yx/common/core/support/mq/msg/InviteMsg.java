package com.geek.yx.common.core.support.mq.msg;

import java.io.Serializable;

import com.alibaba.fastjson.JSON;

public class InviteMsg implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3339214317576454474L;
	
	private String sender; //发起者ID
	
	private String receiver; //接受者ID
	
	private String opType; //操作  1：邀请 ， 2：应答邀请

	
	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getOpType() {
		return opType;
	}

	public void setOpType(String opType) {
		this.opType = opType;
	}

	public String toString(){
		return JSON.toJSONString(this);
	}
}
