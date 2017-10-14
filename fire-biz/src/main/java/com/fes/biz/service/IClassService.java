package com.fes.biz.service;

import org.springframework.http.ResponseEntity;

import com.fes.dao.domain.ClassPO;

import java.text.ParseException;

/**
 * Created by qigege on 2017/9/3.
 */
public interface IClassService {

    ResponseEntity filterClass(int courseID, String classAddr, String classStartTime, int minPrice, int maxPrice) throws ParseException;
    
    ResponseEntity getAll();
    
    ResponseEntity getClassByCourseId(int courseId);
    
    ResponseEntity getClassById(int id);
    
    ResponseEntity getClassByDate(String date);
    
    ResponseEntity deleteClass(int courseId, int classId);
    
    ResponseEntity createClass(ClassPO classPO);
    
    ResponseEntity modifyClass(int courseId, int classId, ClassPO classPO);
    
    ResponseEntity getClassItem(int classId);
}
