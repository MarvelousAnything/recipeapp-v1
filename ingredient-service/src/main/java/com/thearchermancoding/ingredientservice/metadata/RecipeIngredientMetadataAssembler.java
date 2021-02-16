package com.thearchermancoding.ingredientservice.metadata;

import com.thearchermancoding.ingredientservice.model.Ingredient;
import com.thearchermancoding.ingredientservice.model.MeasuringUnit;
import com.thearchermancoding.ingredientservice.model.RecipeIngredient;
import com.thearchermancoding.ingredientservice.repository.IngredientRepository;
import com.thearchermancoding.ingredientservice.repository.MeasuringUnitRepository;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@Component
public class RecipeIngredientMetadataAssembler extends RepresentationModelAssemblerSupport<RecipeIngredient, RecipeIngredientMetadata> {

    private final EntityLinks entityLinks;

    private final ModelMapper modelMapper;

    public RecipeIngredientMetadataAssembler(EntityLinks entityLinks, ModelMapper modelMapper, MeasuringUnitRepository measuringUnitRepository, IngredientRepository ingredientRepository) {
        super(RecipeIngredient.class, RecipeIngredientMetadata.class);
        this.entityLinks = entityLinks;
        this.modelMapper = modelMapper;
        Converter<RecipeIngredientMetadata, RecipeIngredient> handleNewRecipeIngredient = new Converter<RecipeIngredientMetadata, RecipeIngredient>() {
            @Override
            public RecipeIngredient convert(MappingContext<RecipeIngredientMetadata, RecipeIngredient> context) {
                MeasuringUnit unit = measuringUnitRepository.findDistinctByUnitVariableAndUnitName(
                        context.getSource().getUnitVariable(),
                        context.getSource().getUnitName())
                        .orElse(new MeasuringUnit(
                                context.getSource().getUnitVariable(),
                                context.getSource().getUnitName()));
                Ingredient ingredient = ingredientRepository.findDistinctByName(
                        context.getSource().getName())
                        .orElse(new Ingredient(
                                context.getSource().getName(),
                                context.getSource().getDescription()));
                measuringUnitRepository.save(unit);
                ingredientRepository.save(ingredient);
                RecipeIngredient recipeIngredient = new RecipeIngredient();
                recipeIngredient.setUnit(unit);
                recipeIngredient.setIngredient(ingredient);
                recipeIngredient.setAmount(context.getSource().getAmount());
                return recipeIngredient;
            }
        };
        this.modelMapper.createTypeMap(RecipeIngredientMetadata.class, RecipeIngredient.class).setConverter(handleNewRecipeIngredient);

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
