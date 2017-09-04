package com.fes.biz.impl;

import com.fes.biz.request.domain.CustomerRequest;
import com.fes.biz.service.IUserService;
import com.fes.common.domain.SimpleHttpResult;
import com.fes.dao.domain.UserCustomer;
import com.fes.dao.mappers.UserCustomerMapper;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by qigege on 2017/9/3.
 */
public class UserServiceImpl implements IUserService {

    @Resource
    private UserCustomerMapper userCustomerMapper;

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
}
