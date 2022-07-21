package com.pcloud.simplespringbootapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class SimpleSpringbootAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(SimpleSpringbootAppApplication.class, args);
    }
}
