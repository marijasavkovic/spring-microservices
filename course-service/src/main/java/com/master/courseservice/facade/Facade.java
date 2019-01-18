package com.master.courseservice.facade;

import java.util.List;

import com.master.courseservice.model.course.Course;
import com.master.courseservice.model.course.CourseCmd;
import com.master.courseservice.model.teachingtype.TeachingType;
import com.master.courseservice.sheard.response.Response;

public interface Facade {

    Response<List<TeachingType>> findAllTeachingTypes();

    Response<List<Course>> findAllCourses();

    Response<Course> findCourseById(Long id);

    Response<Course> addCourse(CourseCmd courseCmd);

    Response<Course> editCourse(Long courseId, CourseCmd courseCmd);

    Response<?> deleteCourse(Long courseId);

}
