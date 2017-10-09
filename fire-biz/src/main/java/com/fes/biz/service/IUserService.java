package com.fes.biz.service;

import com.fes.biz.request.domain.CustomerRequest;
import com.fes.common.domain.SimpleHttpResult;
import com.fes.dao.domain.UserCustomer;
import com.fes.dao.domain.UserOrganization;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;


/**
 * Created by qigege on 2017/9/3.
 */
public interface IUserService {

    ResponseEntity showAllCustomer();

    ResponseEntity showAllStaff();

    ResponseEntity showAllOrganization();

    ResponseEntity showAllTrainer();

    ResponseEntity addIndividualCustomer(UserCustomer customer);

    ResponseEntity addOrganizationCustomer(UserOrganization customer);

    ResponseEntity verifyLogin(int userType, String username, String password) throws UnsupportedEncodingException;

    ResponseEntity showOrganizationByID(int organizationID);


}
