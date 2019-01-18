package com.master.courseservice.facade.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.master.courseservice.facade.Facade;
import com.master.courseservice.model.course.Course;
import com.master.courseservice.model.course.CourseCmd;
import com.master.courseservice.model.teachingtype.TeachingType;
import com.master.courseservice.service.CourseService;
import com.master.courseservice.service.TeachingTypeService;
import com.master.courseservice.sheard.exception.ValidationException;
import com.master.courseservice.sheard.response.Response;
import com.master.courseservice.sheard.response.ResponseStatus;
import com.master.courseservice.sheard.validation.ValidationGroups;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "application/")
public class FacadeImpl implements Facade {

    private final TeachingTypeService teachingTypeService;
    private final CourseService courseService;

    @Autowired
    public FacadeImpl(
        final TeachingTypeService teachingTypeService,
        final CourseService courseService)
    {
        this.teachingTypeService = teachingTypeService;
        this.courseService = courseService;
    }

    @Override
    @GetMapping("teachingType/findAllTeachingTypes")
    public Response<List<TeachingType>> findAllTeachingTypes() {
        return teachingTypeService.findAll();
    }

    @Override
    @DeleteMapping(path = "course/{courseId}")
    public Response<?> deleteCourse(@PathVariable Long courseId) {
        return courseService.delete(courseId);
    }

    @Override
    @GetMapping("course/findAllCourses")
    public Response<List<Course>> findAllCourses() {
        return courseService.findAll();
    }

    @Override
    @GetMapping("course/{courseId}")
    public Response<Course> findCourseById(@PathVariable Long courseId) {
        return courseService.findById(courseId);
    }

    @Override
    @PostMapping("course")
    public Response<Course> addCourse(@Validated(ValidationGroups.Add.class) @RequestBody CourseCmd courseCmd) {
        return courseService.add(courseCmd);
    }

    @Override
    @PutMapping("course/{courseId}")
    public Response<Course> editCourse(
        @PathVariable Long courseId,
        @Validated(ValidationGroups.Edit.class) @RequestBody CourseCmd courseCmd)
    {
        return courseService.edit(courseId, courseCmd);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Response<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {

        List<Error> errors = ex
            .getBindingResult()
            .getFieldErrors()
            .stream()
            .map(fe -> new Error(fe.getDefaultMessage()))
            .collect(Collectors.toList());

        return new Response<>(ResponseStatus.BAD_REQUEST, errors);
    }

    @ExceptionHandler(ValidationException.class)
    public Response<?> handleValidationException(ValidationException ex) {
        return new Response<>(ResponseStatus.INTERNAL_SERVER_ERROR, ex.getErrors());
    }

}
