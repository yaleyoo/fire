package com.fes.web.controller;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fes.biz.service.IOrderService;

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
	
	@RequestMapping(value = "/deleteOrder", method = RequestMethod.DELETE)
	public ResponseEntity deleteOrder(int id) {
		return orderService.deleteOrder(id);
	}
	
	@RequestMapping(value = "/searchOrder/{id}", method = RequestMethod.GET)
	public ResponseEntity getOrderById(@PathVariable("id") int id) {
		return orderService.getOrderById(id);
	}
	
}
