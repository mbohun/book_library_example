package com.mbohun.web.model;

public class SearchRequest {

	String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean empty() {
		if (id == null) {
			return true;
		}

		if (id.trim().isEmpty()) {
			return true;
		}

		return false;
	}
}
