package com.example.SoccerJava.configuration;

import com.example.SoccerJava.dao.RestTemplateResponseErrorHandler;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;


@Configuration
@EnableConfigurationProperties({ApiCallConfigurationProperties.class})
public class UiConfiguration {
    private final ApiCallConfigurationProperties properties;

    public UiConfiguration(ApiCallConfigurationProperties properties) {
        this.properties = properties;
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder){
        return restTemplateBuilder
                .requestFactory(HttpComponentsClientHttpRequestFactory.class)
                .errorHandler(new RestTemplateResponseErrorHandler()).build();
    }
}
