package com.interview.ratings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BooksRatingsApplication {

    public static void main(String[] args) {
        SpringApplication.run(BooksRatingsApplication.class, args);
    }

}
