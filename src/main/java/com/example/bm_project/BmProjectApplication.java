package com.example.bm_project;

import com.example.bm_project.logger.LoggerSingleton;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableCaching
public class BmProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(BmProjectApplication.class, args);}

}
