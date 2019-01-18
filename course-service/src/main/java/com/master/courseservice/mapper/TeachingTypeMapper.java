package com.master.courseservice.mapper;

import java.util.List;

import com.master.courseservice.domain.TeachingTypeEntity;
import com.master.courseservice.model.teachingtype.TeachingType;
import com.master.courseservice.sheard.constants.Constants;
import org.mapstruct.Mapper;

@Mapper(componentModel = Constants.MAPPER_COMPONENT_MODEL)
public interface TeachingTypeMapper {

    List<TeachingType> mapToModelList(List<TeachingTypeEntity> teachingTypeEntities);
}
