package com.thearchermancoding.common.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.UUID;

@Getter
@AllArgsConstructor
public class CreateRecipeIngredientCommand {

    @TargetAggregateIdentifier
    private final UUID ingredientId;

    private final UUID stepId;

    private final String name;

    private final String description;

    private final String unitName;

    private final String unitVariable;

    private final double amount;

}
