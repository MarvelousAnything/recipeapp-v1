package com.thearchermancoding.ingredientservice.service;

import com.thearchermancoding.ingredientservice.model.RecipeIngredient;
import com.thearchermancoding.ingredientservice.repository.RecipeIngredientRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RecipeIngredientMetadataService {

    private final RecipeIngredientRepository repository;

    public RecipeIngredient fetchRecipeIngredient(Long id) {
        return this.repository.findById(id).orElse(null);
    }

    public List<RecipeIngredient> fetchAllIngredients() {
        return this.repository.findAll();
    }

    public RecipeIngredient save(RecipeIngredient recipeIngredient) {
        return this.repository.save(recipeIngredient);
    }

    public void delete(Long id) {
        this.repository.deleteById(id);
    }

}
