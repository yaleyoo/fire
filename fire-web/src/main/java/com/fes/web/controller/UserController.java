package com.fes.web.controller;

import com.fes.biz.service.IUserService;
import com.fes.common.domain.SimpleHttpResult;
import com.fes.dao.domain.UserCustomer;
import com.fes.dao.domain.UserOrganization;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
 * Created by qigege on 2017/9/3.
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userService;

    @RequestMapping(value = "/showAllCustomer", method = RequestMethod.GET)

    public SimpleHttpResult showAllCustomer(){
        return userService.showAllCustomer();
    }
    
    @RequestMapping(value = "/verifyLogin", method = RequestMethod.POST)
    public SimpleHttpResult varifyLogin(int userType, String username, String password){

    	return userService.verifyLogin(userType, username, password);
    }
    
    @RequestMapping(value = "/individualRegister", method = RequestMethod.POST)
    public SimpleHttpResult individualRegister(UserCustomer user){
    	
    	//return userService.addIndividualCustomer(user);
    	return new SimpleHttpResult();
    }
    
    @RequestMapping(value = "/organizationRegister", method = RequestMethod.POST)
    public SimpleHttpResult orgnizationRegister(UserOrganization user){
    	
    	//return userService.addOrganizationCustomer(user);
    	return new SimpleHttpResult();
    }
    
    @RequestMapping(value = "/showOrganization", method = RequestMethod.GET)
    public SimpleHttpResult showOrganizationByID(int organizationID) {
    		return userService.showOrganizationByID(organizationID);
    }

    
    @RequestMapping(value = "/filterClass", method = RequestMethod.GET)
    public SimpleHttpResult filterClass(int courseID, String classAddr, String classStartTime, int minPrice, int maxPrice ) {
    		return userService.filterClass(courseID, classAddr, classStartTime, minPrice, maxPrice);
    }

    

}
