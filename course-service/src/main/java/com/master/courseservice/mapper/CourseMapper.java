package com.master.courseservice.mapper;

import java.util.List;

import com.master.courseservice.domain.CourseEntity;
import com.master.courseservice.domain.LecturerEntity;
import com.master.courseservice.domain.ThematicUnitEntity;
import com.master.courseservice.mapper.decorator.CourseMapperDecorator;
import com.master.courseservice.model.course.Course;
import com.master.courseservice.model.course.CourseCmd;
import com.master.courseservice.model.lecturer.Lecturer;
import com.master.courseservice.model.lecturer.LecturerCmd;
import com.master.courseservice.model.thematicunit.ThematicUnit;
import com.master.courseservice.model.thematicunit.ThematicUnitCmd;
import com.master.courseservice.sheard.constants.Constants;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = Constants.MAPPER_COMPONENT_MODEL)
@DecoratedWith(CourseMapperDecorator.class)
public interface CourseMapper {

    List<Course> mapToModelList(List<CourseEntity> courseEntities);

    Course mapToModel(CourseEntity courseEntity);

    Lecturer lecturerEntityToLecturer(LecturerEntity lecturerEntity);

    ThematicUnit thematicUnitEntityToThematicUnit(ThematicUnitEntity thematicUnitEntity);

    CourseEntity mapToEntity(CourseCmd model);

    @Mapping(target = "course", ignore = true)
    @Mapping(target = "teachingType", ignore = true)
    LecturerEntity lecturerCmdToLecturerEntity(LecturerCmd lecturerCmd);

    @Mapping(target = "parentThematicUnit", ignore = true)
    @Mapping(target = "course", ignore = true)
    ThematicUnitEntity thematicUnitCmdToThematicUnitEntity(ThematicUnitCmd thematicUnitCmd);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "lecturerList", ignore = true)
    @Mapping(target = "thematicUnitsList", ignore = true)
    void updateEntityFromModel(CourseCmd courseCmd, @MappingTarget CourseEntity courseEntity);

    @Mapping(target = "lecturerList", ignore = true)
    @Mapping(target = "thematicUnitsList", ignore = true)
    CourseCmd courseToCourseCmd(Course course);
}
