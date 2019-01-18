package com.master.authservice.model.user;

import java.io.Serializable;
import java.util.List;

import com.master.authservice.model.authority.Authority;

public class User implements Serializable{

    private Long id;
    private String username;
    private String password;
    private String email;
    private List<Authority> authorities;
    private Long employeeId;

    public User() {
    }

    public User(
            final String username,
            final String password,
            final String email,
            List<Authority> authorities, Long employeeId)
    {
        this.username = username;
        this.password = password;
        this.email = email;
        this.authorities = authorities;
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

    public List<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
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
