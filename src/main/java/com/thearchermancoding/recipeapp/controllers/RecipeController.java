package com.thearchermancoding.recipeapp.controllers;

import com.thearchermancoding.recipeapp.dto.RecipeDTO;
import com.thearchermancoding.recipeapp.models.Recipe;
import com.thearchermancoding.recipeapp.models.RecipeIngredient;
import com.thearchermancoding.recipeapp.services.RecipeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/recipe")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping
    @ResponseBody
    public Iterable<RecipeDTO> getAllRecipes() {
        return recipeService.getAllRecipes();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public RecipeDTO getRecipeById(@PathVariable(name = "id") Long id) {
        return recipeService.getRecipeById(id).get();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<RecipeDTO> createRecipe(@RequestBody RecipeDTO recipeDTO) {
        recipeService.createRecipe(recipeDTO);
        return new ResponseEntity<>(recipeDTO, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void deleteRecipeById(@PathVariable(name = "id") Long id) {
        recipeService.deleteRecipeById(id);
    }

    @DeleteMapping
    public void deleteRecipe(@RequestBody Recipe recipe) {
        recipeService.deleteRecipe(recipe);
    }

    @GetMapping("/{id}/averageRating")
    public Float getAverageRatingById(@PathVariable(name = "id") Long id) {
        return recipeService.getAverageRatingById(id).get();
    }
}
