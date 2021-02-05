package com.thearchermancoding.ingredientservice.controller;

import com.thearchermancoding.ingredientservice.dto.RecipeIngredientDTO;
import com.thearchermancoding.ingredientservice.service.RecipeIngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/ingredients")
public class IngredientController {

    @Autowired
    private RecipeIngredientService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public RecipeIngredientDTO createIngredient(@RequestBody RecipeIngredientDTO ingredientDTO) {
        return service.create(ingredientDTO);
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public RecipeIngredientDTO getIngredient(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @GetMapping
    @ResponseBody
    public List<RecipeIngredientDTO> getAllIngredients() {
        return service.findAll();
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable(name = "id") Long id) {
        service.deleteById(id);
    }

}
