package com.master.authservice.service.impl;

import java.util.List;
import java.util.Optional;

import com.master.authservice.domain.UserEntity;
import com.master.authservice.mapper.UserMapper;
import com.master.authservice.model.user.User;
import com.master.authservice.model.user.UserCmd;
import com.master.authservice.repository.UserRepository;
import com.master.authservice.service.UserService;
import com.master.authservice.sheard.response.Response;
import com.master.authservice.sheard.response.ResponseStatus;
import com.master.authservice.validator.user.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserValidator.Add userValidatorAdd;
    @Autowired
    private UserValidator.Edit userValidatorEdit;
    @Autowired
    private UserMapper userMapper;

    @Override
    public Response<List<User>> findAll() {
        return new Response<>(userMapper.mapToModelList(userRepository.findAll()));
    }

    @Override
    public Response<User> findById(final Long id) {
        Optional<User> user = userRepository.findById(id).map(userMapper::mapToModel);
        return user.map(Response::new).orElse(new Response<>(ResponseStatus.NOT_FOUND));
    }

    @Override
    public Response<User> add(final UserCmd userCmd) {
        userValidatorAdd.validate(userCmd);

        UserEntity userEntity = userMapper.mapToEntity(userCmd);
        User user = userMapper.mapToModel(userRepository.save(userEntity));

        return new Response<>(user);
    }

    @Override
    public Response<User> edit(final Long userId, final UserCmd userCmd) {
        UserEntity userEntity = userRepository.findById(userId)
            .orElseThrow(RuntimeException::new);

        userValidatorEdit.validate(userId, userCmd);
        userMapper.updateEntityFromModel(userCmd, userEntity);
        User user = userMapper.mapToModel(userRepository.save(userEntity));
        return new Response<>(user);
    }

    @Override
    public Response<?> delete(final Long userId) {
        userRepository.deleteById(userId);
        return new Response<>(ResponseStatus.OK, "User is deleted successfully!");
    }
}
