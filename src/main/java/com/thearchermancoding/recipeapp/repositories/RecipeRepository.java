package com.thearchermancoding.recipeapp.repositories;

import com.thearchermancoding.recipeapp.models.Recipe;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends CrudRepository<Recipe, Long>, JpaSpecificationExecutor<Recipe> {
}