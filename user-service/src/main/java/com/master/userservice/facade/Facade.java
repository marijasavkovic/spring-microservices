package com.master.userservice.facade;

import java.util.List;

import com.master.userservice.model.user.User;
import com.master.userservice.model.user.UserCmd;
import com.master.userservice.sheard.response.Response;

public interface Facade {

    Response<List<User>> findAllUsers();

    Response<User> findUserById(Long id);

    Response<User> addUser(UserCmd userCmd);

    Response<User> editUser(Long userId, UserCmd userCmd);

    Response<?> deleteUser(Long userId);
}
