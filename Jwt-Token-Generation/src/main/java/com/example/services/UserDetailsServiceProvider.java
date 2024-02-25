package com.example.services;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.entity.Client;
import com.example.repos.ClientRepo;

@Service
public class UserDetailsServiceProvider implements UserDetailsService {

    @Autowired
    private ClientRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Client user = repo.findByCname(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new User(
            user.getCname(),
            user.getPassword(),
            true,
            true,
            true,
            true,
            getAuthorities(Arrays.asList(user.getRoles().split(",")))
        );
    }

    private Collection<? extends GrantedAuthority> getAuthorities(Collection<String> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
                .collect(Collectors.toList());
    }
}
