package com.fes.web.controller;

import com.fes.biz.service.IClassService;
import com.fes.biz.service.ICourseService;
import com.fes.common.annotation.Authorization;
import com.fes.common.constants.UserType;
import com.fes.common.domain.SimpleHttpResult;
import com.fes.dao.domain.ClassItemPO;
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
        course.getCourseName();
        course.getCourseDesc();

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
        return classService.getClassByCourseId(id);
    }

    @RequestMapping(value = "/class", method = RequestMethod.GET)
    public ResponseEntity getAllClasses(){
        return classService.getAll();
    }

    
    @RequestMapping(value = "/class/{date}", method = RequestMethod.GET)
    public ResponseEntity getClassById(@PathVariable("date") String date){
        return classService.getClassByDate(date);
    }
    
    


    @RequestMapping(value = "/{id}/class", method = RequestMethod.POST)
    public ResponseEntity createClass(@PathVariable("id") int courseId,ClassPO classPO){
        return classService.createClass(classPO);
    }


    @RequestMapping(value = "/{courseId}/class/{classId}", method = RequestMethod.PUT)
    public ResponseEntity modifyClass(@PathVariable("courseId") int courseId, @PathVariable("classId") int classId, @Valid ClassPO classPO){

    		return classService.modifyClass(courseId, classId, classPO);
    }

    @RequestMapping(value = "/{courseId}/class/{classId}", method = RequestMethod.DELETE)
    public ResponseEntity deleteClass(@PathVariable("courseId") int courseId, @PathVariable("classId") int classId){
        return classService.deleteClass(courseId, classId);
    }


    @RequestMapping(value = "/{courseId}/class/{classId}", method = RequestMethod.GET)
    public ResponseEntity showClass(@PathVariable("classId") int classId) {
        return classService.getClassById(classId);
    }

    @RequestMapping(value = "/{courseId}/class/{classId}/class-item", method = RequestMethod.GET)
    public ResponseEntity showClassItem(@PathVariable("classId") int classId) {
        return classService.getClassItem(classId);
    }

    @RequestMapping(value = "/{courseId}/class/{classId}/class-item", method = RequestMethod.POST)
    public ResponseEntity createClassItem(@PathVariable("classId") int classId) {
        //TODO
        return new ResponseEntity(null, HttpStatus.OK);
    }

    @RequestMapping(value = "/{courseId}/class/{classId}/class-item/{itemId}", method = RequestMethod.PUT)
    public ResponseEntity modifyClassItem(@PathVariable("itemId") int itemId, ClassItemPO classItemPO) {
        //TODO
        return new ResponseEntity(null, HttpStatus.OK);
    }

    @RequestMapping(value = "/{courseId}/class/{classId}/class-item/{itemId}", method = RequestMethod.DELETE)
    public ResponseEntity deleteClassItem(@PathVariable("itemId") int itemId) {
        //TODO
        return new ResponseEntity(null, HttpStatus.OK);
    }

    @Authorization(authority = UserType.STAFF)
    @RequestMapping(value = "/filterClass", method = RequestMethod.GET)
    public ResponseEntity filterClass(int courseID, String classAddr, String classStartTime, int minPrice, int maxPrice ) throws ParseException {
        return classService.filterClass(courseID, classAddr, classStartTime, minPrice, maxPrice);

    }
    
    @RequestMapping(value = "/getAllClass", method = RequestMethod.GET)
    public ResponseEntity getAllClass() {
    		return classService.getAll();
    }
    
 

}
