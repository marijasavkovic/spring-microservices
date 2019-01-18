package com.master.courseservice.mapper;

import java.util.List;

import com.master.courseservice.domain.LecturerEntity;
import com.master.courseservice.model.lecturer.Lecturer;
import com.master.courseservice.sheard.constants.Constants;
import org.mapstruct.Mapper;

@Mapper(componentModel = Constants.MAPPER_COMPONENT_MODEL)
public interface LecturerMapper {

    List<Lecturer> mapToModelList(List<LecturerEntity> courseEntities);

    Lecturer mapToModel(LecturerEntity entity);

}
