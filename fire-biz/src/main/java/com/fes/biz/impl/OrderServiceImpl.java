package com.fes.biz.impl;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import com.fes.biz.service.IUserService;
import com.fes.common.constants.UserType;
import com.fes.common.service.PaypalService;
import com.fes.dao.domain.ClassPO;
import com.fes.dao.domain.Course;
import com.fes.dao.domain.UserOrganization;
import com.fes.dao.mappers.*;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.PaymentExecution;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fes.biz.service.IOrderService;
import com.fes.common.domain.SimpleHttpResult;
import com.fes.dao.domain.Order;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class OrderServiceImpl implements IOrderService{

	@Resource
	private OrderMapper customerOrderMapper;

	@Resource
	private ClassMapper classMapper;

	@Resource
	private CourseMapper courseMapper;

	@Resource
	private PaypalService paypalService;

	@Resource
	private UserOrganizationMapper userOrganizationMapper;

	@Resource
	private APIContext apiContext;
	
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


	@Override
	public ResponseEntity createOrder(int classId, int peopleNUm, String username, int usertype) {
		SimpleHttpResult<Map<String, String>> httpResult = new SimpleHttpResult();
		Order order = new Order();
		ClassPO classPO = classMapper.getClassById(classId);
		if (classPO == null){
			httpResult.setSuccess(false, "no such class");
			return new ResponseEntity(httpResult, HttpStatus.NOT_FOUND);
		}
		String orderNum = UUID.randomUUID().toString().replace("-","");
		Course course = courseMapper.selectCourseById(classPO.getCourseId());
		order.setClassId(classId);
		order.setCourseId(classPO.getCourseId());
		order.setCourseName(course.getCourseName());
		order.setOrderNum(orderNum);
		order.setPaymentStatus(0);
		order.setPeopleNum(peopleNUm);
		order.setPrice(classPO.getPrice()*peopleNUm);
		order.setTutorId(classPO.getTutorId());
		order.setTutorName(classPO.getTutorName());
		order.setUsername(username);
		order.setUsertype(usertype);
		if (customerOrderMapper.insert(order)){
			Map<String, String> result = new HashMap<>();
			result.put("orderNum", orderNum);
			httpResult.setData(result);
			return new ResponseEntity(httpResult, HttpStatus.CREATED);
		}
		httpResult.setSuccess(false, "Service unavailable!");
		return new ResponseEntity(httpResult, HttpStatus.SERVICE_UNAVAILABLE);
	}

	@Override
	public void finishPayment(String paymentId, String PayerID, HttpServletResponse response) throws PayPalRESTException, IOException {
		SimpleHttpResult httpResult = new SimpleHttpResult();
		Payment payment = new Payment();
		payment.setId(paymentId);

		PaymentExecution paymentExecution = new PaymentExecution();
		paymentExecution.setPayerId(PayerID);
		Payment createdPayment = payment.execute(apiContext, paymentExecution);
		List<Transaction> transactions = createdPayment.getTransactions();
		String orderNum = transactions.get(0).getInvoiceNumber();
		System.out.println(createdPayment);
		if (!customerOrderMapper.updatePaymentStatus(orderNum)){
			response.sendRedirect("http://localhost:8080/jsp/pay-error.html");
		}else{
			response.sendRedirect("http://localhost:8080/jsp/pay-success.html");
		}
	}

	@Override
	public ResponseEntity startPayment(String orderNum, String username, int userType) throws PayPalRESTException {
		SimpleHttpResult<Map<String, String>> httpResult = new SimpleHttpResult();
		Order order = customerOrderMapper.selectByOrderNum(orderNum);
		Map<String, String> result = new HashMap<>();
		httpResult.setData(result);
		if (order == null){
			return new ResponseEntity(httpResult, HttpStatus.NOT_FOUND);
		}
		if (!username.equals(order.getUsername()) || order.getUsertype() != userType){
			return new ResponseEntity(httpResult, HttpStatus.NOT_FOUND);
		}
		String returnUrl = paypalService.getPayUrl(order.getPrice(), orderNum);
		if (returnUrl == null){
			returnUrl = "http://localhost:8080/jsp/pay-error.html";
		}
		result.put("url", returnUrl);
		return new ResponseEntity(httpResult, HttpStatus.OK);
	}
}
