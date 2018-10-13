package com.master.employeeservice.mapper;

import com.master.employeeservice.domain.EmployeeEntity;
import com.master.employeeservice.model.Employee;
import com.master.employeeservice.model.EmployeeCmd;
import com.master.employeeservice.model.EmployeeRecord;
import com.master.employeeservice.sheard.constants.Constants;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = Constants.MAPPER_COMPONENT_MODEL)
public interface EmployeeMapper {

    @Mapping(target = "id", ignore = true)
    EmployeeEntity mapToEntity(EmployeeCmd model);

    Employee mapToModel(EmployeeEntity entity);

    List<EmployeeRecord> mapToModelList(List<EmployeeEntity> levelOfStudiesEntities);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "personalIdentificationNumber", ignore = true)
    void updateEntityFromModel(EmployeeCmd model, @MappingTarget EmployeeEntity entity);

}
