package com.fes.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fes.common.annotation.Authorization;
import com.fes.common.constants.UserType;
import com.fes.common.domain.SimpleHttpResult;
import com.fes.common.service.PaypalService;
import com.fes.dao.domain.Order;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.fes.biz.service.IOrderService;

import java.io.IOException;

/**
 * Created by qigege on 2017/10/2.
 */

@Controller
@RequestMapping("/order")
@CrossOrigin(origins = "*")
@Validated
public class OrderController {
	@Resource
	private IOrderService orderService;

	@ResponseBody
	@Authorization
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity deleteOrder(@PathVariable("id") int id) {
		return orderService.deleteOrder(id);
	}

	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity getOrderById(@PathVariable("id") int id) {
		return orderService.getOrderById(id);
	}

	@Authorization(authority = {UserType.CUSTOMER, UserType.ORGANIZATION})
	@ResponseBody
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity createOrder(int classId, @RequestParam(value="peopleNum",defaultValue="1",required = false) int peopleNum, HttpServletRequest request) {
		String username = (String) request.getAttribute("username");
		int usertype = (Integer) request.getAttribute("usertype");
		return orderService.createOrder(classId, peopleNum, username, usertype);
	}

	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity modifyOrder(Order order) {
		//TODO
		return new ResponseEntity(new SimpleHttpResult(), HttpStatus.OK);
	}

	@Authorization(authority = {UserType.CUSTOMER, UserType.ORGANIZATION})
	@ResponseBody
	@RequestMapping(value = "/{id}/payment", method = RequestMethod.POST)
	public ResponseEntity payOrder(String orderNum, HttpServletRequest request) throws PayPalRESTException, IOException {
		String username = (String) request.getAttribute("username");
		int userType = (Integer) request.getAttribute("usertype");
		return orderService.startPayment(orderNum, username, userType);
	}

	@RequestMapping(value = "/payment-process", method = RequestMethod.GET)
	public void payOrder(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String PayerID, HttpServletResponse response) throws PayPalRESTException, IOException {
		 orderService.finishPayment(paymentId, PayerID, response);
	}
	
}
