package com.loggingg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.loggingg.entity.userentity;
import com.loggingg.repository.userrepository;

@Service
public class CustomUserDetailsService
implements UserDetailsService {

    @Autowired
    private userrepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) {
    	userentity user =
                repo.findByUsername(
                    username.trim().toLowerCase()
                )
        
            .orElseThrow(() ->
                new UsernameNotFoundException("User not found"));

        return User.builder()
            .username(user.getUsername())
            .password(user.getPassword())
            
            .build();
    }
}
