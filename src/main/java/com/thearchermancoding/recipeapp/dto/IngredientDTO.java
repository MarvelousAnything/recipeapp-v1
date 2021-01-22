package com.thearchermancoding.recipeapp.dto;

import com.thearchermancoding.recipeapp.models.MeasuringUnit;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IngredientDTO {

    private Long id;

    private String name;

    private MeasuringUnit unit;

    private float amount;

}
