package com.thearchermancoding.ingredientservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.hateoas.config.EnableHypermediaSupport;

@SpringBootApplication
@EnableEurekaClient
@EnableHypermediaSupport(type = {EnableHypermediaSupport.HypermediaType.HAL})
public class IngredientServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(IngredientServiceApplication.class, args);
    }

}
