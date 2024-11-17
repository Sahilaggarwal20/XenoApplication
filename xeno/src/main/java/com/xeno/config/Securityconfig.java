package com.xeno.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class Securityconfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())  // Disable CSRF for APIs
            .authorizeHttpRequests(authz -> authz
                .requestMatchers("/login", "/").permitAll()  // Allow unauthenticated access to login and home page
                .requestMatchers("/api/**").permitAll()      // Allow API endpoints to be accessed without authentication
                .anyRequest().authenticated()               // Require authentication for all other requests
            )
            .oauth2Login(oauth2 -> oauth2
                .loginPage("/login")                      // Specify the login page
                .defaultSuccessUrl("/dashboard", true)    // Redirect to dashboard after login
            );

        return http.build();
    }
}
