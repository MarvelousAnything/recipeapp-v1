package com.thearchermancoding.common.event;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class RecipeIngredientCreatedEvent {

    private final UUID ingredientId;

    private final UUID stepId;

    private final String name;

    private final String description;

    private final String unitName;

    private final String unitVariable;

    private final double amount;

}
