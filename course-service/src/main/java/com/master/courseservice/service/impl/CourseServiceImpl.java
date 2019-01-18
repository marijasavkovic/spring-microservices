package com.master.courseservice.service.impl;

import java.util.List;
import java.util.Optional;

import com.master.courseservice.domain.CourseEntity;
import com.master.courseservice.mapper.CourseMapper;
import com.master.courseservice.model.course.Course;
import com.master.courseservice.model.course.CourseCmd;
import com.master.courseservice.repository.CourseRepository;
import com.master.courseservice.service.CourseService;
import com.master.courseservice.sheard.response.Response;
import com.master.courseservice.sheard.response.ResponseStatus;
import com.master.courseservice.validator.CourseValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CourseServiceImpl implements CourseService{

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;
    private final CourseValidator.Add courseValidatorAdd;

    @Autowired
    public CourseServiceImpl(final CourseRepository courseRepository,
                            final CourseMapper courseMapper, final CourseValidator.Add courseValidatorAdd) {
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
        this.courseValidatorAdd = courseValidatorAdd;
    }

    @Override
    public Response<List<Course>> findAll() {
        return new Response<>(courseMapper.mapToModelList(courseRepository.findAll()));
    }

    @Override
    public Response<Course> findById(final Long id) {
        Optional<Course> course = courseRepository.findById(id).map(courseMapper::mapToModel);
        return course.map(Response::new).orElse(new Response<>(ResponseStatus.NOT_FOUND));
    }

    @Override
    public Response<Course> add(final CourseCmd courseCmd) {
        return new Response<>(addCourse(courseCmd));
    }

    @Override
    public Response<Course> edit(final Long courseId, final CourseCmd courseCmd) {
        return new Response<>(editCourse(courseId, courseCmd));
    }

    @Override
    public Response<?> delete(final Long courseId) {
        courseRepository.deleteById(courseId);
        return new Response<>(ResponseStatus.OK, "Course is deleted successfully!");
    }

    private Course addCourse (CourseCmd courseCmd) {
        courseValidatorAdd.validate(courseCmd);

        CourseEntity courseEntity = courseMapper.mapToEntity(courseCmd);
        return courseMapper.mapToModel(courseRepository.save(courseEntity));
    }

    private Course editCourse (Long courseId, CourseCmd courseCmd){

        CourseEntity courseEntity = courseRepository.findById(courseId)
            .orElseThrow(RuntimeException::new);

        courseMapper.updateEntityFromModel(courseCmd, courseEntity);

        return courseMapper.mapToModel(courseRepository.save(courseEntity));
    }
}
