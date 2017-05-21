package com.geek.yx.core;

import com.alibaba.dubbo.config.annotation.Service;
import com.geek.yx.common.core.base.BaseProviderImpl;
import com.geek.yx.provider.IUserProvider;

@Service(interfaceClass = IUserProvider.class)
public class UserProviderImpl extends BaseProviderImpl implements IUserProvider{

}
