package com.thearchermancoding.cloudgateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackMethodController {

    @GetMapping("/userServiceFallBack")
    public String userServiceFallBackMethod() {
        return "User Service is taking longer than Expected." +
                " Please try again later";
    }

    @GetMapping("/ingredientServiceFallBack")
    public String ingredientServiceFallBackMethod() {
        return "Ingredient Service is taking longer than Expected." +
                " Please try again later";
    }

    @GetMapping("/ratingServiceFallBack")
    public String ratingServiceFallBackMethod() {
        return "Rating Service is taking longer than Expected." +
                " Please try again later";
    }
}
