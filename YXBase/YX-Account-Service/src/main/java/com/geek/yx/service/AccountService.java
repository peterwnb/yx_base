package com.geek.yx.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.geek.yx.common.Constants;
import com.geek.yx.common.core.base.Parameter;
import com.geek.yx.common.core.util.CacheUtil;
import com.geek.yx.common.core.util.ValidatorUtils;
import com.geek.yx.common.core.vo.AESCoderUtil;
import com.geek.yx.common.core.vo.BaseResponse;
import com.geek.yx.common.core.vo.ResultCodeEnum;
import com.geek.yx.common.core.vo.ResultObj;
import com.geek.yx.common.core.vo.ServerToken;
import com.geek.yx.mapper.AccountMapper;
import com.geek.yx.model.Account;
import com.geek.yx.model.User;
import com.geek.yx.provider.IUserProvider;

@Service("accountService")
public class AccountService {
	@Autowired
	private IUserProvider provider;

	@Autowired
	private AccountMapper accountMapper;

	private String getUserService() {
		return "userService";
	}

	/**
	 * 创建账号
	 * 
	 * @return
	 */
	@Transactional
	public ResultObj createAccount(Account account) {

		Account dbInfo = accountMapper.queryByAccount(account.getAccount());

		if (null != dbInfo) {
			return new ResultObj(ResultCodeEnum.ACCOUNT_ACCOUNT_REPEAT);
		}
		Date d = new Date();
		account.setCreateTime(d);
		account.setUpdateTime(d);
		// 插入信息
		User user = new User();
		if (ValidatorUtils.isMobile(account.getAccount())) {
			account.setPhone(account.getAccount());
			user.setPhone(account.getAccount());
		}
		// 插入信息
		if (ValidatorUtils.isEmail(account.getAccount())) {
			account.setPhone(account.getAccount());
			user.setEmail(account.getAccount());
		}
		accountMapper.insert(account);
		user.setAccountId(account.getId());
		Parameter parameter = new Parameter(getUserService(), "createUser").setModel(user);
		Parameter result = provider.execute(parameter);
		result.getResult();

		return new ResultObj();
	}

	/**
	 * 账号授权登陆
	 * 
	 * @return
	 */
	public BaseResponse authAccount(Account account) {
		Account dbInfo = accountMapper.queryByAccount(account.getAccount());
		if (null == dbInfo) {
			return new BaseResponse(ResultCodeEnum.ACCOUNT_AUTH_FAILED);
		}

		if (!account.getPassword().equals(dbInfo.getPassword())) {
			return new BaseResponse(ResultCodeEnum.ACCOUNT_AUTH_FAILED);
		}

		Map<String, Object> data = new HashMap<String, Object>();
		// Map<String,Object> userInfo = new HashMap<String,Object>();

		long timestamp = new Date().getTime();

		String token = AESCoderUtil.encodeAMStoken(
				new ServerToken(dbInfo.getId() + "", dbInfo.getPhone(), dbInfo.getAccountType(), timestamp));

		// 先删除原有的旧的token
		CacheUtil.getCache().del(Constants.TOKEN_KEY + dbInfo.getId());

		// 重新设置token 12小时失效
		CacheUtil.getCache().set(Constants.TOKEN_KEY + dbInfo.getId(), token, 12 * 60 * 60 * 1000);
		data.put("token", token);
		data.put("accountId", dbInfo.getId());

		// 根据账号ID反查用户基本信息
		User user = new User();
		user.setAccountId(dbInfo.getId());

		Parameter parameter = new Parameter(getUserService(), "queryByAccount").setModel(user);
		Parameter result = provider.execute(parameter);

		if (null != result && null != result.getModel()) {
			User userResult = (User) result.getModel();
			data.put("userInfo", userResult);
		}
		return new BaseResponse(data);
	}
}
