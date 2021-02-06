package com.thearchermancoding.ratingservice.controller;

import com.thearchermancoding.ratingservice.model.Rating;
import com.thearchermancoding.ratingservice.model.User;
import com.thearchermancoding.ratingservice.service.RatingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/ratings")
@Slf4j
public class RatingController {

    @Autowired
    private RatingService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Rating createRating(@RequestBody Rating rating) {
        log.info("Creating Rating: " + rating.toString());
        return service.create(rating);
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<Rating> getRating(@PathVariable("id") Long id) {
        ResponseEntity<Rating> response = ResponseEntity.of(service.findById(id));
        log.info("Response from getRating(" + id + ") " + response.toString());
        if (response.getStatusCode().is4xxClientError()) {
            log.info("Returned Rating Object: " + service.findById(id).orElse(null));
        }
        return response;
    }

    @GetMapping
    @ResponseBody
    public List<Rating> getAllRatings() {
        return service.findAll();
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable(name = "id") Long id) {
        service.deleteById(id);
    }

    @GetMapping(value = "/{id}/user")
    @ResponseBody
    public User getReviewer(@PathVariable(name = "id") Long ratingId) {
        return service.findReviewer(ratingId);
    }

    @GetMapping(value = "/users/{id}")
    @ResponseBody
    public List<Rating> getAllRatingsByUserId(@PathVariable(value = "id") Long userId) {
        return service.findAllByReviewerId(userId);
    }

    @GetMapping(value = "/recipes/{recipeId}/averageRating")
    @ResponseBody
    public Double getAverageRecipeRating(@PathVariable(value = "recipeId") Long recipeId) {
        return service.findAverageRecipeRating(recipeId);
    }

    @GetMapping(value = "/recipes/{recipeId}")
    @ResponseBody
    public List<Rating> getAllRatingsByRecipeId(@PathVariable(value = "recipeId") Long recipeId) {
        return service.findAllByRecipeId(recipeId);
    }

}
