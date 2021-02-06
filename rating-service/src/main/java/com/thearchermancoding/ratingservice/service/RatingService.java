package com.thearchermancoding.ratingservice.service;

import com.thearchermancoding.ratingservice.model.Rating;
import com.thearchermancoding.ratingservice.model.User;
import com.thearchermancoding.ratingservice.repository.RatingRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class RatingService {

    @Autowired
    private RatingRepository repository;

    @Autowired
    private RestTemplate restTemplate;

    public List<Rating> findAll() {
        return repository.findAll();
    }

    public Optional<Rating> findById(@PathVariable Long id) {
        log.info("Ratings exists at " + id + "?: " + repository.findById(id).isPresent());
        return repository.findById(id);
    }

    public void update(@RequestBody Rating rating) {
        repository.save(rating);
    }

    public Rating create(@RequestBody Rating rating) {
        log.info("Saving: " + rating.toString());
        return repository.save(rating);
    }

    public void deleteById(@PathVariable Long id) {
        repository.deleteById(id);
    }

    public void delete(@RequestBody Rating rating) {
        repository.delete(rating);
    }

    public List<Rating> findAllByReviewerId(@PathVariable Long id) {
        return repository.findAllByReviewerId(id);
    }

    public List<Rating> findAllByRecipeId(@PathVariable Long id) {
        return repository.findAllByRecipeId(id);
    }

    public User findReviewer(@PathVariable Long userId) {
        return restTemplate.getForObject("http://USER-SERVICE/users/" + repository.findById(userId).get().getReviewerId(), User.class);
    }

    public Double findAverageRecipeRating(@PathVariable Long recipeId) {
        return repository.findAllByRecipeId(recipeId)
                .stream()
                .mapToDouble(Rating::getRating)
                .average().orElse(-1.0);
    }

}
