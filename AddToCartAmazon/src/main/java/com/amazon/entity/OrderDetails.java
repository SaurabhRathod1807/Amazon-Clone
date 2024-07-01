package com.amazon.entity;

import java.util.List;

public class OrderDetails {
	
	private String userId;
	private List<Product> list;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public List<Product> getList() {
		return list;
	}

	public void setList(List<Product> list) {
		this.list = list;
	}
}
