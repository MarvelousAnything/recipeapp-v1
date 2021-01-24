package com.thearchermancoding.recipeapp.dto;

import com.thearchermancoding.recipeapp.models.RecipeIngredient;
import com.thearchermancoding.recipeapp.models.RecipeUser;
import com.thearchermancoding.recipeapp.models.Step;
import lombok.Getter;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;

import java.util.List;

@Getter
@Setter
public class RecipeDTO {

    private Long id;

    private String title;

    private String description;

    //private String author;

    private int prepTime;

    private int servings;

    private List<StepDTO> steps;

}
