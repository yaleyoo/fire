package com.fes.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fes.common.domain.SimpleHttpResult;
import com.fes.common.service.PaypalService;
import com.fes.dao.domain.Order;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.fes.biz.service.IOrderService;

import java.io.IOException;

/**
 * Created by qigege on 2017/10/2.
 */

@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "*")
@Validated
public class OrderController {
	@Resource
	private IOrderService orderService;


	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity deleteOrder(@PathVariable("id") int id) {
		return orderService.deleteOrder(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity getOrderById(@PathVariable("id") int id) {
		return orderService.getOrderById(id);
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity createOrder(int classId, @RequestParam(value="peopleNum",defaultValue="1",required = false) int peopleNum, HttpServletRequest request) {
		String username = (String) request.getAttribute("username");
		int usertype = (Integer) request.getAttribute("usertype");
		return orderService.createOrder(classId, peopleNum, username, usertype);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity modifyOrder(Order order) {
		//TODO
		return new ResponseEntity(new SimpleHttpResult(), HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}/payment", method = RequestMethod.POST)
	public void payOrder(@PathVariable("id") int orderId, HttpServletResponse response) throws PayPalRESTException, IOException {
		String returnUrl = orderService.startPayment(orderId);
		response.sendRedirect(returnUrl);
	}

	@RequestMapping(value = "/payment-process", method = RequestMethod.GET)
	public ResponseEntity payOrder(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String PayerID) throws PayPalRESTException {
		return orderService.finishPayment(paymentId, PayerID);
	}
	
}
