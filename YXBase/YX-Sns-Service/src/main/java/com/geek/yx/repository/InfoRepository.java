package com.geek.yx.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.geek.yx.bean.InfoBean;

/**
 * 
 * 微博信息操作类<br>
 * 〈功能详细描述〉
 * 
 * @author 13082776
 * @see [相关类/方法]（可选）
 * @since [产品/模块版本] （可选）
 */
public interface InfoRepository extends MongoRepository<InfoBean, String>{
	
}
