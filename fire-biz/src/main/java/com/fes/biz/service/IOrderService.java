package com.fes.biz.service;

import org.springframework.http.ResponseEntity;

public interface IOrderService {
	
	ResponseEntity deleteOrder(int orderId);
	
	ResponseEntity getOrderById(int orderId);
}
