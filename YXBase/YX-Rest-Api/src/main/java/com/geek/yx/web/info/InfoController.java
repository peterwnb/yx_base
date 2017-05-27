package com.geek.yx.web.info;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geek.yx.bean.InfoBean;
import com.geek.yx.common.core.base.AbstractController;
import com.geek.yx.common.core.base.Parameter;
import com.geek.yx.common.core.support.Assert;
import com.geek.yx.common.core.vo.BaseResponse;
import com.geek.yx.provider.ISnsProvider;

import io.swagger.annotations.Api;

@RestController
@Api(value = "微博信息接口", description = "微博接口")
@RequestMapping(value = "/info")
public class InfoController extends AbstractController<ISnsProvider>{

	@Override
	public String getService() {
		return "infoService";
	}
	
	@PostMapping("/addInfo")
	public BaseResponse addInfo(@RequestBody InfoBean info){
		Assert.isNotBlank(info.getUserId(), "USER_ID");
		Parameter parameter = new Parameter(getService(), "createInfo").setMongoBean(info);;
		Parameter result = provider.execute(parameter);
		return new BaseResponse(result.getBaseResponse());
	}

}
