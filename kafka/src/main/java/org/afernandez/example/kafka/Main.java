package org.afernandez.example.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        // Arranca la aplicación Spring Boot
        SpringApplication.run(Main.class, args);
        System.out.println("Hello, World! Spring Boot Application is running!");
    }
}
