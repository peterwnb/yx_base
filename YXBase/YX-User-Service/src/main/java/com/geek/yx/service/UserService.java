package com.geek.yx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import com.geek.yx.common.core.base.BaseService;
import com.geek.yx.mapper.UserMapper;
import com.geek.yx.model.User;

/**
 * 用户体系服务实现类
 * @author lenovo
 */
@Service
@CacheConfig(cacheNames = "User")
public class UserService extends BaseService<User>{
	@Autowired
	private UserMapper userMapper;
	
	public User queryByPhone(String phone){
		return userMapper.queryByphone(phone);
	}
	
	public void init() {
		/*List<Long> list = ((UserMapper) mapper).selectIdPage(Collections.<String, Object>emptyMap());
		for (Long id : list) {
			CacheUtil.getCache().set(getCacheKey(id), mapper.selectById(id));
		}*/
		System.out.println("init user cache...");
	}
}