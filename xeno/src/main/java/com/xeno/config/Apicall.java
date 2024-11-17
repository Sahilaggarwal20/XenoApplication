package com.xeno.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Apicall {
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
