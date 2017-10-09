package com.fes.biz.impl;

import com.fes.biz.service.ICourseService;
import com.fes.common.domain.SimpleHttpResult;
import com.fes.dao.domain.Course;
import com.fes.dao.mappers.CourseMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by qigege on 2017/10/2.
 */
public class CourseServiceImpl implements ICourseService {

    @Resource
    private CourseMapper courseMapper;

    @Override
    public ResponseEntity getCourseById(int courseId) {
        SimpleHttpResult<Course> httpResult = new SimpleHttpResult<>();
        Course result = courseMapper.selectCourseById(courseId);
        if (result == null){
            httpResult.setSuccess(false, "Can't find this course!");
            return new ResponseEntity(httpResult, HttpStatus.NOT_FOUND);
        }
        httpResult.setData(result);
        return new ResponseEntity(httpResult, HttpStatus.OK);
    }

    @Override
    public ResponseEntity showAllCourses() {
        SimpleHttpResult<List<Course>> httpResult = new SimpleHttpResult<>();
        List<Course> result = courseMapper.selectCourse();
        httpResult.setData(result);
        return new ResponseEntity(httpResult, HttpStatus.OK);
    }

    @Override
    public ResponseEntity addCourse(Course course) {
        SimpleHttpResult httpResult = new SimpleHttpResult();
        if (courseMapper.insertCourse(course)){
            return new ResponseEntity(httpResult, HttpStatus.OK);
        }
        httpResult.setSuccess(false, "insert failed!");
        return new ResponseEntity(httpResult, HttpStatus.SERVICE_UNAVAILABLE);
    }

    @Override
    public ResponseEntity deleteCourse(int courseId) {
        SimpleHttpResult httpResult = new SimpleHttpResult();
        if (courseMapper.deleteCourse(courseId)){
            return new ResponseEntity(httpResult, HttpStatus.OK);
        }
        httpResult.setSuccess(false, "delete failed!");
        return new ResponseEntity(httpResult, HttpStatus.SERVICE_UNAVAILABLE);
    }

    @Override
    public ResponseEntity modifyCourse(Course course) {
        SimpleHttpResult httpResult = new SimpleHttpResult();
        if (courseMapper.updateCourse(course)){
            return new ResponseEntity(httpResult, HttpStatus.OK);
        }
        httpResult.setSuccess(false, "modify failed!");
        return new ResponseEntity(httpResult, HttpStatus.SERVICE_UNAVAILABLE);
    }
}
