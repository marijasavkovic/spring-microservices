package com.master.authservice.model.auth;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;

public class UserDetails implements org.springframework.security.core.userdetails.UserDetails {

    private final String username;
    private final String password;
    private final boolean activated;
    private final List<GrantedAuthority> authorities;

    public UserDetails(String username, String password, boolean activated, List<GrantedAuthority> authorities) {
        this.username = username;
        this.password = password;
        this.activated = activated;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return activated;
    }

    @Override
    public boolean isAccountNonLocked() {
        return activated;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return activated;
    }

    @Override
    public boolean isEnabled() {
        return activated;
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", activated=" + activated +
                ", authorities=" + authorities +
                '}';
    }
}
