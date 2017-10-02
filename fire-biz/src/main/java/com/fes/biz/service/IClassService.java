package com.fes.biz.service;

import org.springframework.http.ResponseEntity;

import java.text.ParseException;

/**
 * Created by qigege on 2017/9/3.
 */
public interface IClassService {

    ResponseEntity filterClass(int courseID, String classAddr, String classStartTime, int minPrice, int maxPrice) throws ParseException;
}
