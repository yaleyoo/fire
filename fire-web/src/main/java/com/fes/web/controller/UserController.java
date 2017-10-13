package com.fes.web.controller;

import com.fes.biz.service.IUserService;
import com.fes.common.annotation.Authorization;
import com.fes.common.constants.UserType;
import com.fes.common.domain.SimpleHttpResult;
import com.fes.dao.domain.UserCustomer;
import com.fes.dao.domain.UserOrganization;

import com.fes.dao.domain.UserStaff;
import com.fes.dao.domain.UserTrainer;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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

    //需要登录权限认证
     @Authorization (authority = UserType.CUSTOMER)
    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
    public ResponseEntity showCustomer(@PathVariable("id") int userId){

        return userService.showCustomer(userId);
    }

    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public ResponseEntity individualRegister(UserCustomer user){

            return userService.addIndividualCustomer(user);
    }

    @Authorization(authority = UserType.CUSTOMER)
    @RequestMapping(value = "/customer", method = RequestMethod.PUT)
    public ResponseEntity modifyProfile(@Valid UserCustomer userCustomer) {
        return userService.modifyProfile(userCustomer);
    }

    @Authorization(authority = UserType.STAFF)
    @RequestMapping(value = "/customer/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteCustomer( @PathVariable("id") int id) {
        // TODO
        //return userService.modifyProfile(userCustomer);
        return new ResponseEntity(new SimpleHttpResult<>(), HttpStatus.OK);
    }

    @RequestMapping(value = "/customer/email/{email}", method = RequestMethod.GET)
    public ResponseEntity hasCustomer(@PathVariable("email") String email){

        return userService.findExistCustomer(email);
    }

    @RequestMapping(value = "/verifycode", method = RequestMethod.POST)
    public ResponseEntity getVerifyCode(String username, int usertype) throws Exception {

        return userService.getVerifyCode(username, usertype);
    }
    
    @RequestMapping(value = "/token", method = RequestMethod.POST)
    //0-individual 1-organization
    public ResponseEntity verifyLogin(@RequestParam("userType") int userType, @NotNull @RequestParam("username") String username,
                                      @NotEmpty @RequestParam("password") String password) throws UnsupportedEncodingException {

             return userService.verifyLogin(userType, username, password);
    }

    @Authorization
    @RequestMapping(value = "/token", method = RequestMethod.DELETE)
    //0-individual 1-organization
    public ResponseEntity logout(HttpServletRequest request){
        String username = (String) request.getAttribute("username");
        int usertype = (Integer) request.getAttribute("usertype");

        return userService.logout(username, usertype);
    }

    
    @RequestMapping(value = "/loginInfo", method = RequestMethod.GET)
    public ResponseEntity getLoginInformation(){
        return new ResponseEntity(new SimpleHttpResult(), HttpStatus.OK);
    }
    
    @RequestMapping(value = "/organization", method = RequestMethod.POST)
    public ResponseEntity orgnizationRegister(@Valid UserOrganization user){

        //TODO
        return new ResponseEntity(new SimpleHttpResult<>(), HttpStatus.OK);

    }


    @RequestMapping(value = "/organization", method = RequestMethod.PUT)
    public ResponseEntity modifyOrgnization(@Valid UserOrganization user){
        //TODO
        return new ResponseEntity(new SimpleHttpResult<>(), HttpStatus.OK);

    }

    @RequestMapping(value = "/organization/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteOrgnization(int id){
        //TODO
        return new ResponseEntity(new SimpleHttpResult<>(), HttpStatus.OK);

    }

    @Authorization (authority = {UserType.STAFF, UserType.TRAINER})
    @RequestMapping(value = "/trainer/{id}", method = RequestMethod.GET)
    public ResponseEntity showTrainerByID(@PathVariable("id") int id) {

        return new ResponseEntity(new SimpleHttpResult<>(), HttpStatus.OK);
    }

    @Authorization(authority = UserType.STAFF)
    @RequestMapping(value = "/trainer", method = RequestMethod.POST)
    public ResponseEntity createTrainer(String username){

        //TODO
        return new ResponseEntity(new SimpleHttpResult<>(), HttpStatus.OK);

    }

    @RequestMapping(value = "/trainer/{id}/picture", method = RequestMethod.POST)
    public ResponseEntity uploadTrainerPicture(@PathVariable("id") int id, String pictureUrl){
        return userService.uploadTrainerPicture(pictureUrl, id);
    }

    @Authorization(authority = UserType.TRAINER)
    @RequestMapping(value = "/trainer", method = RequestMethod.PUT)
    public ResponseEntity modifyTrainerProfile(@Valid UserTrainer user){
        //TODO
        return new ResponseEntity(new SimpleHttpResult<>(), HttpStatus.OK);

    }

    @RequestMapping(value = "/trainer/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteTrainer(int id){
        //TODO
        return new ResponseEntity(new SimpleHttpResult<>(), HttpStatus.OK);

    }



    @Authorization(authority = UserType.STAFF)
    @RequestMapping(value = "/staff", method = RequestMethod.POST)
    public ResponseEntity createStaff(String username){

        //TODO
        return new ResponseEntity(new SimpleHttpResult<>(), HttpStatus.OK);

    }


    @RequestMapping(value = "/staff/{id}", method = RequestMethod.PUT)
    public ResponseEntity modifyStaffProfile(@PathVariable("id") int id, @Valid UserStaff user){
        //TODO
        return new ResponseEntity(new SimpleHttpResult<>(), HttpStatus.OK);

    }

    @RequestMapping(value = "/staff/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteStaff(@PathVariable("id") int id){
        //TODO
        return new ResponseEntity(new SimpleHttpResult<>(), HttpStatus.OK);

    }


    @RequestMapping(value = "/staff/{id}", method = RequestMethod.GET)
    public ResponseEntity showStaffByID(@PathVariable("id") int id) {

        //todo
        return new ResponseEntity(new SimpleHttpResult<>(), HttpStatus.OK);
    }



}
