package com.yangb.weichatmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class WeichatmanagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeichatmanagerApplication.class, args);
    }
}
