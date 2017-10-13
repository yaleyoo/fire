package com.fes.biz.impl;

import com.fes.biz.vo.VerifyCodeVO;
import com.fes.common.constants.MailConstants;
import com.fes.common.constants.UserType;
import com.fes.biz.service.IUserService;
import com.fes.biz.vo.HttpTokenVO;
import com.fes.common.domain.SimpleHttpResult;
import com.fes.common.service.MailSendService;
import com.fes.common.util.MD5Util;
import com.fes.common.util.MailCodeManager;
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

    @Resource
    private MailSendService mailSendService;

    @Resource
    private MailCodeManager mailCodeManager;
    
    @Override
    public ResponseEntity showAllCustomer() {
        SimpleHttpResult<List<UserCustomer>> httpResult = new SimpleHttpResult<>();
        List<UserCustomer> result = userCustomerMapper.getAllCustomerInfo();
        httpResult.setData(result);
        return new ResponseEntity(httpResult, HttpStatus.OK);
    }

    @Override
    public ResponseEntity showCustomer(int userId) {
        SimpleHttpResult<UserCustomer> httpResult = new SimpleHttpResult();
        UserCustomer userCustomer = userCustomerMapper.selectById(userId);
        if (userCustomer == null){
            httpResult.setSuccess(false,"service unavailable");
            return new ResponseEntity(httpResult, HttpStatus.SERVICE_UNAVAILABLE);
        }
        httpResult.setData(userCustomer);
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
        SimpleHttpResult httpResult = new SimpleHttpResult();

        if (mailCodeManager.verifyCode(user.getUserMailCode(),user.getUsername(),UserType.CUSTOMER.userType)){
            String password = user.getPassword();
            String passMD5 = MD5Util.MD5(password);
            user.setPassword(passMD5);
            boolean success = userCustomerMapper.insertCustomer(user);
            if(success){
            	httpResult.setSuccess(true);
                return new ResponseEntity(httpResult, HttpStatus.CREATED);
            }
            httpResult.setSuccess(false);
            return new ResponseEntity(httpResult, HttpStatus.SERVICE_UNAVAILABLE);
        }
        httpResult.setSuccess(false, "verify code is wrong!");
        return new ResponseEntity(httpResult, HttpStatus.BAD_REQUEST);

    }

    @Override
    public ResponseEntity getVerifyCode(String username, int usertype) throws Exception {
        SimpleHttpResult<VerifyCodeVO> httpResult = new SimpleHttpResult<>();
        VerifyCodeVO verifyCodeVO = new VerifyCodeVO();
        String code = mailCodeManager.createVerifyToken(username, usertype);
        verifyCodeVO.setCode(code);
        httpResult.setData(verifyCodeVO);
        mailSendService.sendMail(username, MailConstants.SUBJECT,MailConstants.generateMailContent(code));
        return new ResponseEntity(httpResult, HttpStatus.OK);
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
    public ResponseEntity findExistCustomer(String username) {
        SimpleHttpResult httpResult = new SimpleHttpResult();
        UserCustomer userCustomer = userCustomerMapper.selectByName(username);
        if (userCustomer == null){
            httpResult.setSuccess(false);
            return new ResponseEntity(httpResult, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(httpResult, HttpStatus.OK);
    }

    @Override
    public ResponseEntity verifyLogin(int userType, String username, String password) throws UnsupportedEncodingException {
        SimpleHttpResult<HttpTokenVO> httpResult = new SimpleHttpResult();
        HttpTokenVO result = new HttpTokenVO();
        if (userType == UserType.CUSTOMER.getUserType()){
            UserCustomer userCustomer = userCustomerMapper.selectByName(username);
            password = MD5Util.MD5(password);
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
            result.setUserType(UserType.CUSTOMER.strUserType);
            result.setUserId(userCustomer.getId());
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
            result.setUserType(UserType.ORGANIZATION.strUserType);
            result.setUserId(userOrganization.getId());
            httpResult.setData(result);
            return new ResponseEntity(httpResult, HttpStatus.OK);
        }

        if (userType == UserType.TRAINER.getUserType()) {
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
            result.setUserType(UserType.TRAINER.strUserType);
            result.setUserId(userTrainer.getId());
            httpResult.setData(result);
            return new ResponseEntity(httpResult, HttpStatus.OK);
        }

        if (userType == UserType.STAFF.getUserType()) {
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
            result.setUserType(UserType.STAFF.strUserType);
            result.setUserId(userStaff.getId());
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
    
    @Override
    public ResponseEntity modifyProfile(UserCustomer userCustomer) {
    		SimpleHttpResult httpResult = new SimpleHttpResult();
    		boolean success = userCustomerMapper.update(userCustomer);
    		if(success) {
    			httpResult.setSuccess(true);
    			return new ResponseEntity(httpResult, HttpStatus.OK);
    		}
    		else {
    			httpResult.setSuccess(false);
    			return new ResponseEntity(httpResult, HttpStatus.NOT_FOUND);
    		}

    }

    @Override
    public ResponseEntity logout(String username, int usertype) {
        tokenManager.deleteToken(username, usertype);
        return new ResponseEntity(new SimpleHttpResult(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity uploadTrainerPicture(String url) {
        return null;
    }
}
