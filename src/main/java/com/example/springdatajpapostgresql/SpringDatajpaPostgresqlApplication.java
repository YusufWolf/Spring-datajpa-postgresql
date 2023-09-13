package com.example.springdatajpapostgresql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class SpringDatajpaPostgresqlApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringDatajpaPostgresqlApplication.class, args);
    }

}
