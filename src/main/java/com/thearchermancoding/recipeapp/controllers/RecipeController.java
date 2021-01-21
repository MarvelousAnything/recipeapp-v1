package com.thearchermancoding.recipeapp.controllers;

import com.thearchermancoding.recipeapp.services.IRecipeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/recipes")
public class RecipeController {

    @Autowired
    private IRecipeService recipeService;

    @Autowired
    private ModelMapper modelMapper;


}
