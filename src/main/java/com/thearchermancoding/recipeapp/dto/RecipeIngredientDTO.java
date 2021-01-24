package com.thearchermancoding.recipeapp.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecipeIngredientDTO {

    private String name;

    private String description;

    private String unitName;

    private String unitVariable;

    private float amount;

}
