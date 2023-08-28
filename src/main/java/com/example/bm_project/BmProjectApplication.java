package com.example.bm_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BmProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(BmProjectApplication.class, args);
    }

}
