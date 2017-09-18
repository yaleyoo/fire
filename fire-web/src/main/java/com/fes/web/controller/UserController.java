package com.fes.web.controller;

import com.fes.biz.service.IUserService;
import com.fes.common.domain.SimpleHttpResult;
import com.fes.dao.domain.UserCustomer;

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
    
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public SimpleHttpResult register(UserCustomer user){
    	
    	//return userService.addCustomer(user);
    	return new SimpleHttpResult();
    }
    

}
