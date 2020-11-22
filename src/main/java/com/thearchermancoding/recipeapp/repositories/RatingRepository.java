package com.thearchermancoding.recipeapp.repositories;

import com.thearchermancoding.recipeapp.models.Rating;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RatingRepository extends CrudRepository<Rating, Long>, JpaSpecificationExecutor<Rating> {

}