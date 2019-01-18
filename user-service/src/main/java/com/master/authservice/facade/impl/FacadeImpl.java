package com.master.authservice.facade.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.master.authservice.facade.Facade;
import com.master.authservice.model.user.User;
import com.master.authservice.model.user.UserCmd;
import com.master.authservice.service.UserService;
import com.master.authservice.sheard.exception.ValidationException;
import com.master.authservice.sheard.response.Response;
import com.master.authservice.sheard.response.ResponseStatus;
import com.master.authservice.sheard.validation.ValidationGroups;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "application/")
public class FacadeImpl implements Facade {

    private final UserService userService;

    @Autowired
    public FacadeImpl(
        final UserService userService)
    {
        this.userService = userService;
    }

    @Override
    @GetMapping("user/findAllUsers")
    public Response<List<User>> findAllUsers() {
        return userService.findAll();
    }

    @Override
    @GetMapping("user/{userId}")
    public Response<User> findUserById(@PathVariable Long userId) {
        return userService.findById(userId);
    }

    @Override
    @PostMapping("user")
    public Response<User> addUser(@Validated(ValidationGroups.Add.class) @RequestBody UserCmd userCmd) {
        return userService.add(userCmd);
    }

    @Override
    @PutMapping("user/{userId}")
    public Response<User> editUser(@PathVariable Long userId, @Validated(ValidationGroups.Edit.class) @RequestBody UserCmd userCmd) {
        return userService.edit(userId, userCmd);
    }

    @Override
    @DeleteMapping(path = "user/{userId}")
    public Response<?> deleteUser(@PathVariable Long userId) {
        return userService.delete(userId);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Response<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {

        List<Error> errors = ex
            .getBindingResult()
            .getFieldErrors()
            .stream()
            .map(fe -> new Error(fe.getDefaultMessage()))
            .collect(Collectors.toList());

        return new Response<>(com.master.authservice.sheard.response.ResponseStatus.BAD_REQUEST, errors);
    }

    @ExceptionHandler(ValidationException.class)
    public Response<?> handleValidationException(ValidationException ex) {
        return new Response<>(ResponseStatus.INTERNAL_SERVER_ERROR, ex.getErrors());
    }

}
