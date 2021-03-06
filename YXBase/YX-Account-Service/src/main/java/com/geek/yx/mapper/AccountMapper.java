package com.geek.yx.mapper;

import org.apache.ibatis.annotations.Param;

import com.geek.yx.common.core.base.BaseMapper;
import com.geek.yx.model.Account;

public interface AccountMapper extends BaseMapper<Account>{
	/**
	 * 根据账号查询账号是否存在
	 * @return
	 */
	public Account queryByAccount(@Param("account")String account);
	
}
