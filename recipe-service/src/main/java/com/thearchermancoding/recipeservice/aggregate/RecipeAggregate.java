package com.thearchermancoding.recipeservice.aggregate;

import com.thearchermancoding.common.command.CreateRecipeCommand;
import com.thearchermancoding.common.event.RecipeCreatedEvent;
import com.thearchermancoding.recipeservice.model.Step;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.List;
import java.util.UUID;

@Aggregate
public class RecipeAggregate {

    @AggregateIdentifier
    private UUID id;

    private String title;

    private String description;

    private UUID authorId;

    private List<Step> steps;

    private int prepTime;

    private int servings;

    public RecipeAggregate() {
    }

    @CommandHandler
    public RecipeAggregate(CreateRecipeCommand createRecipeCommand) {
        AggregateLifecycle.apply(new RecipeCreatedEvent(createRecipeCommand.getRecipeId(), createRecipeCommand.getTitle(), createRecipeCommand.getDescription(), createRecipeCommand.getAuthorId(), createRecipeCommand.getSteps(), createRecipeCommand.getPrepTime(), createRecipeCommand.getServings()));
    }

    @EventSourcingHandler
    protected void on(RecipeCreatedEvent recipeCreatedEvent) {
        this.id = recipeCreatedEvent.getRecipeId();
        this.title = recipeCreatedEvent.getTitle();
        this.description = recipeCreatedEvent.getDescription();
        this.authorId = recipeCreatedEvent.getAuthorId();
        this.steps = recipeCreatedEvent.getSteps();
        this.prepTime = recipeCreatedEvent.getPrepTime();
        this.servings = recipeCreatedEvent.getServings();
    }

}
