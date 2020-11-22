package com.thearchermancoding.recipeapp.repositories;

import com.thearchermancoding.recipeapp.models.RecipeIngredient;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeIngredientRepository extends CrudRepository<RecipeIngredient, Long>, JpaSpecificationExecutor<RecipeIngredient> {

}