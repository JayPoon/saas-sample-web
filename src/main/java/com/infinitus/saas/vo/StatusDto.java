package com.infinitus.saas.vo;

import java.util.HashMap;
import java.util.Map;

/**
 * <dd>创建人： 张敏</dd>
 */
public class StatusDto {

	public static final String SUCCESS_MSG = "success";
	public static final String FAIL_MSG = "failure";

	public static final String RESP_STATUS_CODE_SUCCESS = "1";
	public static final String RESP_STATUS_CODE_FAIL = "0";
	public static final String RESP_STATUS_CODE_ERROR = "2";
	//匿名用户状态码
	public static final String RESP_STATUS_CODE_ANONY = "-1";

	protected boolean isSuccess;

	protected String statusCode;

	protected String message;

	private StatusDto() {
	}

	/**
	 * 响应数据
	 */
	protected Map<String, Object> data;

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}

	public static StatusDto buildSuccessStatus() {
		return buildSuccessStatus(SUCCESS_MSG);
	}

	public static StatusDto buildSuccessStatus(String message) {
		StatusDto dto = new StatusDto();
		dto.statusCode = RESP_STATUS_CODE_SUCCESS;
		dto.message = message;
		dto.isSuccess = true;
		return dto;
	}

	public static StatusDto buildDataSuccessStatus(String message, Map<String, Object> data) {
		StatusDto dto = buildSuccessStatus(message);
		dto.data = data;
		return dto;
	}

	public static StatusDto buildStatus(String code, boolean isSuccess, String message) {
		StatusDto dto = new StatusDto();
		dto.statusCode = code;
		dto.message = message;
		dto.setSuccess(isSuccess);
		return dto;
	}

	public static StatusDto buildDataStatus(String code, boolean isSuccess, String message, Map<String, Object> data) {
		StatusDto dto = buildStatus(code, isSuccess, message);
		dto.setData(data);
		return dto;
	}

	public StatusDto append(String key, Object value) {
		if (value != null) {
			if (data == null) {
				data = new HashMap<String, Object>();
			}
			data.put(key, value);
		}
		return this;
	}

	public static StatusDto buildAnonymousStatus() {
		return buildAnonymousStatus("您尚未登录");
	}

	public static StatusDto buildAnonymousStatus(String message) {
		StatusDto dto = new StatusDto();
		dto.statusCode = RESP_STATUS_CODE_ANONY;
		dto.isSuccess = false;
		dto.message = message;
		return dto;
	}

	public static StatusDto buildFailureStatus() {
		return buildFailureStatus(FAIL_MSG);
	}

	public static StatusDto buildFailureStatus(String message) {
		StatusDto dto = new StatusDto();
		dto.statusCode = RESP_STATUS_CODE_FAIL;
		dto.isSuccess = false;
		dto.message = message;
		return dto;
	}
}