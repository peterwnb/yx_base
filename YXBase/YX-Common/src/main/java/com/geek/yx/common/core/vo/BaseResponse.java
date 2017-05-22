package com.geek.yx.common.core.vo;

import java.util.Map;

public class BaseResponse extends ResultObj{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5036109241659545533L;
	private Object data;
	
	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public BaseResponse(){
		setResultCode("0");
	}
	
	public BaseResponse(Object data){
		this(ResultCodeEnum.SUCCESS,data);
	}
	
	public BaseResponse(String resultCode, String resultDesc, Object data) {
		setResultCode(resultCode);
		setResultDesc(resultDesc);
		this.data = data;
	}
	
	public BaseResponse(ResultCodeEnum rn, Object data) {
		setResultCode(rn.getCode());
		setResultDesc(rn.getDesc());
		this.data = data;
	}
	
	public BaseResponse(String resultCode, String resultDesc) {
		setResultCode(resultCode);
		setResultDesc(resultDesc);
		setData("");
	}
	
	public BaseResponse(Map<?,?> map) {
		setResultCode((String) map.get("resultCode"));
		setResultDesc((String) map.get("resultDesc"));
	}
	
	public BaseResponse(ResultCodeEnum resultEnum){
		setResultCode(resultEnum.getCode());
		setResultDesc(resultEnum.getDesc());
		setData("");
	}
	
	public BaseResponse(ResultObj obj){
		setResultCode(obj.getResultCode());
		setResultDesc(obj.getResultDesc());
		setData("");
	}
}