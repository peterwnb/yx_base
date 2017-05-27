package com.geek.yx.common.core.base;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.alibaba.fastjson.JSON;
import com.esotericsoftware.reflectasm.MethodAccess;
import com.geek.yx.common.Constants;
import com.geek.yx.common.core.util.ExceptionUtil;
import com.geek.yx.model.BaseModel;
import com.geek.yx.model.MongoBean;

public abstract class BaseProviderImpl implements ApplicationContextAware, BaseProvider {
    protected static Logger logger = LogManager.getLogger();
    private ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public Parameter execute(Parameter parameter) {
        String no = parameter.getNo();
        logger.info("{} request：{}", no, JSON.toJSONString(parameter));
        Object service = applicationContext.getBean(parameter.getService());
        try {
            Long id = parameter.getId();
            BaseModel model = parameter.getModel();
            MongoBean mongoBean = parameter.getMongoBean();
            List<?> list = parameter.getList();
            Map<?, ?> map = parameter.getMap();	
            Object result = null;
            MethodAccess methodAccess = MethodAccess.get(service.getClass());
            if (id != null) {
                result = methodAccess.invoke(service, parameter.getMethod(), parameter.getId());
            } else if (model != null) {
                result = methodAccess.invoke(service, parameter.getMethod(), parameter.getModel());
            } else if (list != null) {
                result = methodAccess.invoke(service, parameter.getMethod(), parameter.getList());
            } else if (map != null) {
                result = methodAccess.invoke(service, parameter.getMethod(), parameter.getMap());
            } else if(null != mongoBean){
            	result = methodAccess.invoke(service, parameter.getMethod(), parameter.getMongoBean());
            }else {
                result = methodAccess.invoke(service, parameter.getMethod());
            }
            if (result != null) {
                Parameter response = new Parameter(result);
                logger.info("{} response：{}", no, JSON.toJSONString(response));
                return response;
            }
            logger.info("{} response empty.", no);
            return null;
        } catch (Exception e) {
            String msg = ExceptionUtil.getStackTraceAsString(e);
            logger.error(no + " " + Constants.Exception_Head + msg, e);
            throw e;
        }
    }
}
