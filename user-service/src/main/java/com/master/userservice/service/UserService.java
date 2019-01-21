package com.master.userservice.service;

import java.util.List;

import com.master.userservice.model.user.User;
import com.master.userservice.model.user.UserCmd;
import com.master.userservice.sheard.response.Response;

public interface UserService {

    Response<List<User>> findAll();

    Response<User> findById(Long id);

    Response<User> add(UserCmd userCmd);

    Response<User> edit(Long userId, UserCmd userCmd);

    Response<?> delete(Long userId);

}
