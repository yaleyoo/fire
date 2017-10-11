package com.fes.biz.impl;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fes.biz.service.IOrderService;
import com.fes.common.domain.SimpleHttpResult;
import com.fes.dao.domain.Order;
import com.fes.dao.mappers.OrderMapper;

public class OrderServiceImpl implements IOrderService{
	@Resource
	private OrderMapper customerOrderMapper;
	
	@Override
	public ResponseEntity deleteOrder(int id) {
		boolean success = customerOrderMapper.deleteOrderById(id);
		SimpleHttpResult httpResult = new SimpleHttpResult();
		if(success){
    			httpResult.setSuccess(true);
            return new ResponseEntity(httpResult, HttpStatus.OK);
    		}

        httpResult.setSuccess(false);
        return new ResponseEntity(httpResult, HttpStatus.NOT_FOUND);

	}
	@Override
	public ResponseEntity getOrderById(int orderId) {
		SimpleHttpResult<Order> httpResult = new SimpleHttpResult<Order>();
		Order customerOrder = customerOrderMapper.selectById(orderId);
		if (customerOrder == null){
            httpResult.setSuccess(false,"not found");
            return new ResponseEntity(httpResult, HttpStatus.NOT_FOUND);
        }
        httpResult.setData(customerOrder);
        return new ResponseEntity(httpResult, HttpStatus.OK);
	}
	
}
