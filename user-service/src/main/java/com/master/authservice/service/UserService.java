package com.master.authservice.service;

import java.util.List;

import com.master.authservice.model.user.User;
import com.master.authservice.model.user.UserCmd;
import com.master.authservice.sheard.response.Response;

public interface UserService {

    Response<List<User>> findAll();

    Response<User> findById(Long id);

    Response<User> add(UserCmd userCmd);

    Response<User> edit(Long userId, UserCmd userCmd);

    Response<?> delete(Long userId);

}
