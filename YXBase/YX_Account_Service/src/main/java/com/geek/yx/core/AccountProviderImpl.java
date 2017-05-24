package com.geek.yx.core;

import com.alibaba.dubbo.config.annotation.Service;
import com.geek.yx.common.core.base.BaseProviderImpl;
import com.geek.yx.provider.IAccountProvider;

@Service(interfaceClass = IAccountProvider.class)
public class AccountProviderImpl extends BaseProviderImpl implements IAccountProvider{

}