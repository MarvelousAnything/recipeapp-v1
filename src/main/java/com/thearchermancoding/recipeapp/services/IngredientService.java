package com.thearchermancoding.recipeapp.services;

import com.thearchermancoding.recipeapp.models.Ingredient;

import java.util.Optional;

public interface IngredientService extends GenericService<Ingredient, Long> {
    Optional<Ingredient> findById(Long id);

    Iterable<Ingredient> findAll();

    Iterable<Ingredient> findAllById(Iterable<Long> id);

    void deleteById(Long id);

    void delete(Ingredient ingredient);

    void deleteAll(Iterable<? extends Ingredient> ingredients);

    void deleteAll();
}
