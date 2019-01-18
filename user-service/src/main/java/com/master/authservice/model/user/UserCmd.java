package com.master.authservice.model.user;

import javax.validation.constraints.NotNull;
import java.util.List;

import com.master.authservice.sheard.errors.ErrorMessages;
import com.master.authservice.sheard.validation.ValidationGroups;
import org.hibernate.validator.constraints.NotEmpty;

public class UserCmd {

    @NotNull(message = ErrorMessages.ID_NULL, groups = ValidationGroups.Edit.class)
    private Long id;
    @NotEmpty(message = ErrorMessages.USERNAME_EMPTY, groups = ValidationGroups.Add.class)
    private String username;
    @NotEmpty(message = ErrorMessages.PASSWORD_EMPTY,  groups = ValidationGroups.Add.class)
    private String password;
    @NotEmpty(message = ErrorMessages.EMAIL_EMPTY,  groups = ValidationGroups.Add.class)
    private String email;
    @NotEmpty(message = ErrorMessages.USER_ROLE_NULL)
    private List<Long> authorityIds;
    @NotNull(message = ErrorMessages.EMPLOYEE_NULL)
    private Long employeeId;

    public UserCmd() {
    }

    public UserCmd(
            final String username,
            final String password,
            final String email,
            List<Long> authorityIds,
            final Long employeeId)
    {
        this.username = username;
        this.password = password;
        this.email = email;
        this.authorityIds = authorityIds;
        this.employeeId = employeeId;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public List<Long> getAuthorityIds() {
        return authorityIds;
    }

    public void setAuthorityIds(List<Long> authorityIds) {
        this.authorityIds = authorityIds;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return new StringBuilder(this.getClass().getSimpleName())
            .append("id")
            .append(id)
            .append("username")
            .append(username)
            .append("email")
            .append(email)
            .toString();
    }
}
