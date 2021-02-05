package com.thearchermancoding.ingredientservice.service;

import com.thearchermancoding.ingredientservice.dto.RecipeIngredientDTO;
import com.thearchermancoding.ingredientservice.model.RecipeIngredient;
import com.thearchermancoding.ingredientservice.repository.RecipeIngredientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RecipeIngredientService {

    @Autowired
    private RecipeIngredientRepository repository;

    @Autowired
    private ModelMapper mapper;


    public RecipeIngredientDTO create(RecipeIngredientDTO recipeIngredientDTO) {
        repository.save(convertToEntity(recipeIngredientDTO));
        return recipeIngredientDTO;
    }

    public List<RecipeIngredientDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public RecipeIngredientDTO findById(Long id) {
        return repository.findById(id).map(this::convertToDTO).orElse(null);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public RecipeIngredientDTO convertToDTO(RecipeIngredient recipeIngredient) {
        return mapper.map(recipeIngredient, RecipeIngredientDTO.class);
    }
    public RecipeIngredient convertToEntity(RecipeIngredientDTO recipeIngredientDTO) {
        return mapper.map(recipeIngredientDTO, RecipeIngredient.class);
    }
}
