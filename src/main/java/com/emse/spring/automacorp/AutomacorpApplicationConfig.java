package com.emse.spring.automacorp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AutomacorpApplicationConfig {

    @Bean
    public CommandLineRunner greetingCommandLine() {
        return args -> {
            System.out.println("Hello, Spring!");
        };
    }
}
