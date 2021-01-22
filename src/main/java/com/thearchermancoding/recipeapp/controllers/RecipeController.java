package com.thearchermancoding.recipeapp.controllers;

import com.thearchermancoding.recipeapp.dto.RecipeDTO;
import com.thearchermancoding.recipeapp.models.Recipe;
import com.thearchermancoding.recipeapp.models.RecipeIngredient;
import com.thearchermancoding.recipeapp.services.RecipeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/recipes")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private ModelMapper modelMapper;

    private RecipeDTO convertToDto(Recipe recipe) {
        RecipeDTO recipeDTO = modelMapper.map(recipe, RecipeDTO.class);
        recipeDTO.setAverageRating(recipeService.getAverageRatingById(recipeDTO.getId()).get());
        recipeDTO.setIngredients(recipeService
                .getRecipeById(recipeDTO.getId())
                .get()
                .getSteps()
                .stream()
                .flatMap(a -> a.getIngredients().stream())
                .collect(Collectors.toList()));
        return recipeDTO;
    }

    private Recipe convertToEntity(RecipeDTO recipeDTO) throws ParseException {
        Recipe recipe = modelMapper.map(recipeDTO, Recipe.class);

        return recipe;
    }
}
