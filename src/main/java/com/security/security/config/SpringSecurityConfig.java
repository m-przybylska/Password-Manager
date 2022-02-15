package com.security.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        User.UserBuilder user = User.withDefaultPasswordEncoder();
        auth.inMemoryAuthentication()
                .withUser(user.username("admin").password("admin123").roles("ADMIN"))
                .withUser(user.username("client").password("client123").roles("ADMIN"));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .and()
                .formLogin().loginPage("/web/login/login-page")
                .loginProcessingUrl("/authenticateUser")
                .defaultSuccessUrl("/web/app/password/table").permitAll();
    }
}
