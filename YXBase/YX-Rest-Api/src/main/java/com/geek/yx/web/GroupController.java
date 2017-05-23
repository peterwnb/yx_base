package com.geek.yx.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geek.yx.common.core.base.AbstractController;
import com.geek.yx.common.core.base.Parameter;
import com.geek.yx.common.core.support.Assert;
import com.geek.yx.common.core.vo.BaseResponse;
import com.geek.yx.common.core.vo.ResultCodeEnum;
import com.geek.yx.model.GroupMember;
import com.geek.yx.model.UserGroup;
import com.geek.yx.provider.IUserProvider;

import io.swagger.annotations.Api;
@RestController
@Api(value = "用户群组接口", description = "用户群组接口")
@RequestMapping(value = "/group")
public class GroupController extends AbstractController<IUserProvider>{

	@Override
	public String getService() {
		return "groupService";
	}

	@PostMapping("/create")
	public Object createGroup(@RequestBody UserGroup group){
		Assert.isNotBlank(group.getGroupName(), "GroupName");
		Parameter parameter = new Parameter(getService(), "createGroup").setModel(group);
		Parameter result = provider.execute(parameter);
		return new BaseResponse(result.getResult());
	}
	
	/**
	 * 获取用户的群组列表
	 * @param userId
	 * @return
	 */
	@GetMapping("/{userId}/list")
	public Object getGroupList(@PathVariable("userId")String userId){
		Assert.isNotBlank(userId, "USERID");
		UserGroup group = new UserGroup();
		group.setUserId(Long.parseLong(userId));
		Parameter parameter = new Parameter(getService(), "getGroups").setModel(group);
		Parameter result = provider.execute(parameter);
		return new BaseResponse(ResultCodeEnum.SUCCESS,result.getList());
	}
	
	/**
	 * 获取群组内成员列表
	 * @return
	 */
	@GetMapping("/{groupId}/members")
	public Object getGroupMembers(@PathVariable("groupId")String groupId){
		Assert.isNotBlank(groupId, "groupId");
		GroupMember member = new GroupMember();
		member.setGroupId(Long.parseLong(groupId));
		Parameter parameter = new Parameter(getService(), "getGroupMembers").setModel(member);
		Parameter result = provider.execute(parameter);
		return new BaseResponse(ResultCodeEnum.SUCCESS,result.getList());
	}
}
