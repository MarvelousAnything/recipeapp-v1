package com.thearchermancoding.recipeapp.services;

import com.thearchermancoding.recipeapp.models.Rating;
import com.thearchermancoding.recipeapp.models.Recipe;
import com.thearchermancoding.recipeapp.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

@Service
public class RecipeService {

    private RecipeRepository repository;

    @Autowired
    public RecipeService(RecipeRepository repository) {
        this.repository = repository;
    }

    public Iterable<Recipe> getAllRecipes() {
        return repository.findAll();
    }

    public Optional<Recipe> getRecipeById(Long id) {
        return repository.findById(id);
    }

    public void updateRecipe(Recipe recipe) {
        repository.save(recipe);
    }

    public Recipe createRecipe(Recipe recipe) {
        return repository.save(recipe);
    }

    public void deleteRecipeById(Long id) {
        repository.deleteById(id);
    }

    public void deleteRecipe(Recipe recipe) {
        repository.delete(recipe);
    }

    public Optional<Float> getAverageRatingById(Long id) {
        OptionalDouble average;
        Optional<Recipe> rating = repository.findById(id);
        if (rating.isPresent()) {
            average = rating.get().getRatings().stream().mapToDouble(Rating::getRating).average();
            if (average.isPresent()) {
                return Optional.of((float) average.getAsDouble());
            }
        }
        return Optional.empty();
    }
}
