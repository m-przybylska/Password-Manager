package com.security.security.service;

import com.security.security.model.domain.Password;
import com.security.security.model.repository.PasswordRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Log
public class PasswordService {
    private final PasswordRepository passwordRepository;
    private final CryptographicService cryptographicService;

    public List<Password> findAll() {
        return passwordRepository.findAll();
    }

    public Optional<Password> findById(Integer id) {
        return passwordRepository.findById(id).stream().findFirst();
    }

    public List<Password> findByWebPage(String webPage) {
        return passwordRepository.findAllByWebPageContains(webPage);
    }

    public List<Password> findAllWithDecrypted(Password password) {
        return findAll().stream().map(e -> {
            if (password.getId().equals(e.getId())) {
                try {
                    e.setPassword(cryptographicService.decrypt(e.getPassword(),
                            cryptographicService.generateKey("kansmjdyhanbhczp")));
                } catch (Exception ex) {
                    log.severe(ex.getMessage());
                }
            }
            return e;
        }).collect(Collectors.toList());
    }

    public void deleteById(Integer id) {
        passwordRepository.deleteById(id);
    }

    public void save(Password password) throws Exception {
        password.setPassword(cryptographicService.encrypt(password.getPassword(),
                cryptographicService.generateKey("kansmjdyhanbhczp")));
        passwordRepository.save(password);
    }
}
