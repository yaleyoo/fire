package com.fes.dao.domain;

import java.sql.Date;
import java.sql.Time;

public class CustomerOrder {
	private int id;
	private int userId;
	private String classIdList;
	private Date orderDate;
	private Time orderTime;
	private int orderAmount;
	
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int userId() {
		return this.userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getClassIdList() {
		return this.classIdList;
	}
	public void setClassIdList(String classIdList) {
		this.classIdList = classIdList;
	}
	public Date getDate() {
		return this.orderDate;
	}
	public void setDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Time getTime() {
		return this.orderTime;
	}
	public void setTime(Time orderTime) {
		this.orderTime = orderTime;
	}
	public int getOrderAmount( ) {
		return this.orderAmount;
	}
	public void setOrderAmount(int orderAmount) {
		this.orderAmount = orderAmount;
	}
}
