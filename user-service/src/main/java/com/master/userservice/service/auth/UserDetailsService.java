package com.master.userservice.service.auth;

import java.util.List;
import java.util.stream.Collectors;

import com.master.userservice.domain.UserEntity;
import com.master.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component("userDetailsService")
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        String lowercaseLogin = username.toLowerCase();

        UserEntity user = userRepository.findByUsernameCaseInsensitive(lowercaseLogin);

        if (user == null) {
            throw new UsernameNotFoundException("User " + lowercaseLogin + " was not found in the database");
        }

        List<GrantedAuthority> grantedAuthorities = user.getAuthorities().stream()
                .map(a -> new SimpleGrantedAuthority(
                        a.getName()))
                .collect(Collectors.toList());

        return new com.master.userservice.model.auth.UserDetails(user.getUsername(), user.getPassword(), true, grantedAuthorities);
    }
}
