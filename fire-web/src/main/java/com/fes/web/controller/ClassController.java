package com.fes.web.controller;

import com.fes.biz.service.IClassService;
import com.fes.common.annotation.Authorization;
import com.fes.common.constants.UserType;
import com.fes.common.domain.SimpleHttpResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.annotation.Resource;

/**
 * Created by qigege on 2017/10/2.
 */
@Controller
@CrossOrigin(origins = "*")
@Validated
public class ClassController {

    @Resource
    private IClassService classService;

    @Authorization(authority = UserType.STAFF)
    @RequestMapping(value = "/filterClass", method = RequestMethod.GET)
    public ResponseEntity filterClass(int courseID, String classAddr, String classStartTime, int minPrice, int maxPrice ) {
        try {
            return classService.filterClass(courseID, classAddr, classStartTime, minPrice, maxPrice);
        } catch (Exception e){
            return new ResponseEntity(new SimpleHttpResult(false,
                    "Service Wrong! Please try again later!"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
