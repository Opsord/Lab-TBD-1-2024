package com.example.demo.authentication.services;

import com.example.demo.authentication.entities.User;
import com.example.demo.services.VoluntarioServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    VoluntarioServices voluntarioService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return getUserByEmail(username);
    }

    public User getUserByEmail(String email) {
        return User.voluntarioToUser(voluntarioService.getCorreoVoluntario(email));
    }
}
