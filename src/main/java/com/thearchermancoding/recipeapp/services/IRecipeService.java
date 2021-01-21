package com.thearchermancoding.recipeapp.services;

import com.thearchermancoding.recipeapp.models.Recipe;

import java.util.List;
import java.util.Optional;

public interface IRecipeService {

    Iterable<Recipe> getAllRecipes();

    Optional<Recipe> getRecipeById(Long id);

    void updateRecipe(Recipe recipe);

    Recipe createRecipe(Recipe recipe);

    void deleteRecipeById(Long id);

    void deleteRecipe(Recipe recipe);
}
