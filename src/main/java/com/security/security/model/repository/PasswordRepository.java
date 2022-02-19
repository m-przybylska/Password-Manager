package com.security.security.model.repository;

import com.security.security.model.domain.Password;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasswordRepository extends JpaRepository<Password, Integer> {
}
