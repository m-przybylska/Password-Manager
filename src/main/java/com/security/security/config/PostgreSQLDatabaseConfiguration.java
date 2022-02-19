package com.security.security.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EntityScan(basePackages = "com.security.security.model.domain")
public class PostgreSQLDatabaseConfiguration {
}
