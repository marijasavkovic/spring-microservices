package com.master.departmentservice.mapper;

import com.master.departmentservice.domain.DepartmentEntity;
import com.master.departmentservice.model.Department;
import com.master.departmentservice.sheard.constants.Constants;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = Constants.MAPPER_COMPONENT_MODEL)
public interface DepartmentMapper {

    List<Department> mapToModelList(List<DepartmentEntity> departmentEntities);

}
