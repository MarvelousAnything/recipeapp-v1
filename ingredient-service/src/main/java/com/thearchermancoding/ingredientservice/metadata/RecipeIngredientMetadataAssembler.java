package com.thearchermancoding.ingredientservice.metadata;

import com.thearchermancoding.ingredientservice.controller.RecipeIngredientController;
import com.thearchermancoding.ingredientservice.model.Ingredient;
import com.thearchermancoding.ingredientservice.model.RecipeIngredient;
import org.modelmapper.ModelMapper;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class RecipeIngredientMetadataAssembler extends RepresentationModelAssemblerSupport<RecipeIngredient, RecipeIngredientMetadata> {

    private final EntityLinks entityLinks;

    private final ModelMapper modelMapper;

    public RecipeIngredientMetadataAssembler(EntityLinks entityLinks, ModelMapper modelMapper) {
        super(RecipeIngredient.class, RecipeIngredientMetadata.class);
        this.entityLinks = entityLinks;
        this.modelMapper = modelMapper;
    }

    @Override
    public RecipeIngredientMetadata toModel(RecipeIngredient recipeIngredient) {
        RecipeIngredientMetadata recipeIngredientMetadata = this.modelMapper.map(recipeIngredient, RecipeIngredientMetadata.class);
        Link selfLink = this.entityLinks.linkToItemResource(RecipeIngredientMetadata.class, recipeIngredient.getId()).withSelfRel();
        // Link ingredientsLink = linkTo(methodOn(RecipeIngredientController.class).getAllIngredients()).withRel("ingredients");
        recipeIngredientMetadata.add(selfLink);
        return recipeIngredientMetadata;
    }

    public RecipeIngredient fromModel(RecipeIngredientMetadata recipeIngredientMetadata) {
        return this.modelMapper.map(recipeIngredientMetadata, RecipeIngredient.class);
    }
}
