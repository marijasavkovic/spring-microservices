package com.master.levelofstudiesservice.mapper;

import com.master.levelofstudiesservice.domain.LevelOfStudiesEntity;
import com.master.levelofstudiesservice.model.LevelOfStudies;
import com.master.levelofstudiesservice.sheard.constants.Constants;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = Constants.MAPPER_COMPONENT_MODEL)
public interface LevelOfStudiesMapper {

    List<LevelOfStudies> mapToModelList(List<LevelOfStudiesEntity> levelOfStudiesEntities);

}
