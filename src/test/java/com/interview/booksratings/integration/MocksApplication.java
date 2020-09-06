package com.interview.booksratings.integration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.interview.ratings")
public class MocksApplication {
    public static void main(String[] args) {
        SpringApplication.run(MocksApplication.class, args);
    }
}