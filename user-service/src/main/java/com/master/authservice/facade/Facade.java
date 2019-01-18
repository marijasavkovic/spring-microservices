package com.master.authservice.facade;

import java.util.List;

import com.master.authservice.model.user.User;
import com.master.authservice.model.user.UserCmd;
import com.master.authservice.sheard.response.Response;

public interface Facade {

    Response<List<User>> findAllUsers();

    Response<User> findUserById(Long id);

    Response<User> addUser(UserCmd userCmd);

    Response<User> editUser(Long userId, UserCmd userCmd);

    Response<?> deleteUser(Long userId);
}
