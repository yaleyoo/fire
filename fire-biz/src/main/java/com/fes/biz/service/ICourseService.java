package com.fes.biz.service;

import com.fes.dao.domain.Course;
import org.springframework.http.ResponseEntity;

/**
 * Created by qigege on 2017/9/3.
 */
public interface ICourseService {

    ResponseEntity getCourseById(int courseId);

    ResponseEntity showAllCourses();

    ResponseEntity addCourse(Course course);

    ResponseEntity deleteCourse(int courseId);

    ResponseEntity modifyCourse(Course course);
}
