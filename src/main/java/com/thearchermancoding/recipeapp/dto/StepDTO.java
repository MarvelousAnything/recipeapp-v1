package com.thearchermancoding.recipeapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StepDTO {

    private Integer stepNumber;

    private String instruction;

    private List<RecipeIngredientDTO> ingredients;
}
