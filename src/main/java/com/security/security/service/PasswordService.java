package com.security.security.service;

import com.security.security.model.domain.Password;
import com.security.security.model.repository.PasswordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PasswordService {
    private final PasswordRepository passwordRepository;

    public List<Password> findAll() {
        return passwordRepository.findAll();
    }
}
