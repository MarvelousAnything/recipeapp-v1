package com.thearchermancoding.recipeapp.dto;

import com.thearchermancoding.recipeapp.models.RecipeUser;
import com.thearchermancoding.recipeapp.models.Step;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RecipeDTO {

    private Long id;

    private String title;

    private String description;

    private RecipeUser author;

    private int prepTime;

    private int servings;

    private List<Step> steps;
}
