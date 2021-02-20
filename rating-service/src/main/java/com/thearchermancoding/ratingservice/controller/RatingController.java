package com.thearchermancoding.ratingservice.controller;

import com.thearchermancoding.ratingservice.assembler.RatingMetadataAssembler;
import com.thearchermancoding.ratingservice.metadata.RatingMetadata;
import com.thearchermancoding.ratingservice.metadata.UserMetadata;
import com.thearchermancoding.ratingservice.model.Rating;
import com.thearchermancoding.ratingservice.model.User;
import com.thearchermancoding.ratingservice.service.RatingService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/ratings")
@Slf4j
@AllArgsConstructor
@ExposesResourceFor(RatingMetadata.class)
public class RatingController {

    private final RatingService service;

    private final RatingMetadataAssembler ratingMetadataAssembler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Rating createRating(@RequestBody Rating rating) {
        return service.create(rating);
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public EntityModel<RatingMetadata> getRating(@PathVariable("id") Long id) {
        return EntityModel.of(this.ratingMetadataAssembler.toModel(this.service.findById(id).orElse(null)));
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<CollectionModel<RatingMetadata>> getAllRatings() {
        return ResponseEntity.ok(this.ratingMetadataAssembler.toCollectionModel(service.findAll()));
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable(name = "id") Long id) {
        service.deleteById(id);
    }

    /**
     * TODO: /{id}/user endpoint should not exist.
     * RatingMetadataAssembler should add a link to User resource at the user endpoint; there should be no user endpoint on Rating.
     * TODO: Should /{id}/user redirect to /users/{id} on user service? Possibly with backref.
     */
    @GetMapping(value = "/{id}/user")
    @ResponseBody
    public ResponseEntity<User> getReviewer(@PathVariable(name = "id") Long ratingId) {
        return ResponseEntity.of(service.findReviewer(ratingId));
    }

    @GetMapping(value = "/users/{id}")
    @ResponseBody
    public CollectionModel<RatingMetadata> getAllRatingsByUserId(@PathVariable(value = "id") Long userId) {
        return this.ratingMetadataAssembler.toCollectionModel(service.findAllByReviewerId(userId));
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
