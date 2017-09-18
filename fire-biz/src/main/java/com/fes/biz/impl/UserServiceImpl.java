package com.fes.biz.impl;

import com.fes.biz.constant.UserType;
import com.fes.biz.request.domain.CustomerRequest;
import com.fes.biz.service.IUserService;
import com.fes.common.domain.SimpleHttpResult;
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

import javax.annotation.Resource;

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
    private ClassMapper classMapper;
    
    @Override
    public SimpleHttpResult showAllCustomer() {
        SimpleHttpResult<List<UserCustomer>> httpResult = new SimpleHttpResult<>();
        List<UserCustomer> result = new ArrayList<>();
        result = userCustomerMapper.getAllCustomerInfo();
        httpResult.setData(result);
        return httpResult;
    }

    @Override
    public SimpleHttpResult showAllStaff() {
        return null;
    }

    @Override
    public SimpleHttpResult showAllOrganization() {
        return null;
    }

    @Override
    public SimpleHttpResult showAllTrainer() {
        return null;
    }

    @Override
    public SimpleHttpResult addCustomer(UserCustomer user) {
    	boolean success = userCustomerMapper.insertCustomer(user);
    	SimpleHttpResult httpResult = new SimpleHttpResult();
    	
    	if(success){
    		httpResult.setSuccess(true);
    	}
    	else{
    		httpResult.setSuccess(false);
    	}
        return httpResult;
    }

    @Override
    public SimpleHttpResult verifyLogin(int userType, String username, String password) {
        SimpleHttpResult httpResult = new SimpleHttpResult();

        if (userType == UserType.CUSTOMER.getUserType()){
            UserCustomer userCustomer = userCustomerMapper.getCustomer(username);
            if (userCustomer == null){
                httpResult.setSuccess(false, "username is incorrect!");
            }
            else if(!password.equals(userCustomer.getPassword())){
                httpResult.setSuccess(false,"password is incorrect!");
            }
            return httpResult;
        }

        if (userType == UserType.ORGANIZATION.getUserType()) {
            UserOrganization userOrganization = userOrganizationMapper.getOrganization(username);
            if (userOrganization == null) {
                httpResult.setSuccess(false, "username is incorrect!");
            }
            else if (!password.equals(userOrganization.getPassword())) {
                httpResult.setSuccess(false, "password is incorrect!");
            }
            return httpResult;
        }

        if (userType == UserType.STAFF.getUserType()) {
            UserTrainer userTrainer = userTrainerMapper.getTrainer(username);
            if (userTrainer == null) {
                httpResult.setSuccess(false, "username is incorrect!");
            }
            else if (!password.equals(userTrainer.getPassword())) {
                httpResult.setSuccess(false, "password is incorrect!");
            }
            return httpResult;
        }

        if (userType == UserType.TRAINER.getUserType()) {
            UserStaff userStaff = userStaffMapper.getStaff(username);
            if (userStaff == null) {
                httpResult.setSuccess(false, "username is incorrect!");
            }
            else if (!password.equals(userStaff.getPassword())) {
                httpResult.setSuccess(false, "password is incorrect!");
            }
            return httpResult;
        }

        httpResult.setSuccess(false,"request param is incorrect!");
        return httpResult;
    }
    
    @Override
    public SimpleHttpResult showOrganizationByID(int organizationID) {
    		UserOrganization result = userOrganizationMapper.showOrganizationByID(organizationID);
    		SimpleHttpResult<UserOrganization> httpResult = new SimpleHttpResult<UserOrganization>();
    		if (result == null) {
    			httpResult.setSuccess(false, "The organization does not exist.");
    		}
    		else {
    			httpResult.setData(result);
    		}
    		return httpResult;
    }
    
    @Override
    public SimpleHttpResult filterClass(int courseID, String classAddr, String classStartTime, int minPrice, int maxPrice ) {
    		SimpleHttpResult<List<ClassPO>> httpResult = new SimpleHttpResult<>();
    		List<ClassPO> result = new ArrayList<>();
    		try {
    			Date classTime = null;
    			if (!"".equals(classStartTime.toString())) {
    				SimpleDateFormat format =  new SimpleDateFormat("yyyy-mm-dd");
    				classTime = new Date(format.parse(classStartTime).getTime());
    			}
    				
    			result = classMapper.filter(courseID, classAddr, classTime, minPrice, maxPrice);
    			
    		} catch(ParseException e) {
    			httpResult.setSuccess(false, "Date is invalid.");
    			return httpResult;
    		}
    		
    		
    		if (result == null) {
    				httpResult.setSuccess(false, "The class does not exist.");
    		}
    		else {
    				httpResult.setData(result);
		}
		return httpResult;
    }

}
