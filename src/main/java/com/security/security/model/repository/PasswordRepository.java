package com.security.security.model.repository;

import com.security.security.model.domain.Password;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PasswordRepository extends JpaRepository<Password, Integer> {
    List<Password> findAllByWebPageContains(String webPage);
}
