package com.fes.web.controller;

import com.fes.biz.service.IUserService;
import com.fes.common.annotation.Authorization;
import com.fes.common.constants.UserType;
import com.fes.common.domain.SimpleHttpResult;
import com.fes.dao.domain.UserCustomer;
import com.fes.dao.domain.UserOrganization;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by qigege on 2017/9/3.
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userService;

    //需要登录权限认证
    @Authorization (authority = UserType.STAFF)
    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public ResponseEntity showAllCustomer(){
        try {
            return userService.showAllCustomer();
        } catch (Exception e){
            return new ResponseEntity(new SimpleHttpResult(false,
                    "Service Wrong! Please try again later!"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public ResponseEntity individualRegister(UserCustomer user){
        try {
            return userService.addIndividualCustomer(user);
        } catch (Exception e){
            return new ResponseEntity(new SimpleHttpResult(false,
                    "Service Wrong! Please try again later!"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @RequestMapping(value = "/token", method = RequestMethod.POST)
    //0-individual 1-organization
    public ResponseEntity verifyLogin(int userType, String username, String password, HttpServletResponse response){
    	try {
             return userService.verifyLogin(userType, username, password, response);
        } catch (Exception e){
    	    return new ResponseEntity(new SimpleHttpResult(false,
                    "Service Wrong! Please try again later!"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    

    
    @RequestMapping(value = "/organization", method = RequestMethod.POST)
    public ResponseEntity orgnizationRegister(UserOrganization user){
    	try {
            return userService.addOrganizationCustomer(user);
        } catch (Exception e){
            return new ResponseEntity(new SimpleHttpResult(false,
                    "Service Wrong! Please try again later!"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @Authorization (authority = UserType.STAFF)
    @RequestMapping(value = "/organization/{id}", method = RequestMethod.GET)
    public ResponseEntity showOrganizationByID(@PathVariable("id") int organizationID) {
        try {
            return userService.showOrganizationByID(organizationID);
        } catch (Exception e){
            return new ResponseEntity(new SimpleHttpResult(false,
                    "Service Wrong! Please try again later!"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
