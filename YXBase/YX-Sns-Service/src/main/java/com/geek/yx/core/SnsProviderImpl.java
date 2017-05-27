package com.geek.yx.core;

import com.alibaba.dubbo.config.annotation.Service;
import com.geek.yx.common.core.base.BaseProviderImpl;
import com.geek.yx.provider.ISnsProvider;
/**
 * dubbo服务实现
 * @author lenovo
 *
 */
@Service(interfaceClass = ISnsProvider.class)
public class SnsProviderImpl extends BaseProviderImpl implements ISnsProvider{

}
