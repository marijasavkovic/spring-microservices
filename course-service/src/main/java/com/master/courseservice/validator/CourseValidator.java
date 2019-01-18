package com.master.courseservice.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.master.courseservice.domain.CourseEntity;
import com.master.courseservice.model.course.CourseCmd;
import com.master.courseservice.repository.CourseRepository;
import com.master.courseservice.sheard.exception.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CourseValidator {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseValidator(final CourseRepository courseRepository) {
        this.courseRepository= courseRepository;
    }

    @Component
    public class Add {

        public void validate(CourseCmd courseCmd) {

            List<Error> errors = new ArrayList<>();

            Error error = checkNameUnique(courseCmd.getName());

            if (error!=null) {
                errors.add(error);
            }

            if(!errors.isEmpty()){
                throw new ValidationException(errors);
            }

        }
    }

    private Error checkNameUnique (String name){
        final Optional<CourseEntity> courseEntity = courseRepository.findByName(
            name);

        if (courseEntity.isPresent()) {
            return  new Error("Course with this name already exists");
        }
        return null;
    }

    @Component
    public class Edit {

        public void validate(Long courseId, CourseCmd courseCmd) {

            List<Error> errors = new ArrayList<>();

            CourseEntity course = courseRepository
                .findById(courseId)
                .orElseThrow(() -> new ValidationException(new Error("Course with that id does not exists")));
            ;

            final Optional<CourseEntity> courseEntity = courseRepository.findByName(
                courseCmd.getName());

            if (courseEntity.isPresent()) {
                errors.add(new Error("Course with this name already exists"));
            }
        }
    }

    @Component
    public class Delete {

        public void validate(Long courseId) {

        }

    }


}
