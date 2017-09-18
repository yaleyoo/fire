package com.fes.biz.service;

import com.fes.biz.request.domain.CustomerRequest;
import com.fes.common.domain.SimpleHttpResult;
import com.fes.dao.domain.UserCustomer;


/**
 * Created by qigege on 2017/9/3.
 */
public interface IUserService {

    SimpleHttpResult showAllCustomer();

    SimpleHttpResult showAllStaff();

    SimpleHttpResult showAllOrganization();

    SimpleHttpResult showAllTrainer();

    SimpleHttpResult addCustomer(UserCustomer customer);

    SimpleHttpResult verifyLogin(int userType, String username, String password);
    
    SimpleHttpResult showOrganizationByID(int organizationID);
    
    SimpleHttpResult filterClass(int courseID, String classAddr, String classStartTime, int minPrice, int maxPrice);
}
