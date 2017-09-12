package com.fes.biz.service;

import com.fes.biz.request.domain.CustomerRequest;
import com.fes.common.domain.SimpleHttpResult;


/**
 * Created by qigege on 2017/9/3.
 */
public interface IUserService {

    SimpleHttpResult showAllCustomer();

    SimpleHttpResult showAllStaff();

    SimpleHttpResult showAllOrganization();

    SimpleHttpResult showAllTrainer();

    SimpleHttpResult addCustomer(CustomerRequest request);

    SimpleHttpResult verifyLogin(int userType, String username, String password);
}
