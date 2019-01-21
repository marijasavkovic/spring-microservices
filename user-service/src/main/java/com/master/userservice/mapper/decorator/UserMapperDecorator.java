package com.master.userservice.mapper.decorator;

import java.util.ArrayList;
import java.util.List;

import com.master.userservice.domain.AuthorityEntity;
import com.master.userservice.domain.UserEntity;
import com.master.userservice.mapper.UserMapper;
import com.master.userservice.model.user.UserCmd;
import com.master.userservice.repository.AuthorityRepository;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class UserMapperDecorator implements UserMapper {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AuthorityRepository authorityRepository;

    @Override
    public UserEntity mapToEntity(final UserCmd model) {
        UserEntity userEntity = userMapper.mapToEntity(model);

        if(model.getAuthorityIds() != null){
            userEntity.setAuthorities(new ArrayList<>());
            for (Long authorityId : model.getAuthorityIds()) {
                AuthorityEntity authorityEntity = authorityRepository.findById(authorityId).orElseThrow(RuntimeException::new);
                userEntity.getAuthorities().add(authorityEntity);
            }
        }
        return userEntity;
    }

    @Override
    public void updateEntityFromModel(final UserCmd model, final UserEntity entity) {
        if (model == null) {
            return;
        }
        userMapper.updateEntityFromModel(model, entity);

        List<AuthorityEntity> authorityEntities = new ArrayList<>();
        for (Long authority: model.getAuthorityIds()) {
            authorityEntities.add(authorityRepository.findById(authority).orElseThrow(RuntimeException::new));
        }
        entity.getAuthorities().removeIf((AuthorityEntity authorityEntity) -> !authorityEntities.contains(authorityEntity));
        for (AuthorityEntity authorityEntity : authorityEntities) {
            entity.addAuthority(authorityEntity);
        }
    }
}
