package com.thearchermancoding.ratingservice.controller;

import com.thearchermancoding.ratingservice.model.Rating;
import com.thearchermancoding.ratingservice.model.User;
import com.thearchermancoding.ratingservice.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/ratings")
public class RatingController {

    @Autowired
    private RatingService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Rating createRating(@RequestBody Rating rating) {
        return service.create(rating);
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public Rating getRating(@PathVariable("id") Long id) {
        return service.findById(id).orElse(null);
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

}
