package com.geek.yx.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geek.yx.common.core.base.AbstractController;
import com.geek.yx.common.core.base.Parameter;
import com.geek.yx.common.core.support.Assert;
import com.geek.yx.common.core.vo.BaseResponse;
import com.geek.yx.common.core.vo.ResultCodeEnum;
import com.geek.yx.model.Friend;
import com.geek.yx.provider.IUserProvider;

import io.swagger.annotations.Api;

@RestController
@Api(value = "好友操作接口", description = "好友接口")
@RequestMapping(value = "/friend")
public class FriendController extends AbstractController<IUserProvider>{

	@Override
	public String getService() {
		return "friendService";
	}
	
	/**
	 * 邀请好友
	 * @param invitorId ：邀请者用户ID
	 * @param invitedId ：被邀请用户ID
	 * @return
	 */
	@PutMapping("/{invitorId}/invite/{invitedId}")
	public Object queryUserByPhone(@PathVariable("invitorId")String invitorId, @PathVariable("invitedId")String invitedId){
		Assert.isNotBlank(invitorId, "invitorId");
		Assert.isNotBlank(invitedId, "invitedId");
		Friend friend = new Friend();
		friend.setUserId(Long.parseLong(invitorId));
		friend.setFriendId(Long.parseLong(invitedId));
		Parameter parameter = new Parameter(getService(), "addInviteInfo").setModel(friend);
		Parameter resultP = provider.execute(parameter);
		return new BaseResponse(resultP.getResult());
	}
	
	/**
	 * 应答好友邀请
	 * @return
	 */
	@PutMapping("/{invitedId}/reply_invite/{invitorId}/{opType}")
	public Object replyInvite( @PathVariable("invitedId")String invitedId ,
			@PathVariable("invitorId")String invitorId,
			@PathVariable("opType")String opType){
		Assert.isNotBlank(invitedId, "invitedId");
		Assert.isNotBlank(invitorId, "invitorId");
		Assert.isNotBlank(opType, "opType");
		
		Friend friend = new Friend();
		friend.setUserId(Long.parseLong(invitorId));
		friend.setFriendId(Long.parseLong(invitedId));
		friend.setStatus(Integer.parseInt(opType));
		Parameter parameter = new Parameter(getService(), "replyInvite").setModel(friend);
		Parameter resultP = provider.execute(parameter);
		return new BaseResponse(resultP.getResult());
	}
	
	/**
	 * 发现新的好友
	 * @return
	 */
	@GetMapping("/{userId}/newer")
	public Object queryNewFriend(@PathVariable("userId")String userId){
		Assert.isNotBlank(userId, "userId");
		Friend friend = new Friend();
		friend.setUserId(Long.parseLong(userId));
		Parameter parameter = new Parameter(getService(), "queryNewer").setModel(friend);
		Parameter result = provider.execute(parameter);
		return new BaseResponse(ResultCodeEnum.SUCCESS,result.getList());
	}
	
	/**
	 * 获取好友列表
	 * @return
	 */
	@GetMapping("/list/{userId}")
	public Object getFriendList(@PathVariable("userId")String userId){
		Assert.isNotBlank(userId, "userId");
		Friend friend = new Friend();
		friend.setUserId(Long.parseLong(userId));
		Parameter parameter = new Parameter(getService(), "getFriendList").setModel(friend);
		Parameter result = provider.execute(parameter);
		return new BaseResponse(ResultCodeEnum.SUCCESS,result.getList());
	}

}
