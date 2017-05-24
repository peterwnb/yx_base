package com.geek.yx.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;

@TableName("user_friend")
@SuppressWarnings("serial")
public class Friend extends BaseModel{
	@TableField("user_id")
	private Long userId;  //自身ID
	
	@TableField("friend_id") //好友ID
	private Long friendId;
	
	@TableField("status_")
	private Integer status;  //好友状态
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getFriendId() {
		return friendId;
	}
	public void setFriendId(Long friendId) {
		this.friendId = friendId;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
}
