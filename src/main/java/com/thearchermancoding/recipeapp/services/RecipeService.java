package com.thearchermancoding.recipeapp.services;

import com.thearchermancoding.recipeapp.dto.RecipeDTO;
import com.thearchermancoding.recipeapp.models.Rating;
import com.thearchermancoding.recipeapp.models.Recipe;
import com.thearchermancoding.recipeapp.repositories.RecipeRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class RecipeService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private RecipeRepository repository;

    public Iterable<RecipeDTO> getAllRecipes() {
        return StreamSupport
                .stream(repository.findAll().spliterator(), false)
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<RecipeDTO> getRecipeById(Long id) {
        return repository.findById(id).map(this::convertToDTO);
    }

    public void updateRecipe(RecipeDTO recipeDTO) {
        repository.save(convertToEntity(recipeDTO));
    }

    public Recipe createRecipe(RecipeDTO recipeDTO) {
        return repository.save(convertToEntity(recipeDTO));
    }

    public void deleteRecipeById(Long id) {
        repository.deleteById(id);
    }

    public void deleteRecipe(RecipeDTO recipeDTO) {
        repository.delete(convertToEntity(recipeDTO));
    }

    public void deleteRecipe(Recipe recipe) {
        repository.delete(recipe);
    }

    public Optional<Float> getAverageRatingById(Long id) {
        OptionalDouble average;
        Optional<Recipe> rating = repository.findById(id);
        if (rating.isPresent()) {
            average = rating.get()
                    .getRatings()
                    .stream()
                    .mapToDouble(Rating::getRating)
                    .average();
            if (average.isPresent()) {
                return Optional.of((float) average.getAsDouble());
            }
        }
        return Optional.empty();
    }

    public RecipeDTO convertToDTO(Recipe recipe) {
        return modelMapper.map(recipe, RecipeDTO.class);
    }

    public Recipe convertToEntity(RecipeDTO recipeDTO) {
        return modelMapper.map(recipeDTO, Recipe.class);
    }

}
