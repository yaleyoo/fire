package com.fes.biz.impl;

import com.fes.biz.constant.UserType;
import com.fes.biz.request.domain.CustomerRequest;
import com.fes.biz.service.IUserService;
import com.fes.common.domain.SimpleHttpResult;
import com.fes.dao.domain.UserCustomer;
import com.fes.dao.domain.UserOrganization;
import com.fes.dao.domain.UserStaff;
import com.fes.dao.domain.UserTrainer;
import com.fes.dao.mappers.UserCustomerMapper;
import com.fes.dao.mappers.UserOrganizationMapper;
import com.fes.dao.mappers.UserStaffMapper;
import com.fes.dao.mappers.UserTrainerMapper;

import javax.annotation.Resource;
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
    public SimpleHttpResult addCustomer(CustomerRequest request) {
        return null;
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
}
