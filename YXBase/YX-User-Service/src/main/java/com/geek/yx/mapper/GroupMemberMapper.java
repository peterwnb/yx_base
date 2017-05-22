package com.geek.yx.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.geek.yx.common.core.base.BaseMapper;
import com.geek.yx.model.GroupMember;

public interface GroupMemberMapper extends BaseMapper<GroupMember>{
	List<Map<String,Object>> getGroupMembers(@Param("groupId")Long groupId);
}
