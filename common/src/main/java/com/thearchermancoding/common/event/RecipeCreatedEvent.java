package com.thearchermancoding.common.event;

import com.thearchermancoding.common.dto.StepDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
@AllArgsConstructor
public class RecipeCreatedEvent {

    private final UUID recipeId;

    private final String title;

    private final String description;

    private final UUID authorId;

    private final List<StepDTO> steps;

    private final int prepTime;

    private final int servings;

}
