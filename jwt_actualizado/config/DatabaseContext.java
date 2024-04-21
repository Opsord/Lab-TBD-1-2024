package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.sql2o.Sql2o;

@Configuration
public class DatabaseContext {

// felipe nameDB = "jvbc:postgresql://localhost:5432/EmergencyTBD"
    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String dbUser;

    @Value("${spring.datasource.password}")
    private String dbPass;

    @Bean
    public Sql2o sql2o(){
        return new Sql2o(dbUrl, dbUser, dbPass);
    }
}