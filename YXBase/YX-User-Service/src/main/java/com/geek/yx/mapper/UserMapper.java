package com.geek.yx.mapper;

import org.apache.ibatis.annotations.Param;

import com.geek.yx.model.User;

public interface UserMapper {
	public User queryByphone(@Param("phone")String phone);
}
