package com.fes.biz.service;

import com.fes.dao.domain.Order;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface IOrderService {
	
	ResponseEntity deleteOrder(int orderId);
	
	ResponseEntity getOrderById(int orderId);

	ResponseEntity createOrder(int classId, int peopleNum, String username, int usertype);

	void finishPayment(String paymentId, String PayerID, HttpServletResponse response) throws PayPalRESTException, IOException;

	ResponseEntity startPayment(String orderNum, String username, int userType) throws PayPalRESTException;
}
