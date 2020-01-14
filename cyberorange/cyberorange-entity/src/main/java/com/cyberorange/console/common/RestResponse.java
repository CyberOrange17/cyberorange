package com.cyberorange.console.common;

import java.io.Serializable;

import com.cyberorange.console.myenum.ResponseCode;
import com.cyberorange.myenum.ResponseCode;

/**
 * 响应结果封装
 * 
 * @author 黄传举
 */
public class RestResponse<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 响应代码
	 */
	private int status;

	/**
	 * 响应信息
	 */
	private String msg;

	/**
	 * 响应数据
	 */
	private T data;

	public static <T> RestResponse<T> createSuccessResponse() {
		return new RestResponse<>(ResponseCode.succeed.getCode(), ResponseCode.succeed.getName(), null);
	}

	public static <T> RestResponse<T> createErrorResponseWithMsg() {
		return new RestResponse<>(ResponseCode.failed.getCode(), ResponseCode.failed.getName(), null);
	}

	public static <T> RestResponse<T> createSuccessResponse(T data) {
		return new RestResponse<>(ResponseCode.succeed.getCode(), ResponseCode.succeed.getName(), data);
	}

	public static <T> RestResponse<T> createErrorResponse(T data) {
		return new RestResponse<>(ResponseCode.failed.getCode(), ResponseCode.failed.getName(), data);
	}

	public static <T> RestResponse<T> createSuccessResponseWithMsg(T data, String msg) {
		return new RestResponse<>(ResponseCode.succeed.getCode(), msg, data);
	}

	public static <T> RestResponse<T> createErrorResponseWithMsg(T data, String msg) {
		return new RestResponse<>(ResponseCode.failed.getCode(), msg, data);
	}

	public RestResponse(int status, String msg, T data) {
		super();
		this.status = status;
		this.msg = msg;
		this.data = data;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
