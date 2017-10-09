package com.fes.web.controller;

import com.fes.biz.service.IUserService;
import com.fes.common.annotation.Authorization;
import com.fes.common.constants.UserType;
import com.fes.common.domain.SimpleHttpResult;
import com.fes.dao.domain.UserCustomer;
import com.fes.dao.domain.UserOrganization;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.UnsupportedEncodingException;


/**
 * Created by qigege on 2017/9/3.
 */

@RestController
@RequestMapping("/user")
@CrossOrigin()
@Validated
public class UserController {

    @Resource
    private IUserService userService;

    //需要登录权限认证
    @Authorization (authority = UserType.STAFF)
    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public ResponseEntity showAllCustomer(){

            return userService.showAllCustomer();
    }

    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public ResponseEntity individualRegister(UserCustomer user){

            return userService.addIndividualCustomer(user);
    }
    
    @RequestMapping(value = "/token", method = RequestMethod.POST)
    //0-individual 1-organization
    public ResponseEntity verifyLogin(@RequestParam("userType") int userType, @NotNull @RequestParam("username") String username,
                                      @NotEmpty @RequestParam("password") String password) throws UnsupportedEncodingException {

             return userService.verifyLogin(userType, username, password);
    }
    

    
    @RequestMapping(value = "/organization", method = RequestMethod.POST)
    public ResponseEntity orgnizationRegister(@Valid UserOrganization user){

            return userService.addOrganizationCustomer(user);

    }
    @Authorization (authority = UserType.STAFF)
    @RequestMapping(value = "/organization/{id}", method = RequestMethod.GET)
    public ResponseEntity showOrganizationByID(@PathVariable("id") int organizationID) {

        return userService.showOrganizationByID(organizationID);
    }


}
