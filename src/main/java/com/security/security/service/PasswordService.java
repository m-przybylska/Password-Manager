package com.security.security.service;

import com.security.security.model.domain.Password;
import com.security.security.model.repository.PasswordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PasswordService {
    private final PasswordRepository passwordRepository;

    public List<Password> findAll() {
        return passwordRepository.findAll();
    }

    public Optional<Password> findById(Integer id) {
        return passwordRepository.findById(id).stream().findFirst();
    }

    public List<Password> findByWebPage(String webPage) {
        return passwordRepository.findAllByWebPageContains(webPage);
    }

    public void deleteById(Integer id) {
        passwordRepository.deleteById(id);
    }

    public void save(Password password) {
        passwordRepository.save(password);
    }
}
