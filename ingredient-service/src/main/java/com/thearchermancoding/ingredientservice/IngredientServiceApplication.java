package com.thearchermancoding.ingredientservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class IngredientServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(IngredientServiceApplication.class, args);
    }

}
