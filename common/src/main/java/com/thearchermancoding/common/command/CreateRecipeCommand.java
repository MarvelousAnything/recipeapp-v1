package com.thearchermancoding.common.command;

import com.thearchermancoding.common.dto.IngredientDTO;
import com.thearchermancoding.common.dto.StepDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.util.List;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class CreateRecipeCommand {

    @TargetAggregateIdentifier
    private final UUID recipeId;

    private final String title;

    private final String description;

    private final UUID authorId;

    private final List<StepDTO> steps;

    private final int prepTime;

    private final int servings;

}
