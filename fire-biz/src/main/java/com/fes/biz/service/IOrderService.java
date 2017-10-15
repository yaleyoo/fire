package com.fes.biz.service;

import com.fes.dao.domain.Order;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.http.ResponseEntity;

public interface IOrderService {
	
	ResponseEntity deleteOrder(int orderId);
	
	ResponseEntity getOrderById(int orderId);

	ResponseEntity createOrder(int classId, int peopleNum, String username, int usertype);

	ResponseEntity finishPayment(String paymentId, String PayerID) throws PayPalRESTException;

	String startPayment(int orderId) throws PayPalRESTException;
}
