package com.thearchermancoding.recipeapp.services;

import com.thearchermancoding.recipeapp.models.Recipe;
import com.thearchermancoding.recipeapp.repositories.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService implements IRecipeService{

    private RecipeRepository repository;

    @Autowired
    public RecipeService(RecipeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Iterable<Recipe> getAllRecipes() {
        return repository.findAll();
    }

    @Override
    public Optional<Recipe> getRecipeById(Long id) {
        return repository.findById(id);
    }

    @Override
    public void updateRecipe(Recipe recipe) {
        repository.save(recipe);
    }

    @Override
    public Recipe createRecipe(Recipe recipe) {
        return repository.save(recipe);
    }

    @Override
    public void deleteRecipeById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteRecipe(Recipe recipe) {
        repository.delete(recipe);
    }


}
