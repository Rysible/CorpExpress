package com.corpexpressions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Bean
    CommandLineRunner printDbUser(@Value("${spring.datasource.username}") String user) {
        return args -> {
            System.out.println("Spring Boot is using DB user: " + user);
        };
    }
}


