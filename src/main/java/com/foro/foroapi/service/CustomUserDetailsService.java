package com.foro.foroapi.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if ("admin".equals(username)) {
            return User.builder()
                    .username("admin")
                    // Contraseña "admin123" codificada con BCrypt
                    .password("$2a$10$jBh6XMmqz3nfuZeuodxm4eqdwTb8ntJnV6WPOT7xj.XMl1CWYjSAO")
                    .authorities(List.of(new SimpleGrantedAuthority("ROLE_USER")))
                    .build();
        }
        throw new UsernameNotFoundException("Usuario no encontrado: " + username);
    }
}
