package com.mbohun.web.model;

public class SearchRequest {

	String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "SearchRequest [id=" + id + "]";
	}
}
