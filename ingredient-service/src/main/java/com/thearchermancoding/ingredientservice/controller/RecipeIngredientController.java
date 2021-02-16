package com.thearchermancoding.ingredientservice.controller;

import com.thearchermancoding.ingredientservice.metadata.RecipeIngredientMetadata;
import com.thearchermancoding.ingredientservice.metadata.RecipeIngredientMetadataAssembler;
import com.thearchermancoding.ingredientservice.model.RecipeIngredient;
import com.thearchermancoding.ingredientservice.service.RecipeIngredientMetadataService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.server.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(value = "/ingredients", produces = MediaTypes.HAL_JSON_VALUE)
@ExposesResourceFor(RecipeIngredientMetadata.class)
@AllArgsConstructor
public class RecipeIngredientController {

    private final RecipeIngredientMetadataService service;

    private final RecipeIngredientMetadataAssembler resourceAssembler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public RecipeIngredient createIngredient(@RequestBody RecipeIngredientMetadata recipeIngredientMetadata) {
        RecipeIngredient recipeIngredient = resourceAssembler.fromModel(recipeIngredientMetadata);
        return service.save(recipeIngredient);
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public EntityModel<RecipeIngredientMetadata> getIngredient(@PathVariable("id") Long id) {
        RecipeIngredient recipeIngredient = this.service.fetchRecipeIngredient(id);
        RecipeIngredientMetadata recipeIngredientMetadata = this.resourceAssembler.toModel(recipeIngredient);
        recipeIngredientMetadata.add(linkTo(methodOn(RecipeIngredientController.class).getAllIngredients()).withRel("ingredients"));
        return EntityModel.of(recipeIngredientMetadata);
    }

    @GetMapping
    @ResponseBody
    public CollectionModel<RecipeIngredientMetadata> getAllIngredients() {
        List<RecipeIngredient> recipeIngredients = this.service.fetchAllIngredients();
        CollectionModel<RecipeIngredientMetadata> collection = this.resourceAssembler.toCollectionModel(recipeIngredients);
        collection.add(linkTo(methodOn(RecipeIngredientController.class).getIngredient(null)).withRel("ingredient"));
        return collection;
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable(name = "id") Long id) {
        service.delete(id);
    }

}
