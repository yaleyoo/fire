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
        return "index";
    }
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String viewLogin(){
        return "login";
    }
}
