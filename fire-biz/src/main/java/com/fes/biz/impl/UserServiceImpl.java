package com.fes.biz.impl;

import com.fes.common.constants.UserType;
import com.fes.biz.service.IUserService;
import com.fes.biz.vo.HttpTokenVO;
import com.fes.common.domain.SimpleHttpResult;
import com.fes.common.util.TokenManager;
import com.fes.dao.domain.ClassPO;
import com.fes.dao.domain.UserCustomer;
import com.fes.dao.domain.UserOrganization;
import com.fes.dao.domain.UserStaff;
import com.fes.dao.domain.UserTrainer;
import com.fes.dao.mappers.ClassMapper;
import com.fes.dao.mappers.UserCustomerMapper;
import com.fes.dao.mappers.UserOrganizationMapper;
import com.fes.dao.mappers.UserStaffMapper;
import com.fes.dao.mappers.UserTrainerMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by qigege on 2017/9/3.
 */
public class UserServiceImpl implements IUserService {

    @Resource
    private UserCustomerMapper userCustomerMapper;

    @Resource
    private UserOrganizationMapper userOrganizationMapper;

    @Resource
    private UserStaffMapper userStaffMapper;

    @Resource
    private UserTrainerMapper userTrainerMapper;

    @Resource
    private TokenManager tokenManager;
    
    @Override
    public ResponseEntity showAllCustomer() {
        SimpleHttpResult<List<UserCustomer>> httpResult = new SimpleHttpResult<>();
        List<UserCustomer> result = userCustomerMapper.getAllCustomerInfo();
        httpResult.setData(result);
        return new ResponseEntity(httpResult, HttpStatus.OK);
    }

    @Override
    public ResponseEntity showAllStaff() {
        return null;
    }

    @Override
    public ResponseEntity showAllOrganization() {
        return null;
    }

    @Override
    public ResponseEntity showAllTrainer() {
        return null;
    }

    @Override
    public ResponseEntity addIndividualCustomer(UserCustomer user) {
    	boolean success = userCustomerMapper.insertCustomer(user);
    	SimpleHttpResult httpResult = new SimpleHttpResult();
    	
    	if(success){
    		httpResult.setSuccess(true);
            return new ResponseEntity(httpResult, HttpStatus.OK);
    	}
        httpResult.setSuccess(false);
        return new ResponseEntity(httpResult, HttpStatus.SERVICE_UNAVAILABLE);

    }
    
    @Override
	public ResponseEntity addOrganizationCustomer(UserOrganization user) {
		// TODO Auto-generated method stub
    	boolean success = userOrganizationMapper.insertCustomer(user);
    	SimpleHttpResult httpResult = new SimpleHttpResult();
    	
    	if(success){
    		httpResult.setSuccess(true);
            return new ResponseEntity(httpResult, HttpStatus.OK);
    	}

        httpResult.setSuccess(false);
        return new ResponseEntity(httpResult, HttpStatus.SERVICE_UNAVAILABLE);

	}


    @Override
    public ResponseEntity verifyLogin(int userType, String username, String password) throws UnsupportedEncodingException {
        SimpleHttpResult<HttpTokenVO> httpResult = new SimpleHttpResult();
        HttpTokenVO result = new HttpTokenVO();
        if (userType == UserType.CUSTOMER.getUserType()){
            UserCustomer userCustomer = userCustomerMapper.getCustomer(username);
            if (userCustomer == null){
                httpResult.setSuccess(false, "username is incorrect!");
                return new ResponseEntity(httpResult, HttpStatus.UNAUTHORIZED);
            }
            else if(!password.equals(userCustomer.getPassword())){
                httpResult.setSuccess(false,"password is incorrect!");
                return new ResponseEntity(httpResult, HttpStatus.UNAUTHORIZED);
            }
            String token = tokenManager.createToken(username, userType);
            result.setToken(token);
            httpResult.setData(result);
            return new ResponseEntity(httpResult, HttpStatus.OK);
        }

        if (userType == UserType.ORGANIZATION.getUserType()) {
            UserOrganization userOrganization = userOrganizationMapper.getOrganization(username);
            if (userOrganization == null) {
                httpResult.setSuccess(false, "username is incorrect!");
                return new ResponseEntity(httpResult, HttpStatus.UNAUTHORIZED);
            }
            else if (!password.equals(userOrganization.getPassword())) {
                httpResult.setSuccess(false, "password is incorrect!");
                return new ResponseEntity(httpResult, HttpStatus.UNAUTHORIZED);
            }
            String token = tokenManager.createToken(username, userType);
            result.setToken(token);
            httpResult.setData(result);
            return new ResponseEntity(httpResult, HttpStatus.OK);
        }

        if (userType == UserType.STAFF.getUserType()) {
            UserTrainer userTrainer = userTrainerMapper.getTrainer(username);
            if (userTrainer == null) {
                httpResult.setSuccess(false, "username is incorrect!");
                return new ResponseEntity(httpResult, HttpStatus.UNAUTHORIZED);
            }
            else if (!password.equals(userTrainer.getPassword())) {
                httpResult.setSuccess(false, "password is incorrect!");
                return new ResponseEntity(httpResult, HttpStatus.UNAUTHORIZED);
            }
            String token = tokenManager.createToken(username, userType);
            result.setToken(token);
            httpResult.setData(result);
            return new ResponseEntity(httpResult, HttpStatus.OK);
        }

        if (userType == UserType.TRAINER.getUserType()) {
            UserStaff userStaff = userStaffMapper.getStaff(username);
            if (userStaff == null) {
                httpResult.setSuccess(false, "username is incorrect!");
                return new ResponseEntity(httpResult, HttpStatus.UNAUTHORIZED);
            }
            else if (!password.equals(userStaff.getPassword())) {
                httpResult.setSuccess(false, "password is incorrect!");
                return new ResponseEntity(httpResult, HttpStatus.UNAUTHORIZED);
            }
            String token = tokenManager.createToken(username, userType);
            result.setToken(token);
            httpResult.setData(result);
            return new ResponseEntity(httpResult, HttpStatus.OK);
        }

        httpResult.setSuccess(false,"request param is incorrect!");
        return new ResponseEntity(httpResult, HttpStatus.BAD_REQUEST);
    }
    
    @Override
    public ResponseEntity showOrganizationByID(int organizationID) {
    		UserOrganization result = userOrganizationMapper.showOrganizationByID(organizationID);
    		SimpleHttpResult<UserOrganization> httpResult = new SimpleHttpResult<UserOrganization>();
    		if (result == null) {
    			httpResult.setSuccess(false, "The organization does not exist.");
                return new ResponseEntity(httpResult, HttpStatus.NOT_FOUND);
    		}

            httpResult.setData(result);

    		return new ResponseEntity(httpResult, HttpStatus.OK);
    }
    


	
}
