package com.thearchermancoding.recipeapp.controllers;

import com.thearchermancoding.recipeapp.models.Ingredient;
import com.thearchermancoding.recipeapp.services.IngredientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/v1/ingredient")
@RestController
public class IngredientController {
    private final IngredientServiceImpl service;

    @Autowired
    public IngredientController(IngredientServiceImpl service) {
        this.service = service;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Ingredient> getAllIngredients() {
        return service.findAll();
    }

    @GetMapping(path = "{id}")
    @ResponseStatus(HttpStatus.OK)
    public Ingredient getIngredientById(@PathVariable("id") Long id) {
        return service.findById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deleteIngredientById(@PathVariable("id") long id) {
        service.deleteById(id);
    }

    @PostMapping
    public void addIngredient(@RequestBody Ingredient ingredient) {
        service.save(ingredient);
    }
}
