package com.thearchermancoding.recipeservice.repository;

import com.thearchermancoding.recipeservice.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, UUID> {
}
