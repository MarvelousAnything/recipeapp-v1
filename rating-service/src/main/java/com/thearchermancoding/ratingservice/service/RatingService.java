package com.thearchermancoding.ratingservice.service;

import com.thearchermancoding.ratingservice.model.Rating;
import com.thearchermancoding.ratingservice.model.User;
import com.thearchermancoding.ratingservice.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class RatingService {

    @Autowired
    private RatingRepository repository;

    @Autowired
    private RestTemplate restTemplate;

    public List<Rating> findAll() {
        return repository.findAll();
    }

    public Optional<Rating> findById(Long id) {
        return repository.findById(id);
    }

    public void update(Rating rating) {
        repository.save(rating);
    }

    public Rating create(Rating rating) {
        return repository.save(rating);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public void delete(Rating rating) {
        repository.delete(rating);
    }

    public List<Rating> findAllByReviewerId(Long id) {
        return repository.findAllByReviewerId(id);
    }

    public List<Rating> findAllByRecipeId(Long id) {
        return repository.findAllByRecipeId(id);
    }

    public User findReviewer(Long ratingId) {
        return restTemplate.getForObject("http://USER-SERVICE/users/" + repository.findById(ratingId).get().getReviewerId(), User.class);
    }

}
