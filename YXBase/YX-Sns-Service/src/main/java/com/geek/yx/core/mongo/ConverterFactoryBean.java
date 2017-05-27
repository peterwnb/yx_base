/*
 * Copyright (C), 2002-2013, 电子商务有限公司
 * FileName: ConverterFactoryBean.java
 * Author:   12070644@cnsuning.com
 * Date:     2013-9-27 上午00:00:00
 */
package com.geek.yx.core.mongo;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.convert.MongoTypeMapper;

/**
 * Mongodb转化类
 * 
 * @author peter
 */
public class ConverterFactoryBean implements FactoryBean<MappingMongoConverter> {
    /**
     * 
     */
    private MappingMongoConverter converter;

    /**
     * 
     * 
     * @param converter
     */
    public void setConverter(MappingMongoConverter converter) {
        this.converter = converter;
    }

    /**
     * 
     */
    public MappingMongoConverter getObject() throws Exception {
        MongoTypeMapper typeMapper = new DefaultMongoTypeMapper(null);
        converter.setTypeMapper(typeMapper);
        return converter;
    }

    /**
     * 
     */
    public Class<?> getObjectType() {
        return MappingMongoConverter.class;
    }

    /**
     * 
     */
    public boolean isSingleton() {
        return true;
    }

}