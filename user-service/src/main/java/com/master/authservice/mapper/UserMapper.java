package com.master.authservice.mapper;

import java.util.List;

import com.master.authservice.domain.UserEntity;
import com.master.authservice.mapper.decorator.UserMapperDecorator;
import com.master.authservice.model.user.User;
import com.master.authservice.model.user.UserCmd;
import com.master.authservice.sheard.constants.Constants;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = Constants.MAPPER_COMPONENT_MODEL)
@DecoratedWith(UserMapperDecorator.class)
public interface UserMapper {

    List<User> mapToModelList(List<UserEntity> userEntities);

    User mapToModel(UserEntity userEntity);

    UserEntity mapToEntity(UserCmd model);

    @Mapping(target = "id", ignore = true)
    void updateEntityFromModel(UserCmd userCmd, @MappingTarget UserEntity userEntity);
}
