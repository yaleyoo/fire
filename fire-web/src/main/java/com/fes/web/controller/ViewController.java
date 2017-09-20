package com.fes.web.controller;

import com.fes.common.domain.SimpleHttpResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created by qigege on 2017/9/3.
 */
@Controller
public class ViewController {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String showAllCustomer(){
        return "account/index";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String viewLogin(){
        return "login";
    }
    
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String viewRegister(){
        return "account/register";
    }
    
    @RequestMapping(value = "/organizationRegister", method = RequestMethod.GET)
    public String viewOrganizationRegister(){
        return "account/organizationRegister";
    }
    
    @RequestMapping(value = "/individualRegister", method = RequestMethod.GET)
    public String viewIndividualRegister(){
        return "account/individualRegister";
    }
    
    @RequestMapping(value = "/mailUs", method = RequestMethod.GET)
    public String viewMail(){
        return "mail";
    }
    
    @RequestMapping(value = "/individualHome", method = RequestMethod.GET)
    public String viewIndividualHome(){
        return "IndividualUser/individualHome";
    }
    
    @RequestMapping(value = "/organizationHome", method = RequestMethod.GET)
    public String viewOrganizationHome(){
        return "OrganizationUser/organizationHome";
    }
}
