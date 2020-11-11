package com.thearchermancoding.recipeapp.repositories;

import com.thearchermancoding.recipeapp.models.Recipe;
import com.thearchermancoding.recipeapp.models.RecipeIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Integer>, JpaSpecificationExecutor<Recipe> {
}