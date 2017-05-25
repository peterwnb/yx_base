package com.geek.yx.web;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.geek.yx.common.core.base.AbstractController;
import com.geek.yx.common.core.base.Parameter;
import com.geek.yx.common.core.support.Assert;
import com.geek.yx.common.core.vo.BaseResponse;
import com.geek.yx.common.core.vo.ResultCodeEnum;
import com.geek.yx.model.Account;
import com.geek.yx.provider.IAccountProvider;

import io.swagger.annotations.Api;
@RestController
@Api(value = "账号接口", description = "账号接口")
public class AccountController extends AbstractController<IAccountProvider>{

	@Override
	public String getService() {
		return "accountService";
	}
	
	@PostMapping("/regist")
	public Object regist(@RequestBody Account account){
		Assert.isNotBlank(account.getAccount(), "ACCOUNT");
		Parameter parameter = new Parameter(getService(), "createAccount").setModel(account);
		Parameter result = provider.execute(parameter);
		return new BaseResponse(result.getResult());
	}
	
	@PostMapping("/login")
	public Object login(@RequestBody Account account){
		Assert.isNotBlank(account.getAccount(), "ACCOUNT");
		Assert.isNotBlank(account.getPassword(), "PASSWORD");
		Parameter parameter = new Parameter(getService(), "authAccount").setModel(account);
		Parameter result = provider.execute(parameter);
		if(null != result &&  null != result.getBaseResponse()){
			return result.getBaseResponse();
		}
		return new BaseResponse(ResultCodeEnum.SERVER_INTERNAL_ERROR);
	}
}