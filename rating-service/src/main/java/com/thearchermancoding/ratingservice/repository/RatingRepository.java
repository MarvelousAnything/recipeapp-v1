package com.thearchermancoding.ratingservice.repository;

import com.thearchermancoding.ratingservice.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryRestResource(exported = false)
public interface RatingRepository extends JpaRepository<Rating, Long> {

    List<Rating> findAllByReviewerId(Long reviewerId);

    List<Rating> findAllByRecipeId(Long recipeId);

}