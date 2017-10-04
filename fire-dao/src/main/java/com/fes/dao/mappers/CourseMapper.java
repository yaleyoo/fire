package com.fes.dao.mappers;

import com.fes.dao.domain.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by qigege on 2017/9/3.
 */
public interface CourseMapper {

    Course selectCourseById(@Param("id") int id);

    boolean insertCourse(Course course);

    boolean updateCourse(Course course);

    boolean deleteCourse(@Param("id") int id);

    List<Course> selectCourse();
}
