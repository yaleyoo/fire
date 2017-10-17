package com.fes.biz.impl;

import com.fes.biz.vo.ClassTimeVO;
import com.fes.biz.vo.LoginInfoVO;
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
import com.fes.dao.domain.*;
import com.fes.dao.mappers.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.sql.Date;
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
    private OrderMapper orderMapper;

    @Resource
    private ClassItemMapper classItemMapper;

    @Resource
    private ClassMapper classMapper;

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
            String password = MD5Util.MD5(user.getPassword());
            user.setPassword(password);
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
            String token = tokenManager.createToken(username, userType, userCustomer.getId());
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
            String token = tokenManager.createToken(username, userType, userOrganization.getId());
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
            String token = tokenManager.createToken(username, userType, userTrainer.getId());
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
            String token = tokenManager.createToken(username, userType, userStaff.getId());
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
    public ResponseEntity getAllOrgInfo() {
    		SimpleHttpResult<List<UserOrganization>> httpResult = new SimpleHttpResult<List<UserOrganization>>();
    		List<UserOrganization> list = userOrganizationMapper.getAllOrgInfo();
    		if(list == null) {
    			httpResult.setSuccess(false, "no results");
    			return new ResponseEntity(httpResult, HttpStatus.NOT_FOUND);
    		}
    		httpResult.setSuccess(true);
    		httpResult.setData(list);
    		return new ResponseEntity(httpResult, HttpStatus.OK);
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
    public ResponseEntity deleteUserOrganization(int organizationId) {
    		SimpleHttpResult httpResult = new SimpleHttpResult();
    		boolean success = userOrganizationMapper.deleteCustomer(organizationId);
    		if(success) {
    			httpResult.setSuccess(true);
    			return new ResponseEntity(httpResult, HttpStatus.OK);
    		}
    		httpResult.setSuccess(false, "delete failed");
    		return new ResponseEntity(httpResult, HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity modifyUserOrganization(UserOrganization userOrganization) {
    		SimpleHttpResult httpResult = new SimpleHttpResult();
    		boolean success = userOrganizationMapper.modifyOrganization(userOrganization);
    		if(success) {
    			httpResult.setSuccess(true);
    			return new ResponseEntity(httpResult, HttpStatus.OK);
    		}
    		httpResult.setSuccess(false, "modify failed");
    		return new ResponseEntity(httpResult, HttpStatus.NOT_FOUND);
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
    public ResponseEntity showTrainerById(int id) {
        UserTrainer trainer = userTrainerMapper.getTrainerById(id);
        SimpleHttpResult httpResult = new SimpleHttpResult();
        if(trainer!=null){
            httpResult.setSuccess(true);
            httpResult.setData(trainer);
            return new ResponseEntity(httpResult, HttpStatus.OK);
        }
        else{
            httpResult.setSuccess(false);
            return new ResponseEntity(httpResult, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity uploadTrainerPicture(String url, int id) {
        SimpleHttpResult httpResult = new SimpleHttpResult();
        if (userTrainerMapper.updatePicUrl(url, id)){
        		httpResult.setSuccess(true);
            return new ResponseEntity(httpResult, HttpStatus.OK);
        }
        httpResult.setSuccess(false, "upload failed");
        return new ResponseEntity(httpResult, HttpStatus.SERVICE_UNAVAILABLE);
    }

    @Override
    public ResponseEntity deleteCustomer(int id) {
    		SimpleHttpResult httpResult = new SimpleHttpResult();
    		if (userCustomerMapper.deleteCustomer(id)) {
    			 httpResult.setSuccess(true);
    			 return new ResponseEntity(httpResult, HttpStatus.OK);
    		}
    		httpResult.setSuccess(false, "delete failed");
    		return new ResponseEntity(httpResult, HttpStatus.SERVICE_UNAVAILABLE);
    }

    @Override
    public ResponseEntity getLoginInfo(String username, int usertype, int userId) {
        SimpleHttpResult<LoginInfoVO> httpResult = new SimpleHttpResult<>();
        LoginInfoVO loginInfoVO = new LoginInfoVO();
        loginInfoVO.setUsername(username);
        loginInfoVO.setUsertype(usertype);
        loginInfoVO.setUserId(userId);
        httpResult.setData(loginInfoVO);
        return new ResponseEntity(httpResult, HttpStatus.OK);
    }

    @Override
    public ResponseEntity showMembersInfo(int id) {
        SimpleHttpResult<List<UserCustomer>> httpResult = new SimpleHttpResult<>();
        String userIds = userOrganizationMapper.selectMembers(id);
        if (userIds == null){
            httpResult.setSuccess(false, "no members!");
            return new ResponseEntity(httpResult, HttpStatus.NOT_FOUND);
        }
        List<String> idList = Arrays.asList(userIds.split(","));
        if (idList.isEmpty()){
            httpResult.setSuccess(false, "no members!");
            return new ResponseEntity(httpResult, HttpStatus.NOT_FOUND);
        }
        List<UserCustomer> userCustomerList = userCustomerMapper.selectByIds(idList);
        httpResult.setData(userCustomerList);
        return new ResponseEntity(httpResult, HttpStatus.OK);
    }

    @Override
    public ResponseEntity showOrderListByUser(String username, int userType) {
        SimpleHttpResult<List<Order>> httpResult = new SimpleHttpResult<>();
        List<Order> orderList = orderMapper.selectByUserNameAndUserType(username, userType);
        if (orderList == null || orderList.isEmpty()){
            httpResult.setSuccess(false, "no order!");
            return new ResponseEntity(httpResult, HttpStatus.NOT_FOUND);
        }
        httpResult.setData(orderList);
        return new ResponseEntity(httpResult, HttpStatus.OK);
    }

    @Override
    public ResponseEntity showClassTimeTable(int id) throws ParseException {
        SimpleHttpResult<ClassTimeVO> httpResult = new SimpleHttpResult<>();
        ClassTimeVO classTimeVO = new ClassTimeVO();
        List<Map<String, String>> result = new ArrayList<>();
        classTimeVO.setResult(result);
        httpResult.setData(classTimeVO);
        UserCustomer userCustomer = userCustomerMapper.selectById(id);
        String classIdList = userCustomer.getClassIdList();
        if (classIdList == null){

            return new ResponseEntity(httpResult, HttpStatus.NOT_FOUND);
        }
        List<String> classIds = Arrays.asList(classIdList.split(","));
        List<ClassItemPO> classItemList = classItemMapper.getClassItemByClassIds(classIds);
        List<ClassPO> classPOList = classMapper.getClassByIds(classIds);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        for(ClassItemPO item : classItemList){
            String startTime = sdf.format(item.getClassDate())+" "+item.getStartTime();
            String endTime = sdf.format(item.getClassDate())+" "+item.getEndTime();
            Map<String, String> map = new HashMap<>();
            if (System.currentTimeMillis() > item.getClassDate().getTime()){
                map.put("class", "event-success");
            } else {
                map.put("class", "event-info");
            }
            java.util.Date start = simpleDateFormat.parse(startTime);
            java.util.Date end = simpleDateFormat.parse(endTime);
            map.put("start", String.valueOf(start.getTime()));
            map.put("end", String.valueOf(end.getTime()));
            for (ClassPO classPO : classPOList){
                if (classPO.getId() == item.getClassId()){
                    map.put("title", "Course Name: "+classPO.getCourseName()+"<br>Address: "+classPO.getClassAddr());
                    break;
                }
            }
            map.put("id", String.valueOf(item.getId()));
            result.add(map);
        }
        return new ResponseEntity(httpResult, HttpStatus.OK);
    }
    @Override
    public ResponseEntity updateTrainerInfo(int id, String username, String password, String firstname, String lastname,
                                            String sex, String address, String phoneNum, String desc) {
        SimpleHttpResult<List<UserCustomer>> httpResult = new SimpleHttpResult<>();
        int gender;
        if(sex.equals("male")){
            gender=1;
        }
        else
            gender=0;
        if(userTrainerMapper.updateProfile(id,username,password,firstname,lastname,gender,address,phoneNum,desc)){
            httpResult.setSuccess(true);
            return new ResponseEntity(httpResult, HttpStatus.OK);
        }
        else {
            httpResult.setSuccess(false);
            return new ResponseEntity(httpResult, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity updateTrainerAvailability(int id, String availability){
        SimpleHttpResult<List<UserCustomer>> httpResult = new SimpleHttpResult<>();
        if(userTrainerMapper.updateAvailability(id, availability)){
            httpResult.setSuccess(true);
            return new ResponseEntity(httpResult, HttpStatus.OK);
        }
        else{
            httpResult.setSuccess(false);
            return new ResponseEntity(httpResult, HttpStatus.NOT_FOUND);
        }
    }


}
