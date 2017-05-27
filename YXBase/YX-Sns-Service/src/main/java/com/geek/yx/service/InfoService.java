package com.geek.yx.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geek.yx.bean.InfoBean;
import com.geek.yx.common.core.vo.BaseResponse;
import com.geek.yx.provider.IUserProvider;
import com.geek.yx.repository.InfoRepository;

@Service("infoService")
public class InfoService {
	@Autowired
	private IUserProvider userProvider;
	
	@Autowired
	private InfoRepository infoRepository;
	
	
    /**
     * 创建微博 功能描述: <br>
     * 〈功能详细描述〉
     * @param InfoBean info实体
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
	public BaseResponse createInfo(InfoBean info){
		//保存微博信息
		infoRepository.save(info);
		return new BaseResponse();
	}
	
	public BaseResponse queryInfoList(Map<String,Object> cond){
		return new BaseResponse();
	}
}
