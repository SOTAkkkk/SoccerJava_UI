package com.example.SoccerJava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
//@ConfigurationPropertiesScan
public class SoccerJavaUiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoccerJavaUiApplication.class, args);
	}

}
