package com.thearchermancoding.recipeapp.config;

import com.thearchermancoding.recipeapp.dto.RecipeDTO;
import com.thearchermancoding.recipeapp.dto.RecipeIngredientDTO;
import com.thearchermancoding.recipeapp.dto.StepDTO;
import com.thearchermancoding.recipeapp.models.Recipe;
import com.thearchermancoding.recipeapp.models.RecipeIngredient;
import com.thearchermancoding.recipeapp.models.RecipeUser;
import com.thearchermancoding.recipeapp.models.Step;
import org.modelmapper.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper recipeMapper = new ModelMapper();
        recipeMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE);

        PropertyMap<RecipeIngredient, RecipeIngredientDTO> recipeIngredientMap = new PropertyMap<>() {
            @Override
            protected void configure() {
                map().setName(source.getIngredient().getName());
                map().setDescription(source.getIngredient().getDescription());
                map().setUnitName(source.getUnit().getUnitName());
                map().setUnitVariable(source.getUnit().getUnitVariable());
                map().setAmount(source.getAmount());
            }
        };

        TypeMap<Step, StepDTO> stepTypeMap = recipeMapper.createTypeMap(Step.class, StepDTO.class);

        Converter<List<RecipeIngredient>, List<RecipeIngredientDTO>> recipeIngredientConverter = new AbstractConverter<>() {
            @Override
            protected List<RecipeIngredientDTO> convert(List<RecipeIngredient> recipeIngredients) {
                return recipeIngredients.stream()
                        .map(recipeIngredient ->
                                recipeMapper.map(recipeIngredient, RecipeIngredientDTO.class))
                        .collect(Collectors.toList());
            }
        };

        stepTypeMap.addMappings(mapper -> mapper.using(recipeIngredientConverter));

        PropertyMap<Step, StepDTO> stepMap = new PropertyMap<>() {
            @Override
            protected void configure() {
                map().setStepNumber(source.getStepNumber());
                map().setInstruction(source.getInstruction());
            }
        };

        TypeMap<Recipe, RecipeDTO> recipeTypeMap = recipeMapper.createTypeMap(Recipe.class, RecipeDTO.class);

        Converter<List<Step>, List<StepDTO>> stepConverter = new AbstractConverter<>() {
            @Override
            protected List<StepDTO> convert(List<Step> steps) {
                return steps.stream()
                        .map(step ->
                                recipeMapper.map(step, StepDTO.class))
                        .collect(Collectors.toList());
            }
        };

        recipeTypeMap.addMappings(mapper -> mapper.using(stepConverter));

        PropertyMap<Recipe, RecipeDTO> recipeMap = new PropertyMap<>() {
            @Override
            protected void configure() {
                map().setTitle(source.getTitle());
                map().setDescription(source.getDescription());
                map().setPrepTime(source.getPrepTime());
                map().setServings(source.getServings());
            }
        };

        recipeMapper.addMappings(recipeIngredientMap);
        recipeMapper.addMappings(stepMap);
        recipeMapper.addMappings(recipeMap);

        return recipeMapper;
    }
}
