package com.geek.yx.common.core.base;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.toolkit.IdWorker;
import com.geek.yx.common.core.vo.BaseResponse;
import com.geek.yx.common.core.vo.ResultObj;
import com.geek.yx.model.BaseModel;
import com.geek.yx.model.MongoBean;

/**
 * @author Peter Chain
 * @since 2017年2月14日 下午3:27:17
 */
@SuppressWarnings("serial")
public class Parameter implements Serializable {
	public Parameter() {
	}

	public Parameter(String service, String method) {
		this.service = service;
		this.method = method;
	}

	public Parameter(Object result) {
		if (result instanceof Long) {
			this.id = (Long) result;
		} else if (result instanceof BaseModel) {
			this.model = (BaseModel) result;
		} else if (result instanceof Page) {
			this.page = (Page<?>) result;
		} else if (result instanceof Map<?, ?>) {
			this.map = (Map<?, ?>) result;
		} else if (result instanceof List<?>) {
			this.list = (List<?>) result;
		} else if(result instanceof BaseResponse){
			this.baseResponse = (BaseResponse) result;
		}else if(result instanceof ResultObj){
			this.result = (ResultObj) result;
		}
	}

	private String service;
	private String method;

	private Long id;
	private BaseModel model;
	private MongoBean mongoBean;
	private Map<?, ?> map;
	private Page<?> page;
	private List<?> list;
	private ResultObj result;
	
	public MongoBean getMongoBean() {
		return mongoBean;
	}

	public Parameter setMongoBean(MongoBean mongoBean) {
		this.mongoBean = mongoBean;
		return this;
	}

	private BaseResponse baseResponse;
	
    public BaseResponse getBaseResponse() {
		return baseResponse;
	}

	public void setBaseResponse(BaseResponse baseResponse) {
		this.baseResponse = baseResponse;
	}

	public ResultObj getResult() {
		return result;
	}

	public void setResult(ResultObj result) {
		this.result = result;
	}

	private final String no = "[" + IdWorker.getId() + "]";

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getMethod() {
		return method;
	}

	public Parameter setMethod(String method) {
		this.method = method;
		return this;
	}

	public Long getId() {
		return id;
	}

	public Parameter setId(Long id) {
		this.id = id;
		return this;
	}

	public BaseModel getModel() {
		return model;
	}

	public Parameter setModel(BaseModel model) {
		this.model = model;
		return this;
	}

	public Map<?, ?> getMap() {
		return map;
	}

	public Parameter setMap(Map<?, ?> map) {
		this.map = map;
		return this;
	}

	public Page<?> getPage() {
		return page;
	}

	public Parameter setPage(Page<?> page) {
		this.page = page;
		return this;
	}

	public List<?> getList() {
		return list;
	}

	public Parameter setList(List<?> list) {
		this.list = list;
		return this;
	}

    public String getNo() {
        return no;
    }
}
