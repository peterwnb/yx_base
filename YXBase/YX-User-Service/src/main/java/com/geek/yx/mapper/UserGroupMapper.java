package com.geek.yx.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.geek.yx.common.core.base.BaseMapper;
import com.geek.yx.model.UserGroup;

public interface UserGroupMapper extends BaseMapper<UserGroup>{
	UserGroup selectByIdAndName(UserGroup group);
	
	List<UserGroup> selectByUserId(@Param("userId")Long userId);
}
