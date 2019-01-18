package com.master.courseservice.service;

import java.util.List;

import com.master.courseservice.model.course.Course;
import com.master.courseservice.model.course.CourseCmd;
import com.master.courseservice.sheard.response.Response;

public interface CourseService {

    Response<List<Course>> findAll();

    Response<Course> findById(Long id);

    Response<Course> add(CourseCmd courseCmd);

    Response<Course> edit(Long courseId, CourseCmd courseCmd);

    Response<?> delete(Long courseId);

}
