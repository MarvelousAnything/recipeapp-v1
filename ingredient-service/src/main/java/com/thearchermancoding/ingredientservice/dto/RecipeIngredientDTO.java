package com.thearchermancoding.ingredientservice.dto;

import com.thearchermancoding.ingredientservice.model.RecipeIngredient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecipeIngredientDTO {

    private String name;

    private String description;

    private String unitName;

    private String unitVariable;

    private float amount;
}
