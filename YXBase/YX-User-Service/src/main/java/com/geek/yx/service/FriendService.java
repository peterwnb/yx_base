package com.geek.yx.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.geek.yx.common.Constants.FRIEND_STATUS;
import com.geek.yx.common.Constants.INVITE_OP;
import com.geek.yx.common.Constants.MQ_NAME;
import com.geek.yx.common.core.base.BaseService;
import com.geek.yx.common.core.support.mq.QueueSender;
import com.geek.yx.common.core.support.mq.msg.InviteMsg;
import com.geek.yx.common.core.vo.ResultCodeEnum;
import com.geek.yx.common.core.vo.ResultObj;
import com.geek.yx.mapper.FriendMapper;
import com.geek.yx.model.Friend;

/**
 * 用户好友服务实现类
 * @author lenovo
 */
@Service("friendService")
@CacheConfig(cacheNames = "friend")
public class FriendService extends BaseService<Friend>{
	@Autowired
	private FriendMapper friemdMapper;
	
	@Autowired
	private QueueSender queueSender;
	
	/**
	 * 新增加好友邀请
	 * @return
	 */
	@Transactional
	public ResultObj addInviteInfo(Friend friend){
		//判断手机号是否重复
		Friend dbInfo = friemdMapper.queryInviteInfo(friend);
		if(null != dbInfo){
			return new ResultObj(ResultCodeEnum.USER_ADD_FRIEND_REPEAT);
		}
		//插入信息
		Date d = new Date();
		friend.setCreateTime(d);
		friend.setUpdateTime(d);
		friend.setStatus(0);
		friemdMapper.insert(friend);
		
		InviteMsg msg = new InviteMsg();
		msg.setSender(""+friend.getUserId());
		msg.setReceiver(""+friend.getFriendId());
		msg.setOpType(INVITE_OP.INVITE);
		queueSender.send(MQ_NAME.INVITE_MSG, msg.toString());
		return new ResultObj();
	}
	
	/**
	 * 应答加好友邀请
	 * @return
	 */
	@Transactional
	public ResultObj replyInvite(Friend friend){
		//判断手机号是否重复
		Friend dbInfo = friemdMapper.queryInviteInfo(friend);
		if(null == dbInfo){
			return new ResultObj(ResultCodeEnum.USER_INVITE_EXPIRED);
		}
		
		if(friend.getStatus() == FRIEND_STATUS.AGREE){
			//如果是同意加好友，修改状态为1
			Date d = new Date();
			friend.setUpdateTime(d);
			friemdMapper.updateInviteStatus(friend);
			queueSender.send(MQ_NAME.INVITE_MSG, "invite success");
			
			InviteMsg msg = new InviteMsg();
			msg.setSender(""+friend.getUserId());
			msg.setReceiver(""+friend.getFriendId());
			msg.setOpType(INVITE_OP.RSP_INVITE_YES);
			queueSender.send(MQ_NAME.INVITE_MSG, msg.toString());
		} else {
			//如果是不通过邀请，直接删除
			friemdMapper.deleteById(dbInfo.getId());
			
			InviteMsg msg = new InviteMsg();
			msg.setSender(""+friend.getUserId());
			msg.setReceiver(""+friend.getFriendId());
			msg.setOpType(INVITE_OP.RSP_INVITE_NO);
			
			queueSender.send(MQ_NAME.INVITE_MSG, msg.toString());
		}
		return new ResultObj();
	}
	
	/**
	 * 发现新好友
	 * @return
	 */
	public List<Map<String,Object>> queryNewer(Friend friend){
		return friemdMapper.queryNew(friend.getUserId());
	}
	
	/**
	 * 获取好友列表
	 * @param friend
	 * @return
	 */
	public List<Map<String,Object>> getFriendList(Friend friend){
		return friemdMapper.queryFriendList(friend.getUserId());
	}
}
