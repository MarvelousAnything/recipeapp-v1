package com.thearchermancoding.common.dto;

import lombok.Data;

import java.util.List;

@Data
public class StepDTO {

    private String instructions;

    private int stepNumber;

    private List<IngredientDTO> ingredients;

}
