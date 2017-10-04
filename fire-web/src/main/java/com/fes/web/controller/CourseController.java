package com.fes.web.controller;

import com.fes.biz.service.ICourseService;
import com.fes.dao.domain.Course;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by qigege on 2017/10/2.
 */
@RestController
@RequestMapping("/course")
public class CourseController {

    private ICourseService courseService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getCourseById(@PathVariable("id") int id){
        return courseService.getCourseById(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity getAllCourses(){
        return courseService.showAllCourses();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity addNewCourse(Course course){
        return courseService.addCourse(course);
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public ResponseEntity modifyCourse(Course course){
        return courseService.modifyCourse(course);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteCourse(@PathVariable("id") int id){
        return courseService.deleteCourse(id);
    }

}
