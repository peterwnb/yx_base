package com.geek.yx.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import com.geek.yx.common.Constants.ENABLE_STAT;
import com.geek.yx.common.Constants.GROUP_JOIN_STATUS;
import com.geek.yx.common.Constants.GROUP_MEMBER_TYPE;
import com.geek.yx.common.Constants.GROUP_TYPE;
import com.geek.yx.common.core.base.BaseService;
import com.geek.yx.common.core.vo.ResultCodeEnum;
import com.geek.yx.common.core.vo.ResultObj;
import com.geek.yx.mapper.GroupMemberMapper;
import com.geek.yx.mapper.UserGroupMapper;
import com.geek.yx.model.GroupMember;
import com.geek.yx.model.UserGroup;

/**
 * 用户群组服务实现类
 * @author lenovo
 */
@Service("groupService")
@CacheConfig(cacheNames = "group")
public class GroupService extends BaseService<UserGroup>{
	@Autowired
	private UserGroupMapper userGroupMapper;
	
	@Autowired
	private GroupMemberMapper memberMapper;

	/**
	 * 创建群组
	 * @param UserGroup 用户群组实体
	 * @return
	 */
	public ResultObj createGroup(UserGroup group){
		UserGroup dbGroup = userGroupMapper.selectByIdAndName(group);
		if(null != dbGroup){
			return new ResultObj(ResultCodeEnum.USER_GROU_NAME_REPEAT);
		}
		//插入群组信息
		Date date = new Date();
		group.setCreateTime(date);
		group.setEnable(ENABLE_STAT.ENABLE);
		group.setType(GROUP_TYPE.NORMAL);
		group.setUpdateTime(date);
		userGroupMapper.insert(group);
		
		//插入群组成员
		GroupMember member = new GroupMember();
		member.setCreateTime(date);
		member.setUpdateTime(date);
		member.setUserType(GROUP_MEMBER_TYPE.CREATOR);
		member.setUserId(group.getUserId());
		member.setJoinStatus(GROUP_JOIN_STATUS.PASSED);
		member.setGroupId(group.getId());
		memberMapper.insert(member);
		
		return new ResultObj();
	}
	
	/**
	 * 获取用户群组列表
	 * @param group
	 * @return
	 */
	public List<UserGroup> getGroups(UserGroup group){
		return userGroupMapper.selectByUserId(group.getUserId());
	}
	
	/**
	 * 获取群组成员列表
	 * @return
	 */
	public List<Map<String,Object>> getGroupMembers(GroupMember member){
		return memberMapper.getGroupMembers(member.getGroupId());
	}
}
