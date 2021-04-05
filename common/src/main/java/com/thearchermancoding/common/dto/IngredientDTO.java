package com.thearchermancoding.common.dto;

import lombok.Data;

@Data
public class IngredientDTO {

    private String name;

    private String description;

    private String unitName;

    private String unitVariable;

    private double amount;

}
