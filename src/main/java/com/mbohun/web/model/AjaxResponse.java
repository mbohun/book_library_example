package com.mbohun.web.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;
import com.mbohun.web.jsonview.Views;

public class AjaxResponse {

	@JsonView(Views.Public.class)
	String msg;

	@JsonView(Views.Public.class)
	String code;

	@JsonView(Views.Public.class)
	List<String> payload;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<String> getPayload() {
		return payload;
	}

	public void setPayload(List<String> payload) {
		this.payload = payload;
	}
}
