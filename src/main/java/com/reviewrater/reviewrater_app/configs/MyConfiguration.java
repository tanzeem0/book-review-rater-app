package com.reviewrater.reviewrater_app.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MyConfiguration {

    @Bean
    public RestTemplate getRestTemplate()
    {
        return new RestTemplate();
    }
}
