package com.security.security.service;

import com.security.security.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CryptographicService cryptographicService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByLogin(username).orElseThrow(() -> new UsernameNotFoundException("User not present"));
    }

    public void createUser(String login, String password) {
        userRepository.save(com.security.security.model.domain.User.builder().login(login)
                .password(cryptographicService.calculateSHA512(password)).build());
    }
}
