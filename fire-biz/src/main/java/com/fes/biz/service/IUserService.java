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

    ResponseEntity showCustomer(int userId);

    ResponseEntity showAllStaff();

    ResponseEntity showAllOrganization();

    ResponseEntity showAllTrainer();

    ResponseEntity addIndividualCustomer(UserCustomer customer);

    ResponseEntity addOrganizationCustomer(UserOrganization customer);

    ResponseEntity verifyLogin(int userType, String username, String password) throws UnsupportedEncodingException;

    ResponseEntity showOrganizationByID(int organizationID);

    ResponseEntity getAllOrgInfo();

    ResponseEntity deleteUserOrganization(int organizationId);

    ResponseEntity modifyUserOrganization(UserOrganization userOrganization);

    ResponseEntity logout(String username, int usertype);

    ResponseEntity modifyProfile(UserCustomer userCustomer);

    ResponseEntity getVerifyCode(String username, int usertype) throws Exception;

    ResponseEntity findExistCustomer(String username);

    ResponseEntity showTrainerById(int id);

    ResponseEntity deleteCustomer(int id);

    ResponseEntity uploadTrainerPicture(String url, int id);

    ResponseEntity getLoginInfo(String username, int usertype, int userId);

    ResponseEntity showMembersInfo(int id);

    ResponseEntity showOrderListByUser(String username, int userType);

    ResponseEntity showClassTimeTable(int id) throws ParseException;

    ResponseEntity updateTrainerInfo(int id, String username, String password, String firstname
            , String lastname, String sex, String address,String phoneNum
            ,String desc);

    ResponseEntity updateTrainerAvailability(int id, String availability);
}
