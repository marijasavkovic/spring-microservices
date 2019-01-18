package com.master.authservice.model.user;

import java.io.Serializable;
import java.util.List;

import com.master.authservice.model.authority.Authority;

public class UserRecord implements Serializable {

    private Long id;
    private String username;
    private String email;
    private List<Authority> authorities;
    private String employeeName;
    private String employeeSurname;

    public UserRecord() {
    }

    public UserRecord(
            final Long id,
            final String username,
            final String email,
            List<Authority> authorities, final String employeeName,
            final String employeeSurname)
    {
        this.id = id;
        this.username = username;
        this.email = email;
        this.authorities = authorities;
        this.employeeName = employeeName;
        this.employeeSurname = employeeSurname;
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

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(final String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeSurname() {
        return employeeSurname;
    }

    public void setEmployeeSurname(final String employeeSurname) {
        this.employeeSurname = employeeSurname;
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
