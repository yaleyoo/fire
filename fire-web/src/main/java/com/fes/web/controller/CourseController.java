package com.fes.web.controller;

import com.fes.biz.service.IClassService;
import com.fes.biz.service.ICourseService;
import com.fes.common.annotation.Authorization;
import com.fes.common.constants.UserType;
import com.fes.common.domain.SimpleHttpResult;
import com.fes.dao.domain.ClassPO;
import com.fes.dao.domain.Course;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;

/**
 * Created by qigege on 2017/10/2.
 */
@RestController
@RequestMapping("/course")
@CrossOrigin(origins = "*")
@Validated
public class CourseController {

	@Resource
	private ICourseService courseService;

    @Resource
    private IClassService classService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getCourseById(@PathVariable("id") int id){
        return courseService.getCourseById(id);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity getAllCourses(){
    	return courseService.showAllCourses();
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity addNewCourse(Course course){
        return courseService.addCourse(course);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public ResponseEntity modifyCourse(Course course){
        return courseService.modifyCourse(course);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteCourse(@PathVariable("id") int id){
        return courseService.deleteCourse(id);
    }

    @RequestMapping(value = "/{id}/class", method = RequestMethod.GET)
    public ResponseEntity getClassesByCourseId(@PathVariable("id") int id){

        //TODO
        return new ResponseEntity(new SimpleHttpResult<>(), HttpStatus.OK);

    }


    @RequestMapping(value = "/{id}/class", method = RequestMethod.POST)
    public ResponseEntity createClass(@PathVariable("id") int courseId,ClassPO classPO){

        //TODO
        return new ResponseEntity(new SimpleHttpResult<>(), HttpStatus.OK);

    }


    @RequestMapping(value = "/{courseId}/class/{classId}", method = RequestMethod.PUT)
    public ResponseEntity modifyClass(@PathVariable("courseId") int courseId, @PathVariable("classId") int classId, @Valid ClassPO classPO){
        //TODO
        return new ResponseEntity(new SimpleHttpResult<>(), HttpStatus.OK);

    }

    @RequestMapping(value = "/{courseId}/class/{classId}", method = RequestMethod.DELETE)
    public ResponseEntity deleteClass(@PathVariable("courseId") int courseId, @PathVariable("classId") int classId){
        //TODO
        return new ResponseEntity(new SimpleHttpResult<>(), HttpStatus.OK);

    }


    @RequestMapping(value = "/{courseId}/class/{classId}", method = RequestMethod.GET)
    public ResponseEntity showClass(@PathVariable("courseId") int courseId, @PathVariable("classId") int classId) {
        //todo
        return new ResponseEntity(new SimpleHttpResult<>(), HttpStatus.OK);
    }

    @Authorization(authority = UserType.STAFF)
    @RequestMapping(value = "/filterClass", method = RequestMethod.GET)
    public ResponseEntity filterClass(int courseID, String classAddr, String classStartTime, int minPrice, int maxPrice ) throws ParseException {
        return classService.filterClass(courseID, classAddr, classStartTime, minPrice, maxPrice);

    }

}
