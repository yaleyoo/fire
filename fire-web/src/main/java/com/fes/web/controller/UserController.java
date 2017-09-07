package com.fes.web.controller;

import com.fes.biz.service.IUserService;
import com.fes.common.domain.SimpleHttpResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by qigege on 2017/9/3.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userService;

    @RequestMapping(value = "/showAllCustomer", method = RequestMethod.GET)
    @ResponseBody
    public SimpleHttpResult showAllCustomer(){
        return userService.showAllCustomer();
    }
    
    @RequestMapping(value = "/verifyLogin", method = RequestMethod.POST)
    @ResponseBody
    public SimpleHttpResult varifyLogin(String username, String password){
    	//stub
    	return new SimpleHttpResult();
    }

}
